package com.service.demo.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WealterController {

	private String[] weather = new String[] {"sunny","cloudy","rainy","windy"};
	
	@GetMapping("/weather")
	public String getWeather() {
		int random = ThreadLocalRandom.current().nextInt(0, 4);
		
		return weather[random];
	}
}
