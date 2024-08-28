package com.ecz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Fld2aAwsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fld2aAwsEurekaServerApplication.class, args);
	}

}
