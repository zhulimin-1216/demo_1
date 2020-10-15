package com.zhiyou.dao;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Admin;

public interface AdminDao {//管理员

	//登录
	Admin login(@Param("accounts")String accounts, @Param("password")String password);

	//管理查员名字
	Admin selectByAccounts(String accounts);
}
