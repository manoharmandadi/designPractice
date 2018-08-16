package com.manosoft.design.observer;

public class PoolTest {

	
	public static void main(String[] args) {
		Pool pool =  new Pool("Dell");
		
		User manohar = new User(pool, "Manohar");
		Car ponG6 = new Car("Pontiac","G6", manohar);
		manohar.setCar(ponG6);
		manohar.subscribe();
		
		pool.start();
		addWait(30000);
		
		User konda = new User(pool, "Konda");
		Car hondaCivic = new Car("Honda","Civic", konda);
		konda.setCar(hondaCivic);
		konda.subscribe();
		
		
		
		addWait(30000);
		
		User sudheer = new User(pool, "Sudheer");
		Car audiA6 = new Car("Audi","A6", sudheer);
		sudheer.setCar(audiA6);
		sudheer.subscribe();
		
		addWait(30000);
		
		User sunil = new User(pool, "Sunil");
		Car porscheCayman = new Car("Porsche","Cayman", sunil);
		sunil.setCar(porscheCayman);
		sunil.subscribe();
		
		addWait(30000);
		
		User ganta = new User(pool, "Neelima");
		Car toyotaCamry = new Car("Toyota","Camry", ganta);
		ganta.setCar(toyotaCamry);
		ganta.subscribe();
		
		addWait(30000);
		
		sunil.unSubscribe();
		
		addWait(30000);
		
		ganta.subscribe();
		
		sunil.unSubscribe();
		
		addWait(30000);
		
		sudheer.unSubscribe();
		
		addWait(30000);
		
		ganta.unSubscribe();
		
		addWait(30000);
		
		konda.unSubscribe();
		
		addWait(30000);
		
		manohar.unSubscribe();
	}
	
	private static void addWait(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
