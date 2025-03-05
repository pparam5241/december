package com.param.december_batch.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PublicService {

	@Async("commonTaskExecutor")
	public void testAsyncMethod() throws InterruptedException {
		log.info("Async Programming is Started");
		Thread.sleep(10000);
		log.info("Thread Executed -> " + Thread.currentThread().getName());
	}

	public void testAsyncWithClass() {
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			log.info("Async Programming is Started");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("Thread Executed -> " + Thread.currentThread().getName());
		});

		CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
			log.info("Async Programming is Started");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("Thread Executed -> " + Thread.currentThread().getName());
		});

		CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
			log.info("Async Programming is Started");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("Thread Executed -> " + Thread.currentThread().getName());
		});
		CompletableFuture.anyOf(future1, future2, future3).join();
	}
}