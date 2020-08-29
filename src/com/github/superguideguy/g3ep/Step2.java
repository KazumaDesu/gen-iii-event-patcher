package com.github.superguideguy.g3ep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Step2 {

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

	private static String getGameCode(int game, int language, int version) {
		String gameCode = null;

		switch (game) {
			case 'V':
			case 'P':
				System.err
						.println("ERROR: Ruby and Sapphire do not have a MEvent Server. Pleasue use a supported ROM.");
				System.exit(0);
				break;

			case 'R':
				gameCode = "R";
				break;
			case 'G':
				gameCode = "G";
				break;
			case 'E':
				gameCode = "E";
				break;

			default:
				System.err.println("ERROR: Unrecognized Game Code. Please use a supported ROM.");
				System.exit(0);
		}

		switch (version) {
			case 1:
				if (game == 'E') {
					System.err.println(
							"ERROR: Game is allegedly Emerald, but reported version is v1.1. Please use a supported ROM.");
					System.exit(0);
				}
				//$FALL-THROUGH$
			case 0:
				gameCode = gameCode + "" + version;
				break;

			default:
				System.err.println("ERROR: Unrecognized Game SavVersion. Please use a supported ROM.");
				System.exit(0);
		}

		switch (language) {
			case 'E':
				gameCode = gameCode + "" + "E";
				break;

			default:
				System.err.println(
						"ERROR: Unrecognized Game Language. Only English is supported. Please use a supported ROM.");
				System.exit(0);
		}

		return gameCode;
	}

	static boolean step2(String[] args) throws IOException {
		// A: Read sourceRom bytes
		// B: Find target hex string
		/* Program start 0x7140, end 0x7182 (excl.)
		 * (0000 7140: 00 B5 02 1C 11 68 0C 48  81 42 17 D1 10 69 0F 21)
		 * (0000 7150: 08 40 00 28 12 D0 91 88  01 23 18 1C 08 40 00 28)
		 * (0000 7160: 0C D0 90 68 18 40 00 28  08 D0 91 89 18 1C 08 40)
		 * (0000 7170: 00 28 03 D0 01 20 02 E0  01 01 00 00 00 20 02 BC)
		 */
		// C: Modify target hex string (0x714C - 0x7173 incl. zeroed)
		// D: Write bytes to destRom

		byte[]	ROM			= Files.readAllBytes(Paths.get(args[0]));
		int		game		= ROM[0xAE];								// V = Ruby, P = Sapphire, R = FireRed, G = LeafGreen, E = Emerald
		int		language	= ROM[0xAF];								// E = English
		int		version		= ROM[0xBC];								// 0 = v1.0, 1 = v1.1
		String	gameCode	= getGameCode(game, language, version);

		switch (gameCode) {
			case "R0E":
			case "R1E":
			case "G0E":
				System.err.println(
						"ERROR: FireRed and LeafGreen v1.0 are currently unsupported. Please use a supported ROM.");
				System.exit(0);
				break;
			case "G1E":
				zeroOut(ROM, 0x144428, 0x144468);
				break;
			case "E0E":
				zeroOut(ROM, 0x1b6a0, 0x1b6ec);
				break;

			default:
				System.err.println("BUG: This code path should be inacccessable. Report to project maintainer.");
				System.exit(0);
		}

		Files.write(Paths.get(args[1]), ROM, StandardOpenOption.TRUNCATE_EXISTING);
		return (game == 'E');
	}

}
