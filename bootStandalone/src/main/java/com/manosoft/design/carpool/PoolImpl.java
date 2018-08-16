package com.manosoft.design.carpool;

import java.util.ArrayList;
import java.util.List;

public class PoolImpl extends Thread implements Pool {

	private List<User> poolUsers = new ArrayList<User>();
	private static final int maxPoolSize = 4;
	
	@Override
	public void subscribe(User user) {
		if(poolUsers.size() < maxPoolSize){
			poolUsers.add(user);
		} else {
			System.out.println("Pool is Full");
		}
		if(poolUsers.size() > 1){
//			PoolImpl pool = new 
		}
	}
	
	@Override
	public void run() {
		for(User user : poolUsers){
			System.out.println("Pooling in car:"+user.getCar());
		}
	}
}
