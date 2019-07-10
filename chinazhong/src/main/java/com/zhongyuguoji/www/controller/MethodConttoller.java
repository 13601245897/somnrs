package com.zhongyuguoji.www.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.Integraml;
import com.zhongyuguoji.www.entity.IntegramlRule;
import com.zhongyuguoji.www.entity.Members;
import com.zhongyuguoji.www.entity.OperationLog;
import com.zhongyuguoji.www.service.IntegramlRuleService;
import com.zhongyuguoji.www.service.IntegramlService;
import com.zhongyuguoji.www.service.MemberLevel;
import com.zhongyuguoji.www.service.MembersInitialize;
import com.zhongyuguoji.www.service.MembersService;
import com.zhongyuguoji.www.service.OperationLogService;
import com.zhongyuguoji.www.util.ResponseUtils;

/**
 * Integraml logic
 * 
 * @author moese
 *
 */
@RestController
@RequestMapping("/method")
public class MethodConttoller {

	// 积分记录
	@Resource
	private IntegramlService imService;

	// 积分规则
	@Resource
	private IntegramlRuleService iRService;

	// 会员
	@Resource
	private MembersService mbService;

	@Resource
	private OperationLogService qls;

	@Resource
	private MemberLevel ml;

	@Resource
	private MembersInitialize membersInitialize;

	@PostMapping(value = "/getIntegram")
	public String encapsulation(String MethodName, HttpServletResponse response, HttpServletRequest request) {
		// requestHead get Members for sid
		Integer sid = 1;
		Members members = membersInitialize.initialize(sid);
		IntegramlRule integramlRule = iRService.getIntegramlRuleByMethodName(MethodName);
		if (integramlRule == null) {
			return null;
		} else {
			// 判断这个积分隶属于新手任务还是每日任务(1是每日，2是新手)
			Integer circulation = integramlRule.getCirculation();
			// 如果在每日中
			if (circulation == 1) {
				// 获取规则表中积分值
				Integer im = integramlRule.getIntegraml();
				if (im == null) {
					return null;
				}
				// 查询积分记录表中有没有记录没有
				Integraml integraml = imService.getIntegramlByName(integramlRule.getName());
				System.out.println(integraml);
				if (integraml != null && integraml.getCountDay() < integramlRule.getRestrictive()) {

					// 会员ID
					integraml.setmId(members.getId());
					// 积分记录表日常任务
					integraml.setCountDay(integraml.getCountDay() + 1);
					integraml.setUpdateTime(new Date().getTime());
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每日总数
					members.setTotalCount(members.getTotalCount() + 1);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(integramlRule.getName(), 1, im, new Date().getTime(),
							new Date().getTime());
					qls.saveLog(operationLog);

					// 更新积分记录表
					imService.updateIntegraml(integraml);

					// 更新会员数据
					mbService.saveMembers(members);
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRule.getIntegraml(),
							response);
				} else if (integraml == null) {
					// 创建首次记录
					integraml = new Integraml();
					integraml.setmId(members.getId());
					integraml.setName(integramlRule.getName());
					integraml.setCountDay(1);
					integraml.setCountNew(0);
					integraml.setCreationTime(new Date().getTime());
					integraml.setUpdateTime(new Date().getTime());
					imService.updateIntegraml(integraml);

					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每日总数
					members.setTotalCount(members.getTotalCount() + 1);
					// 更新会员数据
					mbService.saveMembers(members);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(integramlRule.getName(), 1, im, new Date().getTime(),
							new Date().getTime());
					qls.saveLog(operationLog);

				} else {
					ResponseUtils.responseAsJson(Constants.Success.ACCOMPLISH,
							Constants.Success.SUCCESS.get(Constants.Success.ACCOMPLISH), response);

				}
			} else if (circulation == 2) {
				// 获取规则表中积分值
				Integer im = integramlRule.getIntegraml();
				if (im == null) {
					return null;
				}
				// 查询积分记录表中有没有记录没有
				Integraml integraml = imService.getIntegramlByName(integramlRule.getName());
				if (integraml != null && integraml.getCountNew() < integramlRule.getRestrictive()) {
					integraml.setmId(members.getId());
					// 积分记录表加新手任务
					integraml.setCountNew(integraml.getCountNew() + 1);
					integraml.setUpdateTime(new Date().getTime());
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每新手总数
					members.setTotalCountNew(members.getTotalCountNew() + 1);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(integramlRule.getName(), 1, im, new Date().getTime(),
							new Date().getTime());
					qls.saveLog(operationLog);

					// 更新积分记录表
					imService.updateIntegraml(integraml);
					// 更新会员数据
					mbService.saveMembers(members);
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), response);
				} else if (integraml == null) {
					// 创建首次记录
					integraml = new Integraml();
					integraml.setmId(members.getId());
					integraml.setName(integramlRule.getName());
					integraml.setCountDay(0);
					integraml.setCountNew(1);
					integraml.setCreationTime(new Date().getTime());
					integraml.setUpdateTime(new Date().getTime());
					imService.updateIntegraml(integraml);
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每日总数
					members.setTotalCount(members.getTotalCount() + 1);
					// 更新会员数据
					mbService.saveMembers(members);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(integramlRule.getName(), 1, im, new Date().getTime(),
							new Date().getTime());
					qls.saveLog(operationLog);

				} else {
					ResponseUtils.responseAsJson(Constants.Success.ACCOMPLISH,
							Constants.Success.SUCCESS.get(Constants.Success.ACCOMPLISH), response);

				}
			}
		}
		return null;
	}

}
