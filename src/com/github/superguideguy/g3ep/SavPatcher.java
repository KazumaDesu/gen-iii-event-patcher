package com.github.superguideguy.g3ep;
// The reason this file looks different is because it was originally a stand-alone project

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SavPatcher {

	static final int	BLOCKS_PER_FILE		= 14;
	static final int	TOTAL_BLOCKS		= 32;
	static final int	BLOCK_SIZE			= 4096;
	static final int	BLOCK_WRITABLE		= BLOCK_SIZE - 128;

	static final int	WONDER_NEWS_LENGTH	= 0x1C0;
	static final int	WONDER_CARD_LENGTH	= 0x150;
	static final int	BUFFER_LENGTH		= 0x1EC;
	static final int	MYSTERY_GIFT_LENGTH	= 0x3EC;
	static final int	GAME_CODE_LOCATION	= 0x0AC;

	static final int	sCrc16Table[]		= {
			0x0000,
			0x1189,
			0x2312,
			0x329B,
			0x4624,
			0x57AD,
			0x6536,
			0x74BF,
			0x8C48,
			0x9DC1,
			0xAF5A,
			0xBED3,
			0xCA6C,
			0xDBE5,
			0xE97E,
			0xF8F7,
			0x1081,
			0x0108,
			0x3393,
			0x221A,
			0x56A5,
			0x472C,
			0x75B7,
			0x643E,
			0x9CC9,
			0x8D40,
			0xBFDB,
			0xAE52,
			0xDAED,
			0xCB64,
			0xF9FF,
			0xE876,
			0x2102,
			0x308B,
			0x0210,
			0x1399,
			0x6726,
			0x76AF,
			0x4434,
			0x55BD,
			0xAD4A,
			0xBCC3,
			0x8E58,
			0x9FD1,
			0xEB6E,
			0xFAE7,
			0xC87C,
			0xD9F5,
			0x3183,
			0x200A,
			0x1291,
			0x0318,
			0x77A7,
			0x662E,
			0x54B5,
			0x453C,
			0xBDCB,
			0xAC42,
			0x9ED9,
			0x8F50,
			0xFBEF,
			0xEA66,
			0xD8FD,
			0xC974,
			0x4204,
			0x538D,
			0x6116,
			0x709F,
			0x0420,
			0x15A9,
			0x2732,
			0x36BB,
			0xCE4C,
			0xDFC5,
			0xED5E,
			0xFCD7,
			0x8868,
			0x99E1,
			0xAB7A,
			0xBAF3,
			0x5285,
			0x430C,
			0x7197,
			0x601E,
			0x14A1,
			0x0528,
			0x37B3,
			0x263A,
			0xDECD,
			0xCF44,
			0xFDDF,
			0xEC56,
			0x98E9,
			0x8960,
			0xBBFB,
			0xAA72,
			0x6306,
			0x728F,
			0x4014,
			0x519D,
			0x2522,
			0x34AB,
			0x0630,
			0x17B9,
			0xEF4E,
			0xFEC7,
			0xCC5C,
			0xDDD5,
			0xA96A,
			0xB8E3,
			0x8A78,
			0x9BF1,
			0x7387,
			0x620E,
			0x5095,
			0x411C,
			0x35A3,
			0x242A,
			0x16B1,
			0x0738,
			0xFFCF,
			0xEE46,
			0xDCDD,
			0xCD54,
			0xB9EB,
			0xA862,
			0x9AF9,
			0x8B70,
			0x8408,
			0x9581,
			0xA71A,
			0xB693,
			0xC22C,
			0xD3A5,
			0xE13E,
			0xF0B7,
			0x0840,
			0x19C9,
			0x2B52,
			0x3ADB,
			0x4E64,
			0x5FED,
			0x6D76,
			0x7CFF,
			0x9489,
			0x8500,
			0xB79B,
			0xA612,
			0xD2AD,
			0xC324,
			0xF1BF,
			0xE036,
			0x18C1,
			0x0948,
			0x3BD3,
			0x2A5A,
			0x5EE5,
			0x4F6C,
			0x7DF7,
			0x6C7E,
			0xA50A,
			0xB483,
			0x8618,
			0x9791,
			0xE32E,
			0xF2A7,
			0xC03C,
			0xD1B5,
			0x2942,
			0x38CB,
			0x0A50,
			0x1BD9,
			0x6F66,
			0x7EEF,
			0x4C74,
			0x5DFD,
			0xB58B,
			0xA402,
			0x9699,
			0x8710,
			0xF3AF,
			0xE226,
			0xD0BD,
			0xC134,
			0x39C3,
			0x284A,
			0x1AD1,
			0x0B58,
			0x7FE7,
			0x6E6E,
			0x5CF5,
			0x4D7C,
			0xC60C,
			0xD785,
			0xE51E,
			0xF497,
			0x8028,
			0x91A1,
			0xA33A,
			0xB2B3,
			0x4A44,
			0x5BCD,
			0x6956,
			0x78DF,
			0x0C60,
			0x1DE9,
			0x2F72,
			0x3EFB,
			0xD68D,
			0xC704,
			0xF59F,
			0xE416,
			0x90A9,
			0x8120,
			0xB3BB,
			0xA232,
			0x5AC5,
			0x4B4C,
			0x79D7,
			0x685E,
			0x1CE1,
			0x0D68,
			0x3FF3,
			0x2E7A,
			0xE70E,
			0xF687,
			0xC41C,
			0xD595,
			0xA12A,
			0xB0A3,
			0x8238,
			0x93B1,
			0x6B46,
			0x7ACF,
			0x4854,
			0x59DD,
			0x2D62,
			0x3CEB,
			0x0E70,
			0x1FF9,
			0xF78F,
			0xE606,
			0xD49D,
			0xC514,
			0xB1AB,
			0xA022,
			0x92B9,
			0x8330,
			0x7BC7,
			0x6A4E,
			0x58D5,
			0x495C,
			0x3DE3,
			0x2C6A,
			0x1EF1,
			0x0F78, };



	private static byte[][] readSaveFile(String savString) {
		Path		savPath	= Paths.get(savString);
		byte[][]	data	= new byte[TOTAL_BLOCKS][BLOCK_SIZE];
		try {
			byte[] savFile = Files.readAllBytes(savPath);
			if (savFile.length < (TOTAL_BLOCKS * BLOCK_SIZE)) throw new IOException();
			for (int i = 0; i < TOTAL_BLOCKS; i++)
				for (int j = 0; j < BLOCK_SIZE; j++) data[i][j] = savFile[(BLOCK_SIZE * i) + j];
		} catch (IOException e) {
			return null;
		}
		return data;
	}

	private static int getSaveSection(byte[][] saveData, int section, boolean getBackupData) {
		int	counterA	= saveData[0][0xFFC] + (saveData[0][0xFFD] << 8) + (saveData[0][0xFFE] << 16)
				+ (saveData[0][0xFFF] << 24);
		int	counterB	= saveData[BLOCKS_PER_FILE][0xFFC] + (saveData[BLOCKS_PER_FILE][0xFFD] << 8)
				+ (saveData[BLOCKS_PER_FILE][0xFFE] << 16) + (saveData[BLOCKS_PER_FILE][0xFFF] << 24);
		int	dataStart	= (getBackupData) ? ((counterA < counterB) ? 0 : BLOCKS_PER_FILE)
				: ((counterA >= counterB) ? 0 : BLOCKS_PER_FILE);

		while (true) {
			if (saveData[dataStart][0xFF4] == section) break;
			dataStart++;
		}
		return dataStart;
	}

	private static Version getVersion(byte[][] saveData) {
		int		section0	= getSaveSection(saveData, 0, false);
		int		gameCode	= saveData[section0][GAME_CODE_LOCATION] + (saveData[section0][GAME_CODE_LOCATION + 1] << 8)
				+ (saveData[section0][GAME_CODE_LOCATION + 2] << 16)
				+ (saveData[section0][GAME_CODE_LOCATION + 3] << 24);

		Version	version		= null;
		if (gameCode != 0) version = Version.EMERALD;
		if (gameCode == 1) version = Version.FRLG;
		return version;
	}

	private static byte[] repairSaveBlock(final byte[] saveBlock) {
		int		checksum	= 0;
		byte[]	ret			= new byte[4096];
		for (int i = 0; i < BLOCK_WRITABLE; i++) {
			ret[i] = saveBlock[i];
			checksum += ((saveBlock[i] + 256) % 256) << ((i % 4) * 8);
		}

		checksum = ((checksum >> 16) + checksum) & 0xFFFF;

		ret[0xFF4] = saveBlock[0xFF4];
		ret[0xFF5] = saveBlock[0xFF5];
		ret[0xFF6] = (byte) (checksum % 256);
		ret[0xFF7] = (byte) (checksum / 256);

		ret[0xFF8] = 0x25;
		ret[0xFF9] = 0x20;
		ret[0xFFA] = 0x01;
		ret[0xFFB] = 0x08;

		ret[0xFFC] = saveBlock[0xFFC];
		ret[0xFFD] = saveBlock[0xFFD];
		ret[0xFFE] = saveBlock[0xFFE];
		ret[0xFFF] = saveBlock[0xFFF];

		return ret;
	}

	private static byte[] repairMysteryGift(final byte[] saveBlock, int offset, int length) {
		int crc = 0x1121;

		for (int i = 0; i < (length - 4); i++) {
			int temp = crc >> 8;
			crc ^= saveBlock[i + offset + 4];
			crc = temp ^ sCrc16Table[((crc % 256) + 256) % 256];
			crc &= 0xFFFF;
		}

		crc = ~crc;
		crc &= 0xFFFF;
		byte[] ret = new byte[2];
		ret[0] = (byte) (crc % 256);
		ret[1] = (byte) (crc / 256);

		return ret;
	}

	private static boolean writeSaveFile(String savString, byte[][] data) {
		byte[] savFile = new byte[TOTAL_BLOCKS * BLOCK_SIZE];
		for (int i = 0; i < savFile.length; i++) savFile[i] = data[i / BLOCK_SIZE][i % BLOCK_SIZE];

		try (FileOutputStream fileOut = new FileOutputStream(savString)) {
			fileOut.write(savFile);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e1) {
			return false;
		}

		return true;
	}



	static boolean patchSav(String savString, String binString) {
		byte[][] saveData = readSaveFile(savString);
		if (saveData == null) return false;
		Version version = getVersion(saveData);

		if (version == null) return false;
		int section2 = getSaveSection(saveData, 2, false);
		saveData[section2][version.mysteryGiftFlagByte] |= version.mysteryGiftFlagBit; // bit 1: 7654|3210
		saveData[section2] = repairSaveBlock(saveData[section2]);

		Path	binPath	= Paths.get(binString);
		byte[]	binData	= null;
		try {
			binData = Files.readAllBytes(binPath);
		} catch (IOException e) {
			return false;
		}

		int section4 = getSaveSection(saveData, 4, false);
		for (int i = 0; i < WONDER_NEWS_LENGTH; i++) saveData[section4][version.initialOffset + i] = binData[i];
		for (int j = WONDER_NEWS_LENGTH; j < (WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH); j++)
			saveData[section4][version.initialOffset + j] = binData[j];
		int priorLength = WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH + BUFFER_LENGTH;
		for (int k = priorLength; k < (priorLength + MYSTERY_GIFT_LENGTH); k++)
			saveData[section4][version.initialOffset + k] = binData[k];

		byte[] chksm = repairMysteryGift(saveData[section4], version.initialOffset, WONDER_NEWS_LENGTH);
		for (int i = 0; i < 2; i++) saveData[section4][version.initialOffset + i] = chksm[i];
		chksm = repairMysteryGift(saveData[section4], version.initialOffset + WONDER_NEWS_LENGTH, WONDER_CARD_LENGTH);
		for (int j = 0; j < 2; j++) saveData[section4][version.initialOffset + WONDER_NEWS_LENGTH + j] = chksm[j];
		chksm = repairMysteryGift(saveData[section4], version.initialOffset + priorLength, MYSTERY_GIFT_LENGTH);
		for (int k = 0; k < 2; k++) saveData[section4][version.initialOffset + priorLength + k] = chksm[k];
		saveData[section4] = repairSaveBlock(saveData[section4]);

		System.err.println(section4);

		return writeSaveFile(savString, saveData);
	}

	static boolean extractPatchFromSav(String savString, String binString) {
		byte[][] saveData = readSaveFile(savString);
		if (saveData == null) return false;
		Version version = getVersion(saveData);

		if (version == null) return false;
		int		section4	= getSaveSection(saveData, 4, false);
		byte[]	binData		= new byte[WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH + BUFFER_LENGTH + MYSTERY_GIFT_LENGTH];
		for (int i = 0; i < binData.length; i++) binData[i] = saveData[section4][version.initialOffset + i];
		for (int j = WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH; j < (WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH
				+ BUFFER_LENGTH); j++)
			binData[j] = 0;

		boolean tryBackup = true;
		for (int i = 0; i < binData.length; i++) if (binData[i] != 0) tryBackup = false;
		if (tryBackup) {
			section4 = getSaveSection(saveData, 4, true);
			for (int i = 0; i < binData.length; i++) binData[i] = saveData[section4][version.initialOffset + i];
			for (int j = WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH; j < (WONDER_NEWS_LENGTH + WONDER_CARD_LENGTH
					+ BUFFER_LENGTH); j++)
				binData[j] = 0;
		}

		try (FileOutputStream fileOut = new FileOutputStream(binString)) {
			fileOut.write(binData);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e1) {
			return false;
		}

		return true;
	}

}

enum Version {

	FRLG(0x067, 0x02, 0x2A0), // bit 1: 7654|3210
	EMERALD(0x40B, 0x08, 0x3AC); // bit 4

	final int	mysteryGiftFlagByte, mysteryGiftFlagBit;
	final int	initialOffset;

	Version(int a, int b, int c) {
		mysteryGiftFlagByte = a;
		mysteryGiftFlagBit = b;
		initialOffset = c;
	}

}