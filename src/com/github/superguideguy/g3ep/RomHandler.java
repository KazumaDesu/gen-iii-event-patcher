package com.github.superguideguy.g3ep;

import java.io.UnsupportedEncodingException;

public class RomHandler {

	public static final int	GAME_CODE_LOCATION		= 0xac;
	public static final int	GAME_REVISION_LOCATION	= 0xbc;

	public Version getVersion(byte[] rom) {
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



}
