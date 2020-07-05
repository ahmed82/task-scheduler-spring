package com.rbs.taskscheduler;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

	@Async("threadPoolTaskExecutor")
	public void asyncMethodWithConfiguredExecutor() {
		System.out.println("Execute method with configured executor - " + Thread.currentThread().getName());

	}

}