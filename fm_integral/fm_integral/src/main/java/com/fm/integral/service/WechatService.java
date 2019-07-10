package com.fm.integral.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fm.integral.entity.Integraml;
import com.fm.integral.entity.Members;

@Transactional
@Service
public class WechatService {

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

	public HashMap<String, Object> getWechatList(Integer uxid) {
		if (uxid != null) {

			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			// 获取会员信息
			Members members = mbService.getMembersBySid(uxid);
			String nameForTotle = ml.getNameForTotle(members.getTotal());
			if (nameForTotle != null) {
				// 对应的等级
				members.setGrade(nameForTotle);
			}
			if (members != null) {
				hashMap.put("members", members);
			}
			// 每日总任务
			Integer tatalCountDay = iRService.getTaskByCirculation(1);
			if (tatalCountDay != null) {
				hashMap.put("TCountDay", tatalCountDay);
			}
			// 新手总任务
			Integer tatalCountNew = iRService.getTaskByCirculation(2);
			if (tatalCountNew != null) {
				hashMap.put("TCountNew", tatalCountNew);
			}
			// 每日完成任务 12点重置
			Integer countDay = imService.getCountTaskByMid(members.getId(), 1);
			if (countDay != null) {

				hashMap.put("Dcount", countDay);
			}
			// 完成新手任务
			Integer countNew = imService.getCountTaskByMid(members.getId(), 2);
			if (countNew != null) {

				hashMap.put("Ncount", countNew);
			}
			List<Integraml> integraml = imService.getIntegramlsByid(members.getId());
			if (integraml != null) {

				hashMap.put("integraml", integraml);
			}

			return hashMap;
		}
		return null;
	}
}
