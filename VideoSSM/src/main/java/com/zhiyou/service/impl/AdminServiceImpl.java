package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminDao;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao dao;
	public Admin login(String accounts, String password) {
		
		return dao.login(accounts, password);
	}

	public Admin selectByAccounts(String accounts) {
		
		return dao.selectByAccounts(accounts);
	}

}
