package cn.lonedy.ssm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: LoginInterceptor</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-13 下午5:21:02  
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		//获取请求uri
		String uri = request.getRequestURI();
		//uri是否包含login字符，如果包含则放行
		if(uri.indexOf("login")>-1) return true;
		
		//获取用户名称
		String username = (String) request.getSession().getAttribute("username");
		if(username != null && !username.equals("")) return true;
		
		//重定向到登录页面
		response.sendRedirect("/ssmhm17/loginPage");
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
