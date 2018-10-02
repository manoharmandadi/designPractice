package com.manosoft.design.patterns.producerconsumer;

import java.util.List;

public class Producer implements Runnable{

	private List<Integer> arr;
	private int size;
	
	Producer(List<Integer> arr, int size){
		this.arr = arr;
		this.size = size;
	}
	
	public void run(){
		while(true){
			produce();
		}
	}
	public void produce(){
		synchronized (arr) {
		if(arr.size() < size){
			int randNum = (int) (Math.random()*100);
			System.out.println(Thread.currentThread().getName() +" is Generating Random Number:"+randNum);
			arr.add(randNum);
			arr.notifyAll();
			//Notify
		} else {
			try {
				System.out.println("Waiting for Consumer");
				arr.wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
				e.printStackTrace();
			}
		}
		}
	}
}
