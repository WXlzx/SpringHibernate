package com.rj.bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bookshop.Dao.AdminDao;
import com.rj.bookshop.Entity.Admin;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public List<Admin> adminLogin(String adminname,String password){
		return adminDao.adminLogin(adminname, password);
	}
	
	public boolean adminUpdate(Admin admin) {
		return adminDao.adminUpdate(admin);
	}
}
