package com.sysmex.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@Controller
public class HrServiceApplication {

	@RequestMapping("/")
	public String home() {
		return "forward:/hr";
	}

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}
}
