package com.zhiyou.dao;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Admin;

public interface AdminDao {//����Ա

	//��¼
	Admin login(@Param("accounts")String accounts, @Param("password")String password);

	//�����Ա����
	Admin selectByAccounts(String accounts);
}
