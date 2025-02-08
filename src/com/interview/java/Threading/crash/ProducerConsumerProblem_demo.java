package com.interview.java.Threading.crash;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable{
	private BlockingQueue<Integer> queue;
	
	public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	
	
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(1000);
				queue.put(i);
				System.out.println("Produced "+i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}


class ConsumerBlockingQueue implements Runnable{
	private BlockingQueue<Integer> queue;

	public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}
	
	@Override
	public void run()
	{
		try {
			while(true) {
				Integer item = queue.take();
				System.out.println("Consumed : "+ item);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			
			Thread.currentThread().interrupt();
		}
	}
	
}
public class ProducerConsumerProblem_demo {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		// creating queue with initial capacity of 5
		
		// creating producer and consumer Thread
		
		ProducerBlockingQueue producer= new ProducerBlockingQueue(queue);
		ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
		

	}

}
