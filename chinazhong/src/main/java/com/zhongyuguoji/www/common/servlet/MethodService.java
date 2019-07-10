package com.zhongyuguoji.www.common.servlet;
//package com.zhongyuguoji.www.service;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Component;
//
//import com.zhongyuguoji.www.entity.Integraml;
//import com.zhongyuguoji.www.entity.IntegramlRule;
//import com.zhongyuguoji.www.entity.Members;
//import com.zhongyuguoji.www.util.Result;
//
//@Component
//public class MethodService {
//
//	// 积分记录
//	@Resource
//	private IntegramlService imService;
//
//	// 积分规则
//	@Resource
//	private IntegramlRuleService iRService;
//
//	// 会员
//	@Resource
//	private MembersService mbService;
//
//	@Resource
//	private MemberLevel ml;
//	public Result encapsulation(String MethodName, Members members) {
//		// ThreadLocal<Long> startTime = new ThreadLocal<>();// 开始时间
//		// 用积分规则表过滤 remote methodName
//		//Integer count = imService.getCountIntegramByMId(1);
//		//System.err.println(count);
//		IntegramlRule integramlRule = iRService.getIntegramlRuleByMethodName(MethodName);
//		if (integramlRule == null) {
//			return null;
//		} else {
//			// 判断这个积分隶属于新手任务还是每日任务(1是每日，2是新手)
//			Integer circulation = integramlRule.getCirculation();
//			// 如果在每日中
//			if (circulation == 1) {
//				// 获取规则表中积分值
//				Long im = integramlRule.getIntegraml();
//				if (im == null) {
//					return null;
//				}
//				// 查询积分记录表中有没有记录没有
//				Integraml integraml = imService.getIntegramlByName(integramlRule.getName());
//				System.out.println(integraml);
//				if (integraml != null && integraml.getCountDay() < integramlRule.getRestrictive()) {
//					//会员ID
//					integraml.setmId(members.getId());
//					// 积分记录表日常任务
//					integraml.setCountDay(integraml.getCountDay() + 1L);
//					integraml.setUpdateTime(new Date().getTime());
//					// 会员表加对应积分值
//					members.setTotal(members.getTotal() + im);
//					String nameForTotle = ml.getNameForTotle(members.getTotal());
//					// 对应的等级
//					members.setGrade(nameForTotle);
//					// 会员表加每日总数
//					members.setTotalCount(members.getTotalCount() + 1L);
//					// 更新积分记录表
//					imService.updateIntegraml(integraml);
//					// 更新会员数据
//					mbService.saveMembers(members);
//				} else if (integraml == null) {
//					// 创建首次记录
//					integraml = new Integraml();
//					integraml.setmId(members.getId());
//					integraml.setName(integramlRule.getName());
//					integraml.setCountDay(1L);
//					integraml.setCountNew(0L);
//					integraml.setCreationTime(new Date().getTime());
//					integraml.setUpdateTime(new Date().getTime());
//					imService.updateIntegraml(integraml);
//
//					// 会员表加对应积分值
//					members.setTotal(members.getTotal() + im);
//					String nameForTotle = ml.getNameForTotle(members.getTotal());
//					// 对应的等级
//					members.setGrade(nameForTotle);
//					// 会员表加每日总数
//					members.setTotalCount(members.getTotalCount() + 1L);
//					// 更新会员数据
//					mbService.saveMembers(members);
//
//				} else {
//					System.out.println("每日任务已做完");
//					// 过12点触发定时器重置数据
//
//				}
//			} else if (circulation == 2) {
//				// 获取规则表中积分值
//				Long im = integramlRule.getIntegraml();
//				if (im == null) {
//					return null;
//				}
//				// 查询积分记录表中有没有记录没有
//				Integraml integraml = imService.getIntegramlByName(integramlRule.getName());
//				if (integraml != null && integraml.getCountNew() < integramlRule.getRestrictive()) {
//					integraml.setmId(members.getId());
//					// 积分记录表加新手任务
//					integraml.setCountNew(integraml.getCountNew() + 1L);
//					integraml.setUpdateTime(new Date().getTime());
//					// 会员表加对应积分值
//					members.setTotal(members.getTotal() + im);
//					String nameForTotle = ml.getNameForTotle(members.getTotal());
//					// 对应的等级
//					members.setGrade(nameForTotle);
//					// 会员表加每新手总数
//					members.setTotalCountNew(members.getTotalCountNew() + 1L);
//					// 更新积分记录表
//					imService.updateIntegraml(integraml);
//					// 更新会员数据
//					mbService.saveMembers(members);
//				} else if (integraml == null) {
//					// 创建首次记录
//					integraml = new Integraml();
//					integraml.setmId(members.getId());
//					integraml.setName(integramlRule.getName());
//					integraml.setCountDay(0L);
//					integraml.setCountNew(1L);
//					integraml.setCreationTime(new Date().getTime());
//					integraml.setUpdateTime(new Date().getTime());
//					imService.updateIntegraml(integraml);
//					// 会员表加对应积分值
//					members.setTotal(members.getTotal() + im);
//					String nameForTotle = ml.getNameForTotle(members.getTotal());
//					// 对应的等级
//					members.setGrade(nameForTotle);
//					// 会员表加每日总数
//					members.setTotalCount(members.getTotalCount() + 1L);
//					// 更新会员数据
//					mbService.saveMembers(members);
//
//				} else {
//					System.out.println("每日任务已做完");
//					// 过12点触发定时器重置数据
//
//				}
//			}
//		}
//		// Result result = new Result(Constants.Success.COMMON_CODE,
//		// Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE));
//
//		return null;
//	}
//	
//}
