package com.techelevator.controller;

public class User {
	enum AccessLevel {
		READ,
		WRITE,
		ADMIN
	}
	
	private AccessLevel level = AccessLevel.WRITE;
	
	public boolean canRead() {
		return level.compareTo(AccessLevel.READ) >= 0;
	}
	
	public boolean canWrite() {
		return level.compareTo(AccessLevel.WRITE) >= 0;
	}
	
	public boolean canAdmin() {
		return level.compareTo(AccessLevel.ADMIN) >= 0;
	}
}
