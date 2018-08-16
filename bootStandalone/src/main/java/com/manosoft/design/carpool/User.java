package com.manosoft.design.carpool;

public class User implements Subscriber{
	
	private Car car;
	
	public User() {
		this.car = new Car();
	}

	@Override
	public void publish(String msg) {
		System.out.println(msg);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
}
