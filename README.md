# task-scheduler-spring
Spring Task Scheduler
TaskScheuler was introduced in Spring 3.0 with a variety of methods to run at some point in the future,
it also returns a representation object of ScheduledFuture interface, which could be used to cancel scheduled task or check if it's done or not.
## @ThreadPoolTaskScheduler
ThreadPoolTaskScheduler is well suited for internal thread management, as it delegates tasks to the ScheduledExecutorService and implements the TaskExecutor interface – so that single instance of it is able to handle asynchronous potential executions as well as the @Scheduled annotation.
