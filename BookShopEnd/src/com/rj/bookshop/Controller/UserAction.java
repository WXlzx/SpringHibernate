package com.rj.bookshop.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.bookshop.Entity.User;
import com.rj.bookshop.Service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpSession session,Model model,@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
		List<User> list = userService.login(username, password);		
		if(list.size()>0) {
			session.setAttribute("user", list.get(0));
			session.removeAttribute("errorMsg");
			session.removeAttribute("error");
			return "index";
		}else {
			model.addAttribute("errorMsg", "用户名与密码不匹配，请重新登录");
			return "login";
		}
	}
	@RequestMapping("/register")
	public String register(HttpSession session,Model model,
			@RequestParam(value="username") String username,
			@RequestParam(value="password") String password,
			@RequestParam(value="email") String email) {
		if(username.equals("")||password.equals("")||email.equals("")) {
			model.addAttribute("errorMsg","请完善信息！");
			return "contact";
		}
		User user = new User(username,password,email);
		boolean T = userService.Register(user);
		if(T) {
			return "login";
		}else {
			model.addAttribute("errorMsg","注册失败！请重新注册。");
			return "contact";
		}
	}
	
	@RequestMapping("/out")
	public String out(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			session.removeAttribute("user");
			session.removeAttribute("errorMsg");
			session.removeAttribute("error");
		}
		return "index";
	}
	
	
}
