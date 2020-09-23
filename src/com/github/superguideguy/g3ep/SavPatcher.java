package com.github.superguideguy.g3ep;

public class SavPatcher {

	public static final int	SAVE_SECTION_LENGTH	= 0x1000;
	public static final int	SECTION_WRITABLE	= SAVE_SECTION_LENGTH - 128;
	public static final int	SECTIONS_PER_FILE	= 14;

	//===============================================================================================================//

	private static int getZeroSection(byte[][] sav) {
		int	counterA		= sav[0][0xFFC] + (sav[0][0xFFD] << 8) + (sav[0][0xFFE] << 16) + (sav[0][0xFFF] << 24);
		int	counterB		= sav[SECTIONS_PER_FILE][0xFFC] + (sav[SECTIONS_PER_FILE][0xFFD] << 8)
				+ (sav[SECTIONS_PER_FILE][0xFFE] << 16) + (sav[SECTIONS_PER_FILE][0xFFF] << 24);
		int	sectionSearch	= ((counterA > counterB) ? 0 : SECTIONS_PER_FILE);

		while (true) {
			if (sav[sectionSearch][0xFF4] == 0) break;
			sectionSearch++;
		}
		return sectionSearch;
	}

	private static int getPatchLength(int opcode) {
		int patchLength = 0;
		switch (opcode) {
			case SupportPackage.RS_BERRY:
				patchLength = 1328;
				break;
			case SupportPackage.EM_BERRY:
				patchLength = 52;
				break;
			case SupportPackage.C_TRAINER:
				patchLength = 188;
				break;
			case SupportPackage.JPN_NEWS:
				patchLength = 0xd0 + 20;
				break;
			case SupportPackage.INTL_NEWS:
				patchLength = 0x198 + 40;
				break;
			case SupportPackage.JPN_CARD:
				patchLength = 0x91 + 20;
				break;
			case SupportPackage.INTL_CARD:
				patchLength = 0x162 + 40;
				break;
			case SupportPackage.C_SCRIPT:
				patchLength = 1004;
				break;
			case SupportPackage.RECORD_ITEM:
				patchLength = 8;
				break;
			default:
				patchLength = 0;
		}
		return patchLength;
	}

	private static int getSavSection(int zeroSection, int desiredSection) {
		int allegedSection = zeroSection + desiredSection;
		allegedSection %= SECTIONS_PER_FILE;
		if (zeroSection >= SECTIONS_PER_FILE) allegedSection += SECTIONS_PER_FILE;
		return allegedSection;
	}

	private static boolean applyPatch(byte[] savSection, int savOffset, byte[] patch, int patchOffset, int length) {
		if (savSection == null) return false;
		if (savSection.length != SAVE_SECTION_LENGTH) return false;
		if (savOffset == 0) return false;
		if ((savOffset + length) > SAVE_SECTION_LENGTH) return false;

		if (patch == null) return false;
		if ((patchOffset + length) > patch.length) return false;
		if (length == 0) return false;

		for (int i = 0; i < length; i++) savSection[savOffset + i] = patch[patchOffset + i];
		return true;
	}

	private static void repairSavFile(byte[][] sav) {
		for (int i = 0; i < (2 * SECTIONS_PER_FILE); i++) {
			int checksum = 0;
			for (int j = 0; j < SECTION_WRITABLE; j++) checksum += ((sav[i][j] + 256) % 256) << ((j % 4) * 8);
			checksum = ((checksum >> 16) + checksum) & 0xFFFF;

			sav[i][0xFF6] = (byte) (checksum % 256);
			sav[i][0xFF7] = (byte) (checksum / 256);
		}
	}

	//===============================================================================================================//

	public static boolean patchSav(byte[][] sav, Version version, byte[] patch) {
		int			currentZeroSection	= getZeroSection(sav);
		boolean[]	patchesApplied		= new boolean[SupportPackage.NUM_FIELDS];
		int			patchPointer		= 0;

		// TODO Implement MG/ME bit setting
		// TODO Implement file header (see PatchCompatibility.ods on desktop)

		while (patchPointer < patch.length) {
			int opcode = patch[patchPointer++];
			patchPointer += version.supportByteLocation;
			boolean isSupported = (version.supportByteContents & patch[patchPointer]) > 0;
			patchPointer += 6 - version.supportByteLocation;

			int patchLength = getPatchLength(opcode);
			if (patchLength == 0) {
				System.err.println("Patch error 1");
				return false;
			}
			int savSection = getSavSection(currentZeroSection, version.sav.offsets[opcode] / 0x1000);

			if (isSupported) {
				boolean successfullyApplied = applyPatch(sav[savSection], version.sav.offsets[opcode] % 0x1000, patch,
						patchPointer, patchLength);
				if (successfullyApplied) patchesApplied[opcode] = true;
			}
			patchPointer += patchLength;
		}

		repairSavFile(sav);
		for (int i = 0; i < patchesApplied.length; i++) if (patchesApplied[i]) return true;
		return false;
	}

}
