package com.param.december_batch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.param.december_batch.services.PublicService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
@Slf4j
public class PublicController {

	private final PublicService publicService;

	@GetMapping("/is-live")
	public ResponseEntity<HttpStatus> isLive() {
		return ResponseEntity.ok().build();
	}

	@PostMapping("/trigger/async")
	public ResponseEntity<HttpStatus> triggerAsync() throws InterruptedException {
		log.info("Request received for Async Trigger");
		for (int i = 1; i <= 100; i++) {
			publicService.testAsyncMethod();
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/trigger/async2")
	public ResponseEntity<HttpStatus> triggerAsync2() {
		publicService.testAsyncWithClass();
		return ResponseEntity.ok().build();
	}
}