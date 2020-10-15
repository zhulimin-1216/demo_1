package com.zhiyou.model;

import java.io.Serializable;
//实现Serializable接口进行序列化
public class Admin implements Serializable{//管理员表
	private static final long serialVersionUID = 122L;

	private Integer admin_id;//管理员id
	private String accounts;//管理员登录账号
	private String password;//管理员登录密码
	private String admin_remark;//管理员角色名称
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin_remark() {
		return admin_remark;
	}
	public void setAdmin_remark(String admin_remark) {
		this.admin_remark = admin_remark;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", accounts=" + accounts + ", password=" + password + ", admin_remark="
				+ admin_remark + "]";
	}
	public Admin(Integer admin_id, String accounts, String password, String admin_remark) {
		super();
		this.admin_id = admin_id;
		this.accounts = accounts;
		this.password = password;
		this.admin_remark = admin_remark;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
