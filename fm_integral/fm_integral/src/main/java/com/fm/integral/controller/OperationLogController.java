package com.fm.integral.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.integral.common.constans.Constants;
import com.fm.integral.entity.OperationLog;
import com.fm.integral.service.OperationLogService;
import com.fm.integral.util.ResponseUtils;

/**
 * operationLog List
 * 
 * @author moese
 *
 */
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
	@Resource
	private OperationLogService ols;

	/**
	 * getOperationLogAll
	 * 
	 * @param response
	 */
	@GetMapping("/getAll")
	public void getAll(HttpServletResponse response, OperationLog operationLog, Integer pageNumber, Integer pageSize) {
		if (pageNumber == null || pageSize == null || operationLog == null) {
			Page<OperationLog> page = ols.getAll(0, 5, operationLog);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), page, response);
		}else {
			
			Page<OperationLog> test = ols.getAll(pageNumber, pageSize, operationLog);

			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), test, response);
		}
	}
}
