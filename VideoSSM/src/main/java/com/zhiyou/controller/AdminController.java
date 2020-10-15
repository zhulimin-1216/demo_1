package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;

	//管理员登录
	@RequestMapping("adminLogin.do")
	public String login(String accounts, String accountsPassword,HttpServletRequest req,HttpServletResponse resp){
		//交给service层去处理
		Admin admin = service.login(accounts, accountsPassword);
		//把user对象放进session域里
		req.getSession().setAttribute("ADMIN", admin);
		//判断admin==null说明该用户不存在重定向到当前页面,!=null时请求转发到show页面
		return admin==null?"redirect:index.jsp":"redirect:BackgroundCourseShow";		
	}
	// 管理员退出
	@RequestMapping("adminLogout.do")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("admin", null);
		return "index";
	}
}
