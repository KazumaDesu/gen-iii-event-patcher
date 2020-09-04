package com.github.superguideguy.g3ep;

public enum Version {

	// @formatter:off
	// bits are 7654|3210

	JapaneseRuby,
	JapaneseRubyBox,
	JapaneseSapphire,
	JapaneseSapphireBox	(new int[][] {{0x0000,0x00},{0x0000,0x00}}, 0x0000,0x0000,0x0000, 0x0000,0x0000,0x0000,0x0000, 0x0000,0x0000), // TODO
	JapaneseFireRed0,
	JapaneseFireRed1,
	JapaneseLeafGreen0,
	JapaneseLeafGreen1,
	JapaneseEmerald,

	EnglishRuby0,
	EnglishRuby1,
	EnglishRuby2,
	EnglishSapphire0,
	EnglishSapphire1,
	EnglishSapphire2,
	EnglishFireRed0,
	EnglishFireRed1,
	EnglishLeafGreen0,
	EnglishLeafGreen1,
	EnglishEmerald		(new int[][] {{0x2405,0x40},{0x240B,0x08}}, 0x0000,0x4378,0x0BEC, 0x0000,0x43AC,0x0000,0x4490, 0x48A8,0x4C94),

	FrenchRuby0,
	FrenchRuby1,
	FrenchSapphire0,
	FrenchSapphire1,
	FrenchFireRed,
	FrenchLeafGreen,
	FrenchEmerald,

	ItalianRuby0,
	ItalianRuby1,
	ItalianSapphire0,
	ItalianSapphire1,
	ItalianFireRed,
	ItalianLeafGreen,
	ItalianEmerald,

	GermanRuby0,
	GermanRuby1,
	GermanSapphire0,
	GermanSapphire1,
	GermanFireRed,
	GermanLeafGreen,
	GermanEmerald,

	SpanishRuby0,
	SpanishRuby1,
	SpanishSapphire0,
	SpanishSapphire1,
	SpanishFireRed,
	SpanishLeafGreen,
	SpanishEmerald,

	;

	public final int[][] enableBits;
	public final int rsBerryOffset;
	public final int frlgBerryOffset;
	public final int trainerOffset;
	public final int jpnWonderNewsOffset;
	public final int intlWonderNewsOffset;
	public final int jpnWonderCardOffset;
	public final int intlWonderCardOffset;
	public final int eventScriptOffset;
	public final int recordItemOffset;

	Version(int[][] eB, int...ints) {
		enableBits = eB;

		rsBerryOffset = ints[0];
		frlgBerryOffset = ints[1];
		trainerOffset = ints[2];

		jpnWonderNewsOffset = ints[3];
		intlWonderNewsOffset = ints[4];
		jpnWonderCardOffset = ints[5];
		intlWonderCardOffset = ints[6];

		eventScriptOffset = ints[7];
		recordItemOffset = ints[8];
	}

	// @formatter:on

}
