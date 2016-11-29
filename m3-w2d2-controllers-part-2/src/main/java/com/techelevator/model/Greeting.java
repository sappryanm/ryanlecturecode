package com.techelevator.model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Greeting {
	private final String id;
	private final String content;
	
	public Greeting(String recipient) {
		this.id = UUID.randomUUID().toString();
		this.content = "Hello, " + recipient;
	}
	
	public String getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
}
