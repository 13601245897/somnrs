package com.zhongyuguoji.www.common.servlet;
//package com.zhongyuguoji.www.controller;
//
//import javax.annotation.Resource;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.zhongyuguoji.www.entity.Members;
//import com.zhongyuguoji.www.service.MembersInitialize;
//import com.zhongyuguoji.www.service.MethodService;
//import com.zhongyuguoji.www.util.Result;
//import com.zhongyuguoji.www.util.StringUtil;
//
///**
// * 切面拦截器for Integarml
// * 
// * @author moese
// *
// */
//@Aspect
//@Component
//public class ControllerInterceptor {
//	// 定义一个日志的全局的静态
//	private static Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);
//	@Resource
//	private MethodService methodService;
//	@Resource
//	private MembersInitialize membersInitialize;
//
//	ThreadLocal<Long> startTime = new ThreadLocal<>();// 开始时间
//
//	// 定义一个切入点. 解释下：
//	// 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 定义在web包或者子包 ~ 第三个 * 任意方法 ~ .. 匹配任意数量的参数.
//	@Pointcut("execution(* com.zhongyuguoji.www.controller.*.*(..))")
//	public void logPointcut() {
//	}
//
//	// 方法执行前执行
//	@Before("logPointcut()")
//	public void beforMehhod(JoinPoint jp) {
//		logger.info("Before: ===================");
//		startTime.set(System.currentTimeMillis());
//	}
//
//	// 环绕 方法首先执行
//	@Around("logPointcut()")
//	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		long start = System.currentTimeMillis();
//		try {
//			Object result = joinPoint.proceed();
//			if (result == null) {
//				// 如果切到了 没有返回类型的void方法，这里直接返回
//				return null;
//			}
//			System.out.println(result + "!!!!!!!!!!!!!!!!!!");
//			long end = System.currentTimeMillis();
//
//			logger.info("Around: ===================");
//			String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
//			String MethodName = joinPoint.getSignature().getName();
//
//			// Object[] args = joinPoint.getArgs();// 参数
//			// int argsSize = args.length;
//			// if (argsSize > 0) {
//			// // 拿到参数的类型
//			// for (Object object : args) {
//			// String argsTypes += object.getClass().getTypeName().toString() + " ";
//			// }
//			// logger.info("参数类型：" + argsTypes);
//			// }
//			String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];
//			String returnType = joinPoint.getSignature().toString().split(" ")[0];
//			logger.info("类/接口:" + tragetClassName + "(" + typeStr + ")");
//			logger.info("方法:" + MethodName);
//			// logger.info("参数个数:" + argsSize);
//			logger.info("返回类型:" + returnType);
//
//			Long total = end - start;
//			logger.info("耗时: " + total + " ms!");
//
//			return result;
//
//		} catch (Throwable e) {
//			long end = System.currentTimeMillis();
//			logger.info("====around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
//					+ e.getMessage());
//			throw e;
//		} finally {
//		}
//
//	}
//
//	// 后置通知加强 方法执行完之后调用
//	@AfterReturning("logPointcut()")
//	public Object afterMehhod(JoinPoint joinPoint) {
//		Long start = startTime.get();
//		String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
//		String MethodName = joinPoint.getSignature().getName();
//		String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];
//		logger.info("类/接口:" + tragetClassName + "(" + typeStr + ")");
//		logger.info("方法:" + MethodName);
//		if (StringUtil.isNullOrEmpty(MethodName)) {
//			logger.info("方法null");
//			return "";
//		}
//		// HttpServletResponse response = ((ServletRequestAttributes)
//		// RequestContextHolder.getRequestAttributes())
//		// .getResponse();
//		// ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
//		// Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), response);
//		// ThreadLocal 维护变量 避免同步
//		// ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
//		Integer sid = 1;
//		Members members = membersInitialize.initialize(sid);
//		Result result = methodService.encapsulation(MethodName, members);
//		long end = System.currentTimeMillis();
//		Long total = end - start;
//		logger.info("耗时: " + total + " ms!");
//		return result;
//	}
//
//}
