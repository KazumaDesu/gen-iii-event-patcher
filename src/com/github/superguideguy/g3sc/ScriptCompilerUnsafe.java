package com.github.superguideguy.g3sc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import static com.github.superguideguy.g3sc.OpcodeListUnsafe.namedOpcodes;
import static com.github.superguideguy.g3sc.ParamList.namedParameters;
import static com.github.superguideguy.g3ec.ChecksumCreator.*;

public class ScriptCompilerUnsafe {
	
	HashMap<String, Integer> labels;
	byte[] compiledScript;
	
	public static void main(String[] args) {
		String[] lines = getLines(args[0]);
		ScriptCompilerUnsafe scu = new ScriptCompilerUnsafe(lines);
		try {
			Files.write(Paths.get(args[1]), scu.compiledScript);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ScriptCompilerUnsafe(String[] lines) {
		labels = setVirtualAddresses(lines);
		compiledScript = new byte[1004];
		
		// [[TODO]] accept rs-type scripts
		compiledScript[4] = 0x33;
		for (int i = 5; i <= 7; i++) compiledScript[i] = (byte) 0xff; 
		int counter = 8;
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("//")) continue; //$NON-NLS-1$
			if (lines[i].startsWith("$")) continue; //$NON-NLS-1$
			
			String[] instruction = lines[i].split(" ", 0); //$NON-NLS-1$
			String opcode = instruction[0];
			String[] parameters = new String[instruction.length - 1];
			for (int j = 0; j < parameters.length; j++) parameters[j] = instruction[j+1];
			byte[] bytecode = instructionToBytecode(opcode, parameters);
			
			for (int j = 0; j < bytecode.length; j++) compiledScript[counter++] = bytecode[j];
		}
		
		byte[] checksum = mysteryGiftChecksum(compiledScript, 4);
		compiledScript[0] = checksum[0];
		compiledScript[1] = checksum[1];
	}
	
	private static String[] getLines(String filePath) {
		String[] ret = new String[0];
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (int i = 0; i < lines.size(); i++) {
				String s = lines.get(i);
				if (s.strip().equals("")) { //$NON-NLS-1$
					lines.remove(i);
					continue;
				}
			}
			ret = lines.toArray(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	HashMap<String, Integer> setVirtualAddresses(String[] lines) {
		HashMap<String, Integer> ret = new HashMap<String, Integer>();
		int currentVirtualAddress = 0;
		
		if (lines[0].startsWith("setvirtualaddress")) { //$NON-NLS-1$
			String address = lines[0].split(" ")[1]; //$NON-NLS-1$
			if (address.startsWith("0x")) currentVirtualAddress = Integer.parseInt(address.substring(2), 16); //$NON-NLS-1$
			else currentVirtualAddress = Integer.parseInt(address);
		} else {
			throw new IllegalArgumentException("First line is not setvirtualaddress!"); //$NON-NLS-1$
		}
		
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith("//")) continue; //$NON-NLS-1$
			if (lines[i].startsWith("$")) { //$NON-NLS-1$
				ret.put(lines[i], currentVirtualAddress);
			} else if (lines[i].startsWith("giveitem")) { //$NON-NLS-1$
				currentVirtualAddress += 12;
			} else {
				if (namedOpcodes.get(lines[i].split(" ")[0]) == null) throw new IllegalStateException(lines[i]); //$NON-NLS-1$
				int length = namedOpcodes.get(lines[i].split(" ")[0]).getKey(); //$NON-NLS-1$
				currentVirtualAddress += length;
			}
		}
		
		return ret;
	}

	byte[] instructionToBytecode(String opcode, String...parameters) {
		byte[] ret = null;
		int counter = 0;
		
		if (opcode.equals("giveitem")) { //$NON-NLS-1$
			ret = new byte[12];
			byte[] a = instructionToBytecode("setorcopyvar", "0x8000", parameters[0]); //$NON-NLS-1$ //$NON-NLS-2$
			byte[] b = instructionToBytecode("setorcopyvar", "0x8001", parameters[1]); //$NON-NLS-1$ //$NON-NLS-2$
			byte[] c = instructionToBytecode("callstd", parameters[2]); //$NON-NLS-1$
			
			for (int i = 0; i < a.length; i++) ret[counter++] = a[i];
			for (int i = 0; i < b.length; i++) ret[counter++] = b[i];
			for (int i = 0; i < c.length; i++) ret[counter++] = c[i];
			return ret;
		}
		
		for (String s : namedOpcodes.keySet()) if (s.equals(opcode)) {
			Pair<Integer, byte[]> data = namedOpcodes.get(s);
			ret = new byte[data.getKey()];
			for (int i = 0; i < data.getValue().length; i++) ret[counter++] = data.getValue()[i];
		}
		
		outer: for (int i = 0; i < parameters.length; i++)  {
			if (parameters[i].startsWith("$")) { //$NON-NLS-1$
				int address = labels.get(parameters[i]);
				Param32 p = new Param32(address);
				for (int j = 0; j < 4; j++) ret[counter++] = p.get4byteValue()[j];
				continue outer;
			}
			if (parameters[i].startsWith("0x")) { //$NON-NLS-1$
				int parsed = Integer.parseInt(parameters[i].substring(2), 16);
				if (parameters[i].length() <= 4) {
					Param8 p8 = new Param8(parsed);
					ret[counter++] = p8.get1byteValue()[0];
				} else if (parameters[i].length() <= 6) {
					Param16 p16 = new Param16(parsed);
					for (int j = 0; j < 2; j++) ret[counter++] = p16.get2byteValue()[j];
				} else {
					Param32 p32 = new Param32(parsed);
					for (int j = 0; j < 4; j++) ret[counter++] = p32.get4byteValue()[j];
				}
				continue outer;
			}
			for (String s : namedParameters.keySet()) if (parameters[i].equals(s)) {
				Param32 p32 = namedParameters.get(s);
				
				if (p32 instanceof Param8) {
					Param8 p8 = (Param8) p32;
					ret[counter++] = p8.get1byteValue()[0];
				} else if (p32 instanceof Param16) {
					Param16 p16 = (Param16) p32;
					for (int j = 0; j < 2; j++) ret[counter++] = p16.get2byteValue()[j];
				} else {
					for (int j = 0; j < 4; j++) ret[counter++] = p32.get4byteValue()[j];
				}
				
				continue outer;
			}
			
			int parsed = Integer.parseInt(parameters[i]);
			Param8 p8 = new Param8(parsed);
			ret[counter++] = p8.get1byteValue()[0];
		}
			
		return ret;
	}
	
}