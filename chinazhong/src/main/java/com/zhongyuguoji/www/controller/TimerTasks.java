//package com.zhongyuguoji.www.controller;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Component;
//
//import com.zhongyuguoji.www.service.MembersService;
//
///**
// * timerTasks for 24:00
// * 
// * @author moese
// *
// */
//@Component
//public class TimerTasks {
//	@Resource
//	private MembersService ms;
//
//	public void delDate() {
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 24); // 控制时
//		calendar.set(Calendar.MINUTE, 0); // 控制分
//		calendar.set(Calendar.SECOND, 0); // 控制秒
//
//		Date time = calendar.getTime(); // 得出执行任务的时间,此处为今天的24：00：00
//
//		Timer timer = new Timer();
//		timer.scheduleAtFixedRate(new TimerTask() {
//			public void run() {
//				System.out.println("-------设定要指定任务--------");
//				// 重置数据
//				Long totalCount = 0L;
//				Long totalNew = 0L;
//				ms.updateTimer(totalCount, totalNew);
//			}
//		}, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
//	}
//	public static void main(String[] args) {
//	new TimerTasks().delDate();
//	}
//}
