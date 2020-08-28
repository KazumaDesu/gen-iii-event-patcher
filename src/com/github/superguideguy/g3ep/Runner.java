package com.github.superguideguy.g3ep;

import java.io.IOException;

public class Runner {

	private static void step1(String[] args) throws IOException {
		// A: Read sourceRom bytes
		// B: Find target hex string 
		/* Program start 0x7140, end 0x7182 (excl.)
		 * (0000 7140: 00 B5 02 1C 11 68 0C 48  81 42 17 D1 10 69 0F 21)
		 * (0000 7150: 08 40 00 28 12 D0 91 88  01 23 18 1C 08 40 00 28)
		 * (0000 7160: 0C D0 90 68 18 40 00 28  08 D0 91 89 18 1C 08 40)
		 * (0000 7170: 00 28 03 D0 01 20 02 E0  01 01 00 00 00 20 02 BC)
		 * Emerald: 	PS=0x1b6a0, ZS=0x1b6ae, ZE=0x1b6d7, PE=0x1b6eb
		 * LeafGreen:	Search for "00b5 021c 1168 0c48 8142 17d1"
		 */
		// C: Modify target hex string (0x714C - 0x7173 incl. zeroed)
		// D: Write bytes to destRom


	}

	public static void main(String[] args) {

	}

}
