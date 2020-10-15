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

	//����Ա��¼
	@RequestMapping("adminLogin.do")
	public String login(String accounts, String accountsPassword,HttpServletRequest req,HttpServletResponse resp){
		//����service��ȥ����
		Admin admin = service.login(accounts, accountsPassword);
		//��user����Ž�session����
		req.getSession().setAttribute("ADMIN", admin);
		//�ж�admin==null˵�����û��������ض��򵽵�ǰҳ��,!=nullʱ����ת����showҳ��
		return admin==null?"redirect:index.jsp":"redirect:BackgroundCourseShow";		
	}
	// ����Ա�˳�
	@RequestMapping("adminLogout.do")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("admin", null);
		return "index";
	}
}
