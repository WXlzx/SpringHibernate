package com.rj.bookshop.Dao;

import java.util.List;

import com.rj.bookshop.Entity.Admin;

public interface AdminDao {
	public List<Admin> adminLogin(String adminname,String password);
	public boolean adminUpdate(Admin admin);
}
