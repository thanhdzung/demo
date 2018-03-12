package com.sysmex.fsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@Controller
@EnableDiscoveryClient
public class FsoftServiceApplication {
	
	@RequestMapping("/")
	public String home() {
		return "forward:/fsoft";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FsoftServiceApplication.class, args);
	}
}
