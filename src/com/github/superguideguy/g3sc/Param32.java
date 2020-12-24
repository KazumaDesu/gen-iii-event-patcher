package com.github.superguideguy.g3sc;

class Param32 {
	final int value;
	public Param32(int i) {
		value = i;
	}
	public byte[] get4byteValue() {
		byte[] ret = new byte[4];
		ret[0] = (byte) (value % 256);
		ret[1] = (byte) ((value >> 8) % 256);
		ret[2] = (byte) ((value >> 16) % 256);
		ret[3] = (byte) ((value >> 24) % 256);
		return ret;
	}
}

class Param16 extends Param32 {
	public Param16(int i) {
		super(i);
	}
	public byte[] get2byteValue() {
		byte[] ret = new byte[2];
		ret[0] = (byte) (value % 256);
		ret[1] = (byte) ((value >> 8) % 256);
		return ret;
	}
}

class Param8 extends Param16 {
	public Param8(int i) {
		super(i);
	}
	public byte[] get1byteValue() {
		byte[] ret = new byte[1];
		ret[0] = (byte) (value % 256);
		return ret;
	}
}