package com.zhongyuguoji.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class ChinazhongApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChinazhongApplication.class, args);
	}

}
