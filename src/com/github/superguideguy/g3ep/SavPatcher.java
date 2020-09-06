package com.github.superguideguy.g3ep;

public class SavPatcher {


	public void patchSav(byte[][] sav, Version savVersion, int currentZeroSection, byte[] patch) {
		int patchPointer = 0;
		while (patchPointer < patch.length) {
			int opcode = patch[patchPointer++];

		}
	}

}
