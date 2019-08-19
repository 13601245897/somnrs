package com.zhongyuguoji.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ViewController {

	@GetMapping("login")
	public ModelAndView getView(HttpServletRequest request) {
		request.setAttribute("captchaType", "captchaType");
		request.setAttribute("captchaEbabled", true);
		return new ModelAndView("login");
	}

	@GetMapping("index")
	public ModelAndView getIndex() {
		return new ModelAndView("index");

	}
}
