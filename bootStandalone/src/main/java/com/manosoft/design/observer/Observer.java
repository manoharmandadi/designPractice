package com.manosoft.design.observer;

public interface Observer {

	public void subscribe(Subject subject);
	public void unSubscribe(Subject subject);

}
