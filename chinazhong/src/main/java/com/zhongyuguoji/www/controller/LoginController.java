package com.zhongyuguoji.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

	@GetMapping("/add")
	public String getAdd(HttpServletRequest request) {
		String parameter = request.getParameter("jifen");
		System.out.println(parameter);
		int count = 0;
		if (parameter != null) {
			count = count + 1;
			System.out.println(count);
		}
		return null;

	}

	@GetMapping("/demos")
	public String test(String name) {
		return "";
	}
}
