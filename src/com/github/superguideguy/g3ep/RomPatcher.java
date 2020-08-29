package com.github.superguideguy.g3ep;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RomPatcher {

	static final int	GAME_CODE_LOCATION		= 0xAC;
	static final int	GAME_VERSION_LOCATION	= 0xBC;

	//====================================================================================================================//

	private static byte[] readRomFile(String romString) {
		Path	romPath	= Paths.get(romString);
		byte[]	romFile	= null;
		try {
			romFile = Files.readAllBytes(romPath);
		} catch (IOException e) {
			return null;
		}
		return romFile;
	}

	private static RomVersion getVersion(byte[] romData) {
		byte[] testCode = new byte[4];
		for (int i = 0; i < 4; i++) testCode[i] = romData[GAME_CODE_LOCATION + i];
		String testCodeString = null;
		try {
			testCodeString = new String(testCode, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		byte testVersion = romData[GAME_VERSION_LOCATION];

		for (RomVersion v : RomVersion.values())
			if ((testCodeString.equals(v.gameCode)) && (testVersion == v.version)) return v;
		return null;
	}

	private static void zeroOut(byte[] ROM, int startInclusive, int endExclusive) {
		for (int i = startInclusive; i < endExclusive; ++i) ROM[i] = 0;
		ROM[startInclusive + 0] = 0x00; // PUSH LR
		ROM[startInclusive + 1] = (byte) 0xb5;
		ROM[startInclusive + 2] = 0x01; // MOV r0, #0x1
		ROM[startInclusive + 3] = 0x20;
		ROM[startInclusive + 4] = 0x02; // POP r1
		ROM[startInclusive + 5] = (byte) 0xbc;
		ROM[startInclusive + 6] = 0x08; // BX r1
		ROM[startInclusive + 7] = 0x47;
	}

	private static boolean writeRomFile(String romString, byte[] data) {
		try (FileOutputStream fileOut = new FileOutputStream(romString)) {
			fileOut.write(data);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e1) {
			return false;
		}

		return true;
	}

	//====================================================================================================================//

	static boolean patchRom(String romStringOld, String romStringNew) {
		byte[] romData = readRomFile(romStringOld);
		if (romData == null) return false;
		RomVersion version = getVersion(romData);

		if (version == null) return false;
		zeroOut(romData, version.startInclusive, version.endExclusive);
		return writeRomFile(romStringNew, romData);
	}

	//====================================================================================================================//

	public static void main(String[] args) {
		if (patchRom(args[0], args[1])) return;
		System.err.println("An error occurred. Please check your ROM file and try again.");
	}

}

enum RomVersion {
	// ENGLISH_FIRERED_0
	// ENGLISH_FIRERED_1
	// ENGLISH_LEAFGREEN_0
	ENGLISH_LEAFGREEN_1("BPGE", (byte) 0x01, 0x144428, 0x144468),
	ENGLISH_EMERALD("BPEE", (byte) 0x00, 0x1b6a0, 0x1b6ec),;

	final String	gameCode;
	final byte		version;
	final int		startInclusive, endExclusive;

	RomVersion(String a, byte b, int c, int d) {
		gameCode = a;
		version = b;
		startInclusive = c;
		endExclusive = d;
	}
}