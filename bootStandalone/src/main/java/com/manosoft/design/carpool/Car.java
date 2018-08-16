package com.manosoft.design.carpool;

public class Car {
	static int i = 0;
	
	public Car(){
		i++;
	}
	
	@Override
	public String toString() {
		return "Car "+i;
	}
}
