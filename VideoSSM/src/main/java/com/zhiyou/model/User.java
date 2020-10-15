package com.zhiyou.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{//注册用户
	private static final long serialVersionUID = 5L;

	private Integer id;//id
	private String accounts;//用户注册邮箱
	private String phone;//电话号码
	private String password;//登录密码（加密后）
	private String nickname;//昵称
	private String sex;//性别
	private String birthday;//出生日期
	private String address;//地址
	private String imgurl;//头像地址(图片服务访问路径)
	private Timestamp createTime;//创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", accounts=" + accounts + ", phone=" + phone + ", password=" + password
				+ ", nickname=" + nickname + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ ", imgurl=" + imgurl + ", createTime=" + createTime + "]";
	}
	public User(Integer id, String accounts, String phone, String password, String nickname, String sex,
			String birthday, String address, String imgurl, Timestamp createTime) {
		super();
		this.id = id;
		this.accounts = accounts;
		this.phone = phone;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.imgurl = imgurl;
		this.createTime = createTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
