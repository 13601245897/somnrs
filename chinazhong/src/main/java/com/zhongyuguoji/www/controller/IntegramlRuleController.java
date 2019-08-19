package com.zhongyuguoji.www.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.IntegramlRule;
import com.zhongyuguoji.www.service.IntegramlRuleService;
import com.zhongyuguoji.www.util.ResponseUtils;

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
	public void getIntegramlRuleAll(HttpServletResponse response) {
		List<IntegramlRule> integramlRules = irs.getAll();
		ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
				Constants.Success.DESC.get(Constants.Success.COMMON_CODE), integramlRules, response);

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
					Constants.Success.DESC.get(Constants.Success.COMMON_CODE), integramlRuleById, response);
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
					Constants.Success.DESC.get(Constants.Success.COMMON_CODE), response);
		}
	}
}
