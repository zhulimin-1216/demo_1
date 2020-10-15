package com.zhiyou.model;

import java.io.Serializable;
//ʵ��Serializable�ӿڽ������л�
public class Admin implements Serializable{//����Ա��
	private static final long serialVersionUID = 122L;

	private Integer admin_id;//����Աid
	private String accounts;//����Ա��¼�˺�
	private String password;//����Ա��¼����
	private String admin_remark;//����Ա��ɫ����
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
