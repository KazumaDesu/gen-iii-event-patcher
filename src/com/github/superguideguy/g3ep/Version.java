package com.github.superguideguy.g3ep;

public enum Version {

	// @formatter:off
	// bits are 7654|3210

	JapaneseRuby		(false, "AXVJ", 0x00,  0,                     null, 0x000000, 0x000000),
	JapaneseRubyBox		(false, null  , null,  1,                     null, 0x000000, 0x000000),
	JapaneseSapphire	(false, "AXPJ", 0x00,  2,                     null, 0x000000, 0x000000),
	JapaneseSapphireBox	(false,	null  , null,  3,                     null, 0x000000, 0x000000),
	JapaneseFireRed0	(false, "BPRJ", 0x00,  4,                     null,     null,     null),
	JapaneseFireRed1	(false, "BPRJ", 0x01,  5,                     null,     null,     null),
	JapaneseLeafGreen0	(false, "BPGJ", 0x00,  6,                     null,     null,     null),
	JapaneseLeafGreen1	(false, "BPGJ", 0x01,  7,                     null,     null,     null),
	JapaneseEmerald		(false, "BPEJ", 0x00,  8,                     null,     null,     null),

	EnglishRuby0		(true , "AXVE", 0x00,  9, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishRuby1		(true , "AXVE", 0x01, 10, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishRuby2		(true , "AXVE", 0x02, 11, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishSapphire0	(true , "AXPE", 0x00, 12, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishSapphire1	(true , "AXPE", 0x01, 13, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishSapphire2	(true , "AXPE", 0x02, 14, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	EnglishFireRed0		(false, "BPRE", 0x00, 15, SupportPackage.INTL_FRLG,     null,     null),
	EnglishFireRed1		(true , "BPRE", 0x01, 16, SupportPackage.INTL_FRLG, 0x14444c, 0x14448c),
	EnglishLeafGreen0	(false, "BPGE", 0x00, 17, SupportPackage.INTL_FRLG,     null,     null),
	EnglishLeafGreen1	(true , "BPGE", 0x01, 18, SupportPackage.INTL_FRLG, 0x144428, 0x144468),
	EnglishEmerald		(true , "BPEE", 0x00, 19, SupportPackage.INTL_EM  , 0x01b6a0, 0x01b6ec),

	FrenchRuby0			(true , "AXVF", 0x00, 20, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	FrenchRuby1			(true , "AXVF", 0x01, 21, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	FrenchSapphire0		(true , "AXPF", 0x00, 22, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	FrenchSapphire1		(true , "AXPF", 0x01, 23, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	FrenchFireRed		(false, "BPRF", 0x00, 24, SupportPackage.INTL_FRLG,     null,     null),
	FrenchLeafGreen		(false, "BPGF", 0x00, 25, SupportPackage.INTL_FRLG,     null,     null),
	FrenchEmerald		(false, "BPEF", 0x00, 26, SupportPackage.INTL_EM  ,     null,     null),

	ItalianRuby0		(true , "AXVI", 0x00, 27, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	ItalianRuby1		(true , "AXVI", 0x01, 28, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	ItalianSapphire0	(true , "AXPI", 0x00, 29, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	ItalianSapphire1	(true , "AXPI", 0x01, 30, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	ItalianFireRed		(false, "BPRI", 0x00, 31, SupportPackage.INTL_FRLG,     null,     null),
	ItalianLeafGreen	(false, "BPGI", 0x00, 32, SupportPackage.INTL_FRLG,     null,     null),
	ItalianEmerald		(false, "BPEI", 0x00, 33, SupportPackage.INTL_EM  ,     null,     null),

	GermanRuby0			(true , "AXVD", 0x00, 34, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	GermanRuby1			(true , "AXVD", 0x01, 35, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	GermanSapphire0		(true , "AXPD", 0x00, 36, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	GermanSapphire1		(true , "AXPD", 0x01, 37, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	GermanFireRed		(false, "BPRD", 0x00, 38, SupportPackage.INTL_FRLG,     null,     null),
	GermanLeafGreen		(false, "BPGD", 0x00, 39, SupportPackage.INTL_FRLG,     null,     null),
	GermanEmerald		(false, "BPED", 0x00, 40, SupportPackage.INTL_EM  ,     null,     null),

	SpanishRuby0		(true , "AXVS", 0x00, 41, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	SpanishRuby1		(true , "AXVS", 0x01, 42, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	SpanishSapphire0	(true , "AXPS", 0x00, 43, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	SpanishSapphire1	(true , "AXPS", 0x01, 44, SupportPackage.INTL_RS  , 0x000000, 0x000000),
	SpanishFireRed		(false, "BPRS", 0x00, 45, SupportPackage.INTL_FRLG,     null,     null),
	SpanishLeafGreen	(false, "BPGS", 0x00, 46, SupportPackage.INTL_FRLG,     null,     null),
	SpanishEmerald		(false, "BPES", 0x00, 47, SupportPackage.INTL_EM  ,     null,     null),

	;
	// @formatter:on

	public final boolean		isCurrentlySupported;
	public final String			expectedGameCode;
	public final Byte			expectedRevisionNumber;
	public final Integer		supportByteLocation;
	public final Byte			supportByteContents;
	public final SupportPackage	sav;
	public final Integer		romVmechStart;
	public final Integer		romVmechEnd;

	Version(boolean a, String b, Integer c, Integer d, SupportPackage e, Integer f, Integer g) {
		isCurrentlySupported = a;
		supportByteLocation = d / 8;
		supportByteContents = (byte) (1 << (d % 8));
		if (a) {
			expectedGameCode = b;
			expectedRevisionNumber = (byte) ((int) c);
			sav = e;
			romVmechStart = f;
			romVmechEnd = g;
		} else {
			expectedGameCode = null;
			expectedRevisionNumber = null;
			sav = null;
			romVmechStart = null;
			romVmechEnd = null;
		}
	}



}
