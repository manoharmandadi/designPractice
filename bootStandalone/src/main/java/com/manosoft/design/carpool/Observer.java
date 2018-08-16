package com.manosoft.design.carpool;

public interface Observer {

	public void subscribe(Subject subject);
	public void unSubscribe(Subject subject);

}
