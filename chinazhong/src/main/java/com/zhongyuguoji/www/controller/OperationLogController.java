package com.zhongyuguoji.www.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.OperationLog;
import com.zhongyuguoji.www.service.OperationLogService;
import com.zhongyuguoji.www.util.ResponseUtils;

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
	public void getAll(HttpServletResponse response) {
		List<OperationLog> operationLogs = ols.getAll();
		ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
				Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), operationLogs, response);
	}
}
