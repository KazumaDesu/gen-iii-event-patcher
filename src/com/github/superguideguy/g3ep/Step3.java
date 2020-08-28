package com.github.superguideguy.g3ep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Step3 {

	private static void organizeSavBlock(byte[][] data, int start) {
		byte[][] temp = new byte[14][4096];
		for (int i = 0; i < temp.length; ++i) for (int j = 0; j < temp[i].length; ++j) temp[i][j] = data[i + start][j];

		for (int i = 0; i < temp.length; ++i) {
			int actual = temp[i][0xFF4];
			for (int j = 0; j < temp[i].length; ++j) data[actual + start][j] = temp[i][j];
		}
	}

	private static void organizeSavFile(byte[][] data) {
		int file[] = new int[2];
		for (int i = 0; i < file.length; ++i)
			for (int j = 0; j < 4; ++j) file[i] += Byte.toUnsignedInt(data[14 * i][0xFFC + j]) << (8 * j);

		if (file[1] > file[0]) {
			byte[][] temp = new byte[28][4096];
			for (int i = 0; i < temp.length; ++i) for (int j = 0; j < temp[i].length; ++j) temp[i][j] = data[i][j];
			for (int i = 0; i < (temp.length / 2); ++i) for (int j = 0; j < temp[i].length; ++j) {
				data[i][j] = temp[i + (temp.length / 2)][j];
				data[i + (temp.length / 2)][j] = temp[i][j];
			}
		}

		for (int i = 29; i < data.length; ++i) for (int j = 0; j < data[i].length; ++j) data[i][j] = (byte) 0xFF;
	}

	static void step3(String[] args) throws IOException {
		byte[] SAV_1 = Files.readAllBytes(Paths.get(args[2]));
		if (SAV_1.length != (32 * 4096)) {
			System.err.println("ERROR: SAV file has incorrect length.");
			System.exit(0);
		}
		byte[][] SAV_2 = new byte[32][4096];
		for (int i = 0; (i < SAV_1.length) && (i < (32 * 4096)); ++i) SAV_2[i / 4096][i % 4096] = SAV_1[i];

		organizeSavBlock(SAV_2, 0);
		organizeSavBlock(SAV_2, 14);
		organizeSavFile(SAV_2);

		Files.write(Paths.get(args[3]), SAV_2[0], StandardOpenOption.TRUNCATE_EXISTING);
		for (int i = 1; i < SAV_2.length; ++i) Files.write(Paths.get(args[3]), SAV_2[i], StandardOpenOption.APPEND);
	}

}
