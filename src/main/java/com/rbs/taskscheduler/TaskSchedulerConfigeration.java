package com.rbs.taskscheduler;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name=  "scheduling.enabled", matchIfMissing = true)
public class TaskSchedulerConfigeration {
	
	private static final Logger log = LoggerFactory.getLogger(TaskSchedulerConfigeration.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	
	//@Scheduled(fixedDelay = 2000, cron = "0 0 18 * * MON-FRI")//every (* * * * * *) sec min hr d w m //"${cron.expression}"
	@Scheduled(initialDelay = 1000, fixedDelayString =  "${somejob.delay}")//"PT2H" / "${somejob.delay}"
	public void scheduleFixedDelayTask() throws InterruptedException {
		log.info("fixedDelayString task - " + System.currentTimeMillis() / 1000+ " ThreadName: "+Thread.currentThread().getName());
	    Thread.sleep(1000L);
	}
	
	@Scheduled(fixedRate = 10000)
	public void performTask() {
		log.info("fixedRate task performed at " + dateFormat.format(new Date()));

	}
	
	@Scheduled(initialDelay = 1000, fixedDelayString =  "${somejob.delay}")//"PT2H" / "${somejob.delay}"
	public void scheduleTask() throws InterruptedException {
		log.info("schedule task - " + System.currentTimeMillis() / 1000);
	}

}
