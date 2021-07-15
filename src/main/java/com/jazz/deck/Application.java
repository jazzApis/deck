package com.jazz.deck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hi");
	}
	
	@Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);// limit creation of initial pool of tasks per request before collecting requests in queue.
        executor.setMaxPoolSize(100); // max number of created tasks to process requests
        executor.setQueueCapacity(50);//number of requests awaited for free task from pool size. if queue is reached next thread is created to the pool
        executor.initialize();
        return executor;
    }
}
