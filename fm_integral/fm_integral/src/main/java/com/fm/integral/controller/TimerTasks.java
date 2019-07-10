package com.fm.integral.controller;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fm.integral.service.MembersService;

/**
 * timerTasks for 24:00
 * 
 * @author moese
 *
 */
@Component
public class TimerTasks {
	@Resource
	private MembersService ms;

	@Scheduled(cron = "0 0 1 * * ?")
	public void delDate() {
		// 重置每日数据
		Integer totalCount = 0;
		ms.updateTimer(totalCount);
	}
}
