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

	FrenchRuby0,
	FrenchRuby1,
	FrenchSapphire0,
	FrenchSapphire1,
	FrenchFireRed,
	FrenchLeafGreen,
	FrenchEmerald		(false, "BPEF", 0x00, 26, SupportPackage.INTL_EM  ,     null,     null),

	ItalianRuby0,
	ItalianRuby1,
	ItalianSapphire0,
	ItalianSapphire1,
	ItalianFireRed,
	ItalianLeafGreen,
	ItalianEmerald		(false, "BPEI", 0x00, 33, SupportPackage.INTL_EM  ,     null,     null),

	GermanRuby0,
	GermanRuby1,
	GermanSapphire0,
	GermanSapphire1,
	GermanFireRed,
	GermanLeafGreen,
	GermanEmerald		(false, "BPED", 0x00, 40, SupportPackage.INTL_EM  ,     null,     null),

	SpanishRuby0,
	SpanishRuby1,
	SpanishSapphire0,
	SpanishSapphire1,
	SpanishFireRed,
	SpanishLeafGreen,
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
