package com.fm.integral.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.integral.common.constans.Constants;
import com.fm.integral.entity.Integraml;
import com.fm.integral.service.IntegramlService;
import com.fm.integral.util.ResponseUtils;

/**
 * 
 * @author moese
 *
 */
@RestController
@RequestMapping("/integraml")
public class IntegramlController {

	@Resource
	private IntegramlService is;

	@GetMapping("/getAll")
	public void getAll(HttpServletResponse response, Integer pageNumber, Integer pageSize, Integraml integraml) {
		if (pageNumber == null || pageSize == null || integraml == null) {
			Page<Integraml> page = is.getAll(0, 5, integraml);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), page, response);
		} else {

			Page<Integraml> page = is.getAll(pageNumber, pageSize, integraml);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), page, response);
		}
	}
}
