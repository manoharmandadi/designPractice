package com.manosoft.design.patterns.producerconsumer;

import java.util.List;

public class Consumer implements Runnable{
	
	private List<Integer> arr;
	private int size;
	
	Consumer(List<Integer> arr, int size){
		this.arr = arr;
		this.size = size;
	}
	
	public void run(){
		while(true){
			consume();
		}
	}

	public void consume(){
		//Consume code here
		synchronized (arr) {
		if(arr.size() > 0){
				int number = arr.remove(arr.size()-1);
				System.out.println(Thread.currentThread().getName()+" is Consuming Number:"+number);
				arr.notifyAll();
		} else {
			try {
				System.out.println("Waiting for Producer");
				arr.wait();
			} catch (InterruptedException e) {
				System.out.println(" Consumer Interrupted");
				e.printStackTrace();
			}
		}
		}
	}
}
