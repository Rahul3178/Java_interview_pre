package com.interview.java.Threading.crash;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor_demo {

	public static void main(String[] args) {

		// Fixed Thread Pool
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

		// ThreadPool Executor Service
		ExecutorService threadPoolExecutorObject = new ThreadPoolExecutor(1, 5, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(2));
		/*
		 *  until the handling  blocking queue full new thread will not created in our
		 *  scenario , queue size is 2 once 2 task picked up by tread one then 3 task
		 *  picked up by thread 2 and so on
		 */
		for (int i = 0; i < 5; i++) {
			final int taskId = i;
			threadPoolExecutorObject.execute(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out
						.println("Thread Pool Executor " + taskId + " Executed by " + Thread.currentThread().getName());

			});
		}

		threadPoolExecutorObject.shutdown();
		fixedThreadPool.shutdown();
	}

}
