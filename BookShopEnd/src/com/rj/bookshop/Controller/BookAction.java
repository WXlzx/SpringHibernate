package com.rj.bookshop.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rj.bookshop.Entity.Book;
import com.rj.bookshop.Entity.Kind;
import com.rj.bookshop.Service.BookService;
import com.rj.bookshop.Service.KindService;
import com.rj.bookshop.Service.PageService;

@Controller
public class BookAction {
	@Autowired
	private BookService bookService;
	@Autowired
	private KindService kindService;
	@Autowired
	private PageService pageService;

	@RequestMapping("/select")
	public String booklist(HttpSession session, Model model) {
		List<Book> list = bookService.selectBook();
		session.setAttribute("booklistall", list);
		
		List courselist= pageService.page(list, 1);
		session.setAttribute("booklist", courselist);
		
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		return "index";
	}
	
	@RequestMapping("/likeselect")
	public String booklistlike(HttpSession session, Model model,@RequestParam String name) {
		List<Book> list = bookService.likeSelect(name);
		session.setAttribute("booklistall", list);
		
		List courselist= pageService.page(list, 1);
		session.setAttribute("booklist", courselist);
		
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		return "index";
	}
	
	@RequestMapping("/xiangqing")
	public String bookxiangqing(HttpSession session, Model model,@RequestParam String bookid) {
		int book_id = Integer.parseInt(bookid);
		Book book = bookService.selectBookById(book_id);		
		session.setAttribute("book", book);
		return "xiangqing";
	}
	
	@RequestMapping("/insert")
	public String insertbook(HttpServletRequest request, @RequestParam MultipartFile[] file1,HttpSession session, Model model, @RequestParam String book_name
			,@RequestParam String book_author,@RequestParam int book_kind,
			@RequestParam String book_describe,@RequestParam double book_price) throws IOException {
		
		String book_img = "";
		if(file1!=null) {
			for(int i=0;i<file1.length;i++) {
			String name = file1[i].getName();
			String originalFilename = file1[i].getOriginalFilename();
			if(originalFilename!=null && !originalFilename.equals("")) {
				String filename = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				byte[] bytes = file1[i].getBytes();
				String realPath = request.getServletContext().getRealPath("img/book");
				File  file = new File(realPath+"\\"+filename);
				book_img = "img/book/"+filename;
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(bytes);
				fos.flush();
				fos.close();
			}
			}
		}
		
		Book book = new Book(book_name, book_price, book_describe, book_author, book_img);
		Kind kind = kindService.selectKindById(book_kind); 
		
		kind.getBookSet().add(book);
		book.setKind(kind);
				
		bookService.insertBook(book);
		
		List<Book> booklist = bookService.selectBook();
		session.setAttribute("booklist", booklist);
		return "Views/index2";
	}

	@RequestMapping("/delete")
	public String deleteBook(HttpSession session, Model model,@RequestParam int bookid) {
		Book book = bookService.selectBookById(bookid);
		bookService.deleteBook(book);
		List<Book> booklist = bookService.selectBook();
		session.setAttribute("booklist", booklist);
		return "Views/index2";
	}
	
	@RequestMapping("/update")
	public String update(HttpSession session,Model model, @RequestParam int bookid) {
		Book book = bookService.selectBookById(bookid);
		session.setAttribute("id", bookid);
		model.addAttribute("book",book);
		return "Views/update2";
	}

	@RequestMapping("/updatesubmit")
	public String updatesubmit(HttpServletRequest request, @RequestParam MultipartFile[] file1,HttpSession session, Model model, @RequestParam String book_name
			,@RequestParam String book_author,@RequestParam int book_kind,
			@RequestParam String book_describe,@RequestParam double book_price) throws IOException {
		
		String book_img = "";
		if(file1!=null) {
			for(int i=0;i<file1.length;i++) {
			String name = file1[i].getName();
			String originalFilename = file1[i].getOriginalFilename();
			if(originalFilename!=null && !originalFilename.equals("")) {
				String filename = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				byte[] bytes = file1[i].getBytes();
				String realPath = request.getServletContext().getRealPath("img/book");
				File  file = new File(realPath+"\\"+filename);
				book_img = "img/book/"+filename;
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(bytes);
				fos.flush();
				fos.close();
			}
			}
		}
		
		
		int book_id = (int) session.getAttribute("id");
		Book book = bookService.selectBookById(book_id);

		book.setBook_name(book_name);
		book.setBook_img(book_img);
		book.setBook_author(book_author);
		book.setBook_describe(book_describe);
		book.setBook_price(book_price);
		
		Kind kind = kindService.selectKindById(book_kind);
		
		book.setKind(kind);
		kind.getBookSet().add(book);
		
		boolean result = bookService.updateBook(book);
		if (result) {
			List<Book> booklist = bookService.selectBook();
			session.setAttribute("booklist", booklist);
			return "Views/index2";
		}else {
			session.setAttribute("book", book);
			model.addAttribute("errorMsg", "修改失败");
			return "Views/update2";
		}
	}

}
