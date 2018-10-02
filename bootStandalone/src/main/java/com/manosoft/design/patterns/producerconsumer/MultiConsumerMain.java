package com.manosoft.design.patterns.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class MultiConsumerMain {
	public static void main(String[] args) {
		int size = 5;
		List<Integer> arr = new ArrayList<Integer>();
		Producer producer = new Producer(arr, size);
		Consumer consumer1 = new Consumer(arr,size);
		Consumer consumer2 = new Consumer(arr,size);
		Thread producerThread = new Thread(producer,"Producer");
		Thread consumerThread1 = new Thread(consumer1, "Consumer-1");
		Thread consumerThread2 = new Thread(consumer2, "Consumer-2");
		consumerThread1.setPriority(Thread.MIN_PRIORITY);
		consumerThread2.setPriority(Thread.MIN_PRIORITY);
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
		System.out.println("Started Producer and Consumer");
	}

}
