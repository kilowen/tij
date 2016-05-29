package com.chang.sharingresources;

public class SerialNumberGenerator {
	private static int serialNumber = 0;

	public synchronized static int nextSerialNumber() {
		return serialNumber++; // Not thread-safe
	}
}