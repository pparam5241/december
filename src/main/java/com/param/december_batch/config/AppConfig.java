package com.param.december_batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AppConfig {

	@Bean("commonTaskExecutor")
	public TaskExecutor commonTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(1000);
		executor.setThreadNamePrefix("ParamThread-");
		executor.setCorePoolSize(50);
		executor.initialize();
		return executor;
	}
	
	@Bean("premiumTaskExecutor")
	public TaskExecutor premiumTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(1000);
		executor.setThreadNamePrefix("ParamThread-");
		executor.setCorePoolSize(50);
		executor.initialize();
		return executor;
	}
}