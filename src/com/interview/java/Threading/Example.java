package com.interview.java.Threading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor2 = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor2.submit(() -> {
                System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
            });
        }
        for (int i = 0; i < 10; i++) {
        	int taskId = i;
        	executor.submit(() -> {
        		System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
        	});
        }

        executor.shutdown();
        executor2.shutdown();
    }
}

