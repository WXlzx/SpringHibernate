package com.rj.bookshop.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.bookshop.Entity.Book;
import com.rj.bookshop.Service.PageService;

@Controller
public class PageAction {
	@Autowired
	private PageService pageService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/page")
	public String pagelist(HttpSession session, Model model,@RequestParam String page) {
		List<Book> booklistAll = (List<Book>) session.getAttribute("booklistall");
		int pagecount = Integer.parseInt(page);
		List<Book> booklist = pageService.page(booklistAll, pagecount);
		session.setAttribute("booklist", booklist);
		return "index";
	}
}
