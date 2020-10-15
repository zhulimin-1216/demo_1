package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDao userdao;
	
	public void add(User user) {
		userdao.add(user);
		
	}

	public void update(User user) {
		userdao.update(user);
		
	}

	public void delete(int id) {
		userdao.delete(id);
		
	}

	public List<User> select() {
		
		return userdao.select();
	}

	public User selectByName(String accounts, String password) {
		
		return userdao.selectByName(accounts, password);
	}

	public User selectById(int id) {
		
		return userdao.selectById(id);
	}

	public void update1(String Password, Integer id) {
		userdao.update1(Password, id);
		
	}

	public void updateImgUrl(Integer id, String filePath) {
		userdao.updateImgUrl(id,filePath);
	}

	public User selectByAccounts(String accounts) {
		
		return userdao.selectByAccounts(accounts);
	}




}
