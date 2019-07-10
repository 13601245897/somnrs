package com.zhongyuguoji.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class EclientController {
	@GetMapping(value = "/eclient")
	public String EclientString() {
		return "这是一个测试";
	}
}
