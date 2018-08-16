package com.manosoft.design.carpool;

public class PoolTest {
	public static void main(String[] args) {
		Pool pool = new PoolImpl();
		for(int i=0;i<6;i++){
			User user1 = new User();
			pool.subscribe(user1);
		}
	}
}
