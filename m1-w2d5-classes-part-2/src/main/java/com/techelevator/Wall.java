package com.techelevator;

public class Wall {
	private int width;
	private int height;
	
	public Wall() {
		width = 0;
		height = 0;
	}
	
	public Wall(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getArea() {
		return width * height;
	}
}
