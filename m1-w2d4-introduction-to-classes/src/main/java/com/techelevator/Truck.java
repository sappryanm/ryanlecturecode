package com.techelevator;

public class Truck extends Automobile {
	private boolean isHauling;
	
	private static final int TOP_SPEED_DRIVE = 100;
	private static final int TOP_SPEED_REVERSE = 10;
	
	public Truck() {
		isHauling = false;
	}
	
	public boolean attachBoat() {
		if(isHauling) {
			return false;
		} else {
			isHauling = true;
			return true;
		}
	}

	@Override
	public int accelerate() {
		if(isStarted()) {
			if(isReverse()) {
				currentSpeed = TOP_SPEED_REVERSE > currentSpeed + 1 ? currentSpeed + 1 : TOP_SPEED_REVERSE;
			} else {
				if (isHauling) {
					currentSpeed = TOP_SPEED_DRIVE > currentSpeed + 7 ? currentSpeed + 7 : TOP_SPEED_DRIVE;
				} else {
					currentSpeed = TOP_SPEED_DRIVE > currentSpeed + 10 ? currentSpeed + 10 : TOP_SPEED_DRIVE;
				}
			}
		}
		return currentSpeed;
	}
}
