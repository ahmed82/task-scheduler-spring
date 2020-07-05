package com.rbs.taskscheduler;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class AsyncScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(TaskSchedulerConfigeration.class);

	@Async
	@Scheduled(fixedDelay = 1000) // "PT2H" / "${somejob.delay}"
	public void scheduleFixedDelayTask() throws InterruptedException {
		log.info("Asynch Schedule - " + new Date().getSeconds());
		Thread.sleep(5000L);
	}

	@Async
	public Future<String> asyncMethodWithReturnType() {
		System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			return new AsyncResult<String>("hello world !!!!");
		} catch (InterruptedException e) {
			//
		}

		return null;
	}
	/*
	public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
		System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
		Future<String> future = asyncAnnotationExample.asyncMethodWithReturnType();

		while (true) {
			if (future.isDone()) {
				System.out.println("Result from asynchronous process - " + future.get());
				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}
	*/
}
