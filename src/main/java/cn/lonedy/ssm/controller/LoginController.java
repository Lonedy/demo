package cn.lonedy.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * <p>
 * Title: LoginController
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-10-13 下午5:15:27    @version 1.0
 */
@Controller
public class LoginController {

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		if (username == null || "".equals(username))
			return "login";
		// 将用户名称存放到session中
		session.setAttribute("username", username);

		return "redirect:/items/queryItems";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 失效session
		session.invalidate();

		return "redirect:loginPage";
	}
}
