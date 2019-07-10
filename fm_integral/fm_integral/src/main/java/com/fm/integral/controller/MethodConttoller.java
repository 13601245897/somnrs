package com.fm.integral.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.integral.common.constans.Constants;
import com.fm.integral.entity.Integraml;
import com.fm.integral.entity.IntegramlRule;
import com.fm.integral.entity.Members;
import com.fm.integral.entity.OperationLog;
import com.fm.integral.service.IntegramlRuleService;
import com.fm.integral.service.IntegramlService;
import com.fm.integral.service.MemberLevel;
import com.fm.integral.service.MembersInitialize;
import com.fm.integral.service.MembersService;
import com.fm.integral.service.OperationLogService;
import com.fm.integral.util.ResponseUtils;

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

	// 日志
	@Resource
	private OperationLogService qls;

	// 等级
	@Resource
	private MemberLevel ml;

	// 会员 model
	@Resource
	private MembersInitialize membersInitialize;

	private static final Logger logger = LoggerFactory.getLogger(MethodConttoller.class);

	/**
	 * 积分逻辑
	 * 
	 * @param MethodName
	 * @param response
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/getIntegram")
	public String encapsulation(String methodName, Integer sid, HttpServletResponse response,
			HttpServletRequest request) {
		// requestHead get Members for sid
		Members members = membersInitialize.initialize(sid);
		IntegramlRule integramlRule = iRService.getIntegramlRuleByMethodName(methodName);
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
				Integraml integraml = imService.getIntegramlByName(integramlRule.getName(), members.getId());
				if (integraml != null && integraml.getCountTask() < integramlRule.getRestrictive()) {

					// 会员ID
					integraml.setmId(members.getId());
					// 积分记录表日常任务
					integraml.setCountTask(integraml.getCountTask() + 1);
					integraml.setUpdateTime(new Date().getTime());
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每日总数
					members.setTotalCount(members.getTotalCount() + 1);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(members.getId(), integramlRule.getName(), 1, im,
							new Date().getTime(), new Date().getTime());
					qls.saveLog(operationLog);

					// 更新积分记录表
					imService.updateIntegraml(integraml);

					// 更新会员数据
					mbService.saveMembers(members);
					logger.info("每日积分更新成功：————————————————————————————————");
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRule.getIntegraml(),
							response);
				} else if (integraml == null) {
					// 创建首次记录
					integraml = new Integraml();
					integraml.setmId(members.getId());
					integraml.setName(integramlRule.getName());
					integraml.setRestrictive(integramlRule.getRestrictive());
					integraml.setCountTask(1);
					integraml.setCirculation(1);
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
					OperationLog operationLog = new OperationLog(members.getId(), integramlRule.getName(), 1, im,
							new Date().getTime(), new Date().getTime());
					qls.saveLog(operationLog);
					logger.info("每日首次积分更新成功：————————————————————————————————");
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRule.getIntegraml(),
							response);

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
				Integraml integraml = imService.getIntegramlByName(integramlRule.getName(), members.getId());
				if (integraml != null && integraml.getCountTask() < integramlRule.getRestrictive()) {
					integraml.setmId(members.getId());
					// 积分记录表加新手任务
					integraml.setCountTask(integraml.getCountTask() + 1);
					integraml.setUpdateTime(new Date().getTime());
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每新手总数
					members.setTotalCountNew(members.getTotalCountNew() + 1);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(members.getId(), integramlRule.getName(), 1, im,
							new Date().getTime(), new Date().getTime());
					qls.saveLog(operationLog);

					// 更新积分记录表
					imService.updateIntegraml(integraml);
					// 更新会员数据
					mbService.saveMembers(members);
					logger.info("新手积分更新成功：————————————————————————————————");
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRule.getIntegraml(),
							response);
				} else if (integraml == null) {
					// 创建首次记录
					integraml = new Integraml();
					integraml.setmId(members.getId());
					integraml.setName(integramlRule.getName());
					integraml.setRestrictive(integramlRule.getRestrictive());
					integraml.setCountTask(1);
					integraml.setCirculation(2);
					integraml.setCreationTime(new Date().getTime());
					integraml.setUpdateTime(new Date().getTime());
					imService.updateIntegraml(integraml);
					// 会员表加对应积分值
					members.setTotal(members.getTotal() + im);
					String nameForTotle = ml.getNameForTotle(members.getTotal());
					// 对应的等级
					members.setGrade(nameForTotle);
					// 会员表加每日总数
					members.setTotalCountNew(members.getTotalCountNew() + 1);
					// 更新会员数据
					mbService.saveMembers(members);

					// 插入操作日志表
					OperationLog operationLog = new OperationLog(members.getId(), integramlRule.getName(), 1, im,
							new Date().getTime(), new Date().getTime());
					qls.saveLog(operationLog);
					logger.info("新手首次积分更新成功：————————————————————————————————");
					ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
							Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), integramlRule.getIntegraml(),
							response);

				} else {
					ResponseUtils.responseAsJson(Constants.Success.ACCOMPLISH,
							Constants.Success.SUCCESS.get(Constants.Success.ACCOMPLISH), response);

				}
			}
		}
		return null;
	}

}
