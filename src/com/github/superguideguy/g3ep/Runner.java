package com.github.superguideguy.g3ep;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		boolean isEmerald = Step2.step2(args); // 0 = srcROM, 1 = destROM
		Step3.step3(args); // 2 = srcSAV, 3 = destSAV
	}

}