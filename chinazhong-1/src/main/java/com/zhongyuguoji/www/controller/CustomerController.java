package com.zhongyuguoji.www.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.api.HelloRemote;

@RequestMapping
@RestController
public class CustomerController {
	@Resource
	private HelloRemote helloRemote;

	@GetMapping("/hello")
	public String index() {
		return helloRemote.hello();
	}
}
