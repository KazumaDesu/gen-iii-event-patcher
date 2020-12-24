package com.github.superguideguy.g3ep;

import java.io.UnsupportedEncodingException;

public class RomHandler {

	public static final int	GAME_CODE_LOCATION		= 0xac;
	public static final int	GAME_REVISION_LOCATION	= 0xbc;

	public static Version getVersion(byte[] rom) {
		byte[] testCode = new byte[4];
		for (int i = 0; i < 4; i++) testCode[i] = rom[GAME_CODE_LOCATION + i];
		String testCodeString = null;
		try {
			testCodeString = new String(testCode, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}

		for (Version v : Version.values()) {
			if ((testCodeString.equalsIgnoreCase(v.expectedGameCode))
					&& (rom[GAME_REVISION_LOCATION] == v.expectedRevisionNumber))
				return v;
		}
		return null;
	}

	//===============================================================================================================//

	public static boolean patchRom(byte[] rom) {
		Version version = getVersion(rom);
		if (!version.isCurrentlySupported) return false;
		if (version.romVmechStart == null) return false;
		if (version.romVmechStart == 0) return false;

		for (int i = version.romVmechStart; i < version.romVmechEnd; i++) rom[i] = 0x00;
		rom[version.romVmechStart + 0] = 0x00; // PUSH LR
		rom[version.romVmechStart + 1] = (byte) 0xb5;
		rom[version.romVmechStart + 2] = 0x01; // MOV r0, #0x1
		rom[version.romVmechStart + 3] = 0x20;
		rom[version.romVmechStart + 4] = 0x02; // POP r1
		rom[version.romVmechStart + 5] = (byte) 0xbc;
		rom[version.romVmechStart + 6] = 0x08; // BX r1
		rom[version.romVmechStart + 7] = 0x47;
		return true;
	}

}
