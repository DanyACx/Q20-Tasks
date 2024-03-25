package com.quipucamayoc.Q20Tasks.security;

public final class HelperString {

	public static byte[] hexToBytes(final String str) {
		int nBytes = str.length() / 2;
		byte[] bytes = new byte[nBytes];
		for (int i = 0; i < nBytes; i++) {
			bytes[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
		}
		return bytes;
	}

	public static String bytesToHex(final byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes)
			sb.append(String.format("%02x", b & 0xff));
		return sb.toString();
	}
}
