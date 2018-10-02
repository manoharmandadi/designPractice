package com.manosoft.design.patterns.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int size = 5;
		List<Integer> arr = new ArrayList<Integer>();
		Producer producer = new Producer(arr, size);
		Consumer consumer = new Consumer(arr,size);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
		System.out.println("Started Producer and Consumer");
	}
}
