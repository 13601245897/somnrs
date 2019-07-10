package com.zhongyuguoji.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ViewController {

	@GetMapping("viewMvc")
	public ModelAndView getView() {
		return new ModelAndView("login");
	}
}
