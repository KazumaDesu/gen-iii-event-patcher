package com.github.superguideguy.g3ep;

import java.io.IOException;

public class PersonalPatcher {

	public static void main(String[] args) throws IOException {
		Step3.step3(args, 0); // 2 = srcSAV, 3 = destSAV
		SavPatcher.patchSav(args[1], args[2]);
	}

}
