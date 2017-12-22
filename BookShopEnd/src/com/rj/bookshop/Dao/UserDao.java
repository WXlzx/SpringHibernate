package com.rj.bookshop.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rj.bookshop.Entity.User;
@Component
public interface UserDao {
	public List<User> loginDao(String username,String password);
	public boolean registerDao(User user);
	public User selectUserById(int id);
	public List<User> selectUser();
}
