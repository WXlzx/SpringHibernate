package com.rj.bookshop.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.bookshop.Entity.Admin;
import com.rj.bookshop.Entity.Book;
import com.rj.bookshop.Entity.Kind;
import com.rj.bookshop.Entity.User;
import com.rj.bookshop.Service.AdminService;
import com.rj.bookshop.Service.BookService;
import com.rj.bookshop.Service.KindService;
import com.rj.bookshop.Service.UserService;

@Controller
public class AdminAction {
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookService bookService;
	@Autowired
	private KindService kindService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/adminlogin")
	public String login(HttpSession session,Model model,@RequestParam(value="adminname") String adminname,@RequestParam(value="password") String password) {
		List<Admin> list = adminService.adminLogin(adminname, password);
		if(list.size()>0) {
			List<Book> booklist = bookService.selectBook();
			session.setAttribute("booklist", booklist);
			
			List<Kind> kindlist = kindService.selectKind();
			session.setAttribute("kindlist", kindlist);
			
			session.setAttribute("admin", list.get(0));
			return "Views/index";
		}else {
			model.addAttribute("errorMsg", "管理员用户名与密码不匹配，请重新登录");
			return "admin";
		}
	}
	
	@RequestMapping("/selectuser")
	public String selectUser(HttpSession session,Model model) {
		List<User> userlist = userService.selectUser();
		session.setAttribute("userlist", userlist);
		
		return "Views/user";
	}
	
	@RequestMapping("/selectorder")
	public String selectOrder(HttpSession session,Model model) {
		List<User> userlist = userService.selectUser();
		session.setAttribute("userlist", userlist);
		
		return "Views/orders";
	}
	
	@RequestMapping("/outadmin")
	public String outAdmin(HttpSession session,Model model) {

		session.removeAttribute("admin");
		session.removeAttribute("booklistall");
		return "index";
	}
	
	@RequestMapping("/adminupdate")
	public String updateAdmin(HttpSession session,Model model) {

		Admin admin = (Admin) session.getAttribute("admin");
		return "Views/admin";
	}
	
	@RequestMapping("/adminupdatesubmit")
	public String submitAdmin(HttpSession session,Model model,
			@RequestParam String name,@RequestParam String password) {

		Admin admin = (Admin) session.getAttribute("admin");
		admin.setName(name);
		admin.setPassword(password);
		
		adminService.adminUpdate(admin);
		
		session.setAttribute("admin",admin);
		return "Views/index2";
	}
	
}
