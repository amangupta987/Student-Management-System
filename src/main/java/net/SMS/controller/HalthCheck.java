package net.SMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalthCheck {

	@GetMapping("/health-check")
	public String healthcheck() {
		return "hello";
	}
}
