package com.service.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class WeatherAppController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/current")
	@HystrixCommand(fallbackMethod = "unknown")
	public String getWeather() {
		String str = restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
		System.out.println("str****** "+str);
		return "Current Weather is : " +str;
		
	}
	
	public String unknown() {
		return "Current Weather is : Unknown";
	}

	
}
