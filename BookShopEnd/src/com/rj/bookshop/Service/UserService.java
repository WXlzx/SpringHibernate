package com.rj.bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bookshop.Dao.UserDao;
import com.rj.bookshop.Entity.User;
@Service
@Transactional
public class UserService {
		
		@Autowired
		private UserDao userDao;
		
		public List<User> login(String username,String password) {
			return userDao.loginDao(username, password);
		}
		
		public  boolean Register (User user) {
			return userDao.registerDao(user);
		}
		
		public User selectUserById(int id) {
			return userDao.selectUserById(id);
		}
		public List<User> selectUser(){
			return userDao.selectUser();
		}
}
