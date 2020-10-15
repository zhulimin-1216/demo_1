package com.zhiyou.service;

import java.util.List;



import com.zhiyou.model.User;

public interface UserService {

	void add(User user);
	void update(User user);
	void delete(int id);
	List<User> select();
	User selectByName(String accounts ,String password);
	User selectById(int id);
	void update1(String Password,Integer id);
	void updateImgUrl(Integer id, String filePath);
	User selectByAccounts(String accounts);
}
