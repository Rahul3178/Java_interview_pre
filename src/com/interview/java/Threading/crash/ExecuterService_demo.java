package com.interview.java.Threading.crash;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuterService_demo {

	public static void main(String[] args) {
		// 1 Single Thread Pool
		 ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		 
		 singleThreadPool.execute(()->{
			 System.out.println("Single Thread Pool");
			 for (int i = 0; i < 5; i++) {
				final int taskId=i;
				System.out.println("Single Thread Task : "+ taskId + " Executed by "+ Thread.currentThread().getName());
			}
		 });
		 singleThreadPool.shutdown();
		 
		 
		 // 2 Fixed Thread pool
		 
		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		 fixedThreadPool.execute(()->{
			 System.out.println("Fixed Thread Pool");
			 for (int i = 0; i < 5; i++) {
				final int taskId=i;
				System.out.println("Fixed Thread Task "+ taskId+ " Executed by "+Thread.currentThread().getName());
			}
		 });
		 
		 fixedThreadPool.shutdown();
		 
		 
		 
		 
		 // 3 Cached Thread Pool
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		 cachedThreadPool.execute(()->{
			 System.out.println("Cached Thread Pool ");
			 for (int i = 0; i < 5; i++) {
				final int taskId=i;
				System.out.println("cached Thread Task "+ taskId+ " Executed by "+Thread.currentThread().getName());
			}
		 });
		 cachedThreadPool.shutdown();
		 
		 // 4 Scheduled Thread Pool
		 ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		 scheduledThreadPool.schedule(()->{
			 System.out.println("Scheduled Thread Pool ");
			 for (int i = 0; i < 5; i++) {
				 final int taskId=i;
				 System.out.println("Scheduled Thread Task "+ taskId+ " Executed by "+Thread.currentThread().getName());
			}
		 },3,TimeUnit.SECONDS);
		 
		 scheduledThreadPool.shutdown();
		 
		 
		 // While Executor service is more abstract and easier to use ,
		 // ThreadPoolExecutor offers greater flexibility and customization
		 
	}
	
}
