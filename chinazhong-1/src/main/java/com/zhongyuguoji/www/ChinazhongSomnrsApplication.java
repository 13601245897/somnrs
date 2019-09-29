package com.zhongyuguoji.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients 
@MapperScan(basePackages = "com.zhongyuguoji.www.mapper")
public class ChinazhongSomnrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChinazhongSomnrsApplication.class, args);
	}
}
