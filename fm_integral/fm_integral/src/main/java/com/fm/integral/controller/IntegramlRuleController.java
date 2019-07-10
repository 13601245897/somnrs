package com.fm.integral.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.integral.common.constans.Constants;
import com.fm.integral.entity.IntegramlRule;
import com.fm.integral.service.IntegramlRuleService;
import com.fm.integral.util.ResponseUtils;

/**
 * IntegramlRule list
 * 
 * @author moese
 *
 */
@RestController
@RequestMapping("/integramlRule")
public class IntegramlRuleController {

	@Resource
	private IntegramlRuleService irs;

	/**
	 * getAllIntegramlRule
	 * 
	 * @param response
	 */
	@GetMapping("/getAll")
	public void getIntegramlRuleAll(HttpServletResponse response, Integer pageNumber, Integer pageSize,
			IntegramlRule integramlRule) {
		if (pageNumber == null || pageSize == null ||integramlRule == null) {
			Page<IntegramlRule> page = irs.getAll(0, 5, integramlRule);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), page, response);
		}else {
			
			Page<IntegramlRule> page = irs.getAll(pageNumber, pageSize, integramlRule);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), page, response);
		}

	}

	/**
	 * getIntegramlRuleById
	 * 
	 * @param id
	 * @param response
	 */
	@GetMapping("/getIntegramlRule")
	public void getIntegramlRuleById(Integer id, HttpServletResponse response) {
		if (id != null) {
			IntegramlRule integramlRuleById = irs.getIntegramlRuleById(id);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRuleById, response);
		}

	}

	/**
	 * saveIntegramlRule
	 * 
	 * @param entity
	 * @param response
	 */
	@PostMapping("/saveIntegramlRule")
	public void saveIntegramlRule(IntegramlRule entity, HttpServletResponse response) {
		if (entity != null) {
			irs.saveEntity(entity);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), response);
		}
	}

	/**
	 * getTaskByCirculation
	 * 
	 * @param circulation
	 * @param response
	 */
	@GetMapping("/getTaskByCirculation")
	public void getTaskByCirculation(HttpServletResponse response) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		Integer taskCount = irs.getTaskByCirculation(1);
		Integer taskCountNew = irs.getTaskByCirculation(2);
		hashMap.put("taskCount", taskCount);
		hashMap.put("taskCountNew", taskCountNew);
		ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
				Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), hashMap, response);
	}
}
