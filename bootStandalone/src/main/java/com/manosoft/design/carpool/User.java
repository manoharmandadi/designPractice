package com.manosoft.design.carpool;

public class User implements Subject {

	private Observer observer;
	private String name; 
	private Car car;
	
	public User(Observer observer, String name) {
		this.observer = observer;
		this.name = name;
	}
	
	public void subscribe(){
//		System.out.println(name+ "is subscribing to "+observer);
		observer.subscribe(this);
	}

	
	public void unSubscribe(){
//		System.out.println(name+ "is subscribing to "+observer);
		observer.unSubscribe(this);
	}

	@Override
	public void update(Subject subject) {
		System.out.println(name+" today, You are pooling with :"+subject);
	}

	
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
