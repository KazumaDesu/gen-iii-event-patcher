package com.github.superguideguy.g3ep;

/*
 * TODO Get locations for JPN_RS
 * TODO Get locations for JPN_FRLG
 * TODO Get locations for JPN_EM
 * TODO Confirm all INTL SAV files have identical structure
 * TODO Confirm 1st bit location for INTL_RS
 * TODO Confirm 2nd bit for INTL_RS is irrelevant
 * TODO Confirm 2nd bit for INTL_EM
 */
public enum SupportPackage {

	// @formatter:off

	//JPN_RS		(new int[][] {/* ??? */},
			//new int[] {______,0x0000,______,	0x0000,0x0000,0x0000,0x0000,	______,______}),
	//JPN_FRLG	(new int[][] {/* ??? */},
			//new int[] {0x0000,______,______,	0x42a0,0x0000,0x4384,0x0000,	______,0x0000}),
	//JPN_EM		(new int[][] {/* ??? */},
			//new int[] {0x0000,______,______,	0x43aC,0x0000,0x4490,0x0000,	______,______}),

	INTL_RS		(new int[][] {/*{0x23a9,4}*/},
			new int[] {0x42e0,0x0000,0x0498,	0x0000,0x0000,0x0000,0x0000,	0x4810,0x4bfc}),
	INTL_FRLG	(new int[][] {{0x2067,1}},
			new int[] {0x0000,0x426c,0x04a0,	0x0000,0x42a0,0x0000,0x4460,	0x479c,0x0000}),
	INTL_EM		(new int[][] {{0x240b,3},/*{0x2405,4}*/},
			new int[] {0x0000,0x4378,0x0bec,	0x0000,0x43ac,0x0000,0x456c,	0x48a8,0x4c94}),
	;
	// @formatter:on

	public final int[][]	requiredBitEnables;
	public final int[]		offsets;

	public static final int	RS_BERRY	= 0;
	public static final int	EM_BERRY	= 1;
	public static final int	C_TRAINER	= 2;
	public static final int	JPN_NEWS	= 3;
	public static final int	INTL_NEWS	= 4;
	public static final int	JPN_CARD	= 5;
	public static final int	INTL_CARD	= 6;
	public static final int	C_SCRIPT	= 7;
	public static final int	RECORD_ITEM	= 8;
	public static final int	NUM_FIELDS	= 9;

	SupportPackage(int[][] a, int[] b) {
		requiredBitEnables = a;
		offsets = b;
	}

}
