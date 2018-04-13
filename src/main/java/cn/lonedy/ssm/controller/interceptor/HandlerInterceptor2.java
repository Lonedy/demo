package cn.lonedy.ssm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *  
 * <p>
 * Title: HandlerInterceptor1
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-10-13 下午4:51:38    @version 1.0
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	// 执行时机：处理器方法执行之前，执行该方法
	// 使用场景：登录验证，权限校验
	// 返回值：true 是否放行 false 不放行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		System.out.println("HandlerInterceptor2...preHandle");

		return true;
	}

	// 执行时机：处理器方法执行且返回之前时，执行该方法
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...postHandle");
	}

	// 执行时机：处理器方法执行之后，执行该方法
	// 使用场景：统一日志
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...afterCompletion");
	}

}
