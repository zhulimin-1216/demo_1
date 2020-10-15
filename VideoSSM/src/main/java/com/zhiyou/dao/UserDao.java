package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.User;
public interface UserDao {

	void add(User user);
	void update(User user);
	void delete(int id);
	List<User> select();
	User selectByName(@Param("accounts")String accounts ,@Param("password")String password);
	User selectById(int id);
	void update1(@Param("password") String password,@Param("id")Integer id);
	void updateImgUrl(@Param("id")Integer id, @Param("imgurl")String filePath);
	User selectByAccounts(String accounts);
}
