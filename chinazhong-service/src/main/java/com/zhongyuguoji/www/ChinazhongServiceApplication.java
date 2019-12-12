package com.zhongyuguoji.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class ChinazhongServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChinazhongServiceApplication.class, args);
	}
}
