package com.github.superguideguy.g3sc;

import java.util.HashMap;

@SuppressWarnings("nls")
public class OpcodeListUnsafe {

	public static HashMap<String, Pair<Integer, byte[]>> namedOpcodes;
	
	private static void x(String s, int length, int...ints) {
		byte[] bytes = new byte[ints.length];
		for (int i = 0; i < ints.length; i++) {
			bytes[i] = (byte) ints[i];
		}
		if (namedOpcodes.containsKey(s)) throw new IllegalArgumentException("Repeated Opcode: " + s);
		namedOpcodes.put(s, new Pair<Integer, byte[]>(length, bytes));
	}
	
	static {
		// [[TODO]] Shared Opcodes
		namedOpcodes = new HashMap<String, Pair<Integer, byte[]>>();
		x("nop",					1, 0x00);
		x("nop1",					1, 0x01);
		x("end",					1, 0x02);
		x("return",					1, 0x03);
		x("call",					5, 0x04);
		x("goto",					5, 0x05);
		x("goto_if_lt",				6, 0x06, 0x00);
		x("goto_if_eq",				6, 0x06, 0x01);
		x("goto_if_gt",				6, 0x06, 0x02);
		x("goto_if_le",				6, 0x06, 0x03);
		x("goto_if_ge",				6, 0x06, 0x04);
		x("goto_if_ne",				6, 0x06, 0x05);
		x("call_if_lt",				6, 0x07, 0x00);
		x("call_if_eq",				6, 0x07, 0x01);
		x("call_if_gt",				6, 0x07, 0x02);
		x("call_if_le",				6, 0x07, 0x03);
		x("call_if_ge",				6, 0x07, 0x04);
		x("call_if_ne",				6, 0x07, 0x05);
		x("gotostd",				2, 0x08);
		x("callstd",				2, 0x09);
		x("gotostd_if_lt",			3, 0x0a, 0x00);
		x("gotostd_if_eq",			3, 0x0a, 0x01);
		x("gotostd_if_gt",			3, 0x0a, 0x02);
		x("gotostd_if_le",			3, 0x0a, 0x03);
		x("gotostd_if_ge",			3, 0x0a, 0x04);
		x("gotostd_if_ne",			3, 0x0a, 0x05);
		x("callstd_if_lt",			3, 0x0b, 0x00);
		x("callstd_if_eq",			3, 0x0b, 0x01);
		x("callstd_if_gt",			3, 0x0b, 0x02);
		x("callstd_if_le",			3, 0x0b, 0x03);
		x("callstd_if_ge",			3, 0x0b, 0x04);
		x("callstd_if_ne",			3, 0x0b, 0x05);
		// ...
		x("setmysteryeventstatus",	2, 0x0e);
		x("setbank32_imm",			6, 0x0f);
		x("setbank8_imm",			3, 0x10);
		x("writebytetoaddr_imm",	6, 0x11);
		x("setbank8_addr",			6, 0x12);
		x("writebytetoaddr_bank",	6, 0x13);
		x("copybanks",				3, 0x14);
		x("copybytes", 				9, 0x15);
		x("setvar",					5, 0x16);
		x("addvar",					5, 0x17);
		x("subvar",					5, 0x18);
		x("copyvar",				5, 0x19);
		x("setorcopyvar",			5, 0x1a);
		x("compare8_banktobank",	3, 0x1b);
		x("compare8_banktoimm",		3, 0x1c);
		x("compare8_banktoaddr",	6, 0x1d);
		x("compare8_addrtobank",	6, 0x1e);
		x("compare8_addrtoimm",		6, 0x1f);
		x("compare8_addrtoaddr",	9, 0x20);
		x("compare16_vartoimm",		5, 0x21);
		x("compare16_vartovar",		5, 0x22);
		x("callasm",				5, 0x23);
		x("gotoasm",				5, 0x24);
		x("special",				3, 0x25);
		x("specialvar",				5, 0x26);
		x("waitstate",				1, 0x27);
		x("delay",					3, 0x28);
		x("setflag",				3, 0x29);
		x("clearflag",				3, 0x2a);
		x("checkflag",				3, 0x2b);
		// ...
		x("playse",					3, 0x2f);
		x("waitse",					1, 0x30);
		x("playfanfare",			3, 0x31);
		x("waitfanfare",			1, 0x32);
		x("playbgm",				4, 0x33);
		x("savebgm",				3, 0x34);
		x("fadedefaultbgm",			1, 0x35);
		x("fadenewbgm",				3, 0x36);
		x("fadeoutbgm",				2, 0x37);
		x("fadeinbgm",				2, 0x38);
		x("warp",					8, 0x39);
		x("warpsilent",				8, 0x3a);
		x("warpdoor",				8, 0x3b);
		x("warphole",				3, 0x3c);
		x("warpteleport",			8, 0x3d);
		x("setwarp",				8, 0x3e);
		x("setdynamicwarp",			8, 0x3f);
		x("setdivewarp",			8, 0x40);
		x("setholewarp",			8, 0x41);
		x("getplayerxy",			5, 0x42);
		x("getpartysize",			1, 0x43);
		x("additem",				5, 0x44);
		x("removeitem",				5, 0x45);
		x("checkitemspace",			5, 0x46);
		x("checkitem",				5, 0x47);
		x("checkitemtype",			3, 0x48);
		x("addpcitem",				5, 0x49);
		x("checkpcitem",			5, 0x4a);
		// ...
		x("faceplayer",				1, 0x5a);
		// ...
		x("waitmessage",			1, 0x66);
		x("message",				5, 0x67);
		x("closemessage",			1, 0x68);
		x("lockall",				1, 0x69);
		x("lock",					1, 0x6a);
		x("releaseall",				1, 0x6b);
		x("release",				1, 0x6c);
		x("waitbuttonpress",		1, 0x6d);
		// ...
		x("setvirtualaddress",		5, 0xb8);
		x("virtual_goto", 			5, 0xb9);
		x("virtual_call",			5, 0xba);
		x("virtual_goto_if_lt",		6, 0xbb, 0x00);
		x("virtual_goto_if_eq",		6, 0xbb, 0x01);
		x("virtual_goto_if_gt",		6, 0xbb, 0x02);
		x("virtual_goto_if_le",		6, 0xbb, 0x03);
		x("virtual_goto_if_ge",		6, 0xbb, 0x04);
		x("virtual_goto_if_ne",		6, 0xbb, 0x05);
		x("virtual_call_if_lt",		6, 0xbc, 0x00);
		x("virtual_call_if_eq",		6, 0xbc, 0x01);
		x("virtual_call_if_gt",		6, 0xbc, 0x02);
		x("virtual_call_if_le",		6, 0xbc, 0x03);
		x("virtual_call_if_ge",		6, 0xbc, 0x04);
		x("virtual_call_if_ne",		6, 0xbc, 0x05);
		x("virtual_message",		5, 0xbd);
		// ...
		
		
		// [[TODO]] Opcodes with same names, different bytes
		
		// [[TODO]] Unique Opcodes
		
		
	}
	
}
