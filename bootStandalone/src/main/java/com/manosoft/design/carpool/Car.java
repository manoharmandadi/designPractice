package com.manosoft.design.carpool;

public class Car {
	private String make;
	private String model;
	private User user;
	
	public Car(String make, String model, User user) {
		this.make = make;
		this.model = model;
		this.user = user;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return user.toString()+":"+ make+" "+model;
	}
}
