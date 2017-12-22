package com.rj.bookshop.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.bookshop.Entity.Kind;
import com.rj.bookshop.Service.KindService;

@Controller
public class KindAction {
	@Autowired
	private KindService kindService;

	@RequestMapping("/selectkind")
	public String selectKind(HttpSession session, Model model) {
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		return "Views/kind";
	}
	
	@RequestMapping("/addkind")
	public String addKind(HttpSession session, Model model,
			@RequestParam String kind_name ) {
		Kind kind = new Kind();
		kind.setKind_name(kind_name);
		kindService.insertKind(kind);
		
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		
		return "Views/kind2";
	}
	
	@RequestMapping("/deletekind")
	public String deleteKind(HttpSession session, Model model,
			@RequestParam int kind_id ) {
		Kind kind = kindService.selectKindById(kind_id);
		kindService.deleteKind(kind);
		
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		
		return "Views/kind2";
	}
	
	
	@RequestMapping("/updatekind")
	public String updateKind(HttpSession session, Model model,
			@RequestParam String kind_name) {

		Kind kind = new Kind();
		kind.setKind_name(kind_name);
		
		kindService.updateKind(kind);
		
		List<Kind> kindlist = kindService.selectKind();
		session.setAttribute("kindlist", kindlist);
		
		return "Views/kind2";
	}
	
	
}