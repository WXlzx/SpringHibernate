package com.rj.bookshop.Controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.bookshop.Entity.Order;
import com.rj.bookshop.Entity.OrderLine;
import com.rj.bookshop.Entity.User;
import com.rj.bookshop.Service.OrderService;
import com.rj.bookshop.Service.UserService;

@Controller
public class OrderAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addorder")
	public String addOrder(HttpSession session,
			@RequestParam("uid") String uid,
			@RequestParam("bid") String bid,
			@RequestParam(value="count", required=false) String count) {
		
		int count1 = 0;
		if(uid.equals("")) {
			return "login";
		}
		if(count.equals("")) {
			count1=1;
		}else {
			count1 = Integer.parseInt(count);
		}
		int userid = Integer.parseInt(uid);
		int bookid = Integer.parseInt(bid);
		orderService.addOrder(userid,bookid,count1);
		return "index";
	}
	
	@RequestMapping("/deleteorder")	
	public String deleteOrder(HttpSession session,
			@RequestParam String orderlineid) {
			int oli = Integer.parseInt(orderlineid);
			User user = (User) session.getAttribute("user");
			int id = user.getId();
			orderService.deleteOrder(orderService.selectOrderLineById(oli));

		return "redirect:ordershow.do?user_id="+id;
	}
	
	
	@RequestMapping("/deleteall")	
	public String deleteall(HttpSession session,@RequestParam String orderid) {
		
			int oli = Integer.parseInt(orderid);
			Order order = orderService.selectOrderById(oli);
			orderService.deleteAll(order);
		return "redirect:show.do";
	}
	
	@RequestMapping("/ordershow")
	public String selectOrder(HttpSession session,
			@RequestParam("user_id") String user_id) {
		if(user_id.equals("")) {
			session.setAttribute("errorMsg", "请先登录");
			return "login";
		}else {
			int uid = Integer.parseInt(user_id);
			User user = userService.selectUserById(uid);
			
			Set<Order> orderSet = user.getOrderSet();
		

			double price = 0;	
			int count = 0;
			

			Iterator<Order> it= orderSet.iterator();
			while(it.hasNext()){
				Order o=it.next();
				if(o.getState()==1) {
					for (OrderLine ol:o.getOrderlineSet()) {
						price = price+ol.getPrice();
						count = count+ol.getCount();
					}
				}else {
					it.remove();
				}
			}
			session.setAttribute("orderset", orderSet);
			session.setAttribute("price", price);
			session.setAttribute("count", count);
			return "ordershow";
		}
	}
	
	@RequestMapping("/show")
	public String selectOrder(HttpSession session){
			
			Set<Order> orderSet = new HashSet<Order>();
		
			session.setAttribute("orderset", orderSet);
			session.setAttribute("price",0);
			session.setAttribute("count",0);
			return "ordershow";
	}
	@RequestMapping("/ordersubmit")
	public String submitOrder(HttpSession session) {
			User user = (User) session.getAttribute("user");
			
			Set<Order> orderSet = (Set<Order>) session.getAttribute("orderset");
			for(Order o:orderSet) {
				o.setState(0);
				orderService.updateOrder(o);
			}
			session.setAttribute("orderset", orderSet);

			return "index";		
	}
	
}
