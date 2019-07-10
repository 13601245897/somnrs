package com.zhongyuguoji.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients 
public class Chinazhong1Application {

	public static void main(String[] args) {
		SpringApplication.run(Chinazhong1Application.class, args);
	}
}
