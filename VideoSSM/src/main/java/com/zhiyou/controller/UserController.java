package com.zhiyou.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	//��¼
	@RequestMapping("userLogin")
	public String userLogin(String accounts,String password,HttpServletRequest req,HttpServletResponse resp){
		//��÷������������
		User user = service.selectByName(accounts, password);
		//��user����Ž�session����
		req.getSession().setAttribute("user", user);
		System.out.println("����");
		System.out.println(user);
		return "index";
	}
	
	//�����ݿ�Ա��˺��Ƿ����
	@RequestMapping("checkUser.do")
	@ResponseBody//������ͼ������,���Ӻ�׺
	public String checkUserAccounts(String accounts,HttpServletRequest req,HttpServletResponse resp){
		//�����ݿ��ѯ�������user��
		User user = service.selectByAccounts(accounts);
		//�ж��˺������ݿ��˺�
		if(user==null){//Ϊ�տ���ע��
			return JSON.toJSONString("success");
		}//һ�²���ע��
		return JSON.toJSONString("error");
		
	}
	//ע�����û�
	@RequestMapping("addUser.do")
	public String userAccounts(User user,HttpServletRequest req,HttpServletResponse resp){
		service.add(user);
		return "index";
	}
	//�˳�
	@RequestMapping("loginOut.do")
	public String userOut(HttpServletRequest req,HttpServletResponse resp){
		req.getSession().setAttribute("user", null);
		return "index";
	}
	
	//��������
	@RequestMapping("userUpadte.do")
	public String update(User user,HttpServletRequest req,HttpServletResponse resp){
		service.update(user);
		return "foreground/UserUpdate";
	}
	//����Ա�
	@RequestMapping("originalPasswordCheck.do")
	@ResponseBody
	public String Password(String originalPassword,HttpServletRequest req,HttpServletResponse resp){
		User user = (User) req.getSession().getAttribute("user");
		System.out.println("ha ");
		if(originalPassword.equals(user.getPassword())){
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	
	
	@RequestMapping("rePasswordCheck.do")
	@ResponseBody
	public String updatePassword(String newPassword,String rePassword,HttpServletRequest req,HttpServletResponse resp){
		if(newPassword.equals(rePassword)){
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	//��������
	@RequestMapping("passwordUpdate.do")
	public String passwordUpdate(String newPassword,HttpServletRequest req,HttpServletResponse resp){
		User user = (User) req.getSession().getAttribute("user");
		service.update1(newPassword,user.getId());
		user.setPassword(newPassword);
		req.getSession().setAttribute("user", user);
		return "foreground/PersonalCenter";
	}
	//ͷ���ϴ�
	@RequestMapping("uploadAvatar.do")
	public String name(MultipartFile imageFile, HttpServletRequest req, HttpServletResponse resp) throws IllegalStateException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		String originalFilename = imageFile.getOriginalFilename();
		String suffix = originalFilename.split("\\.")[1];
		imageFile.transferTo(new File(req.getServletContext().getRealPath("/upload")+"/"+user.getId()+"."+suffix));
		String path = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		String imgurl = path + "/upload/"+user.getId()+"."+suffix;
		service.updateImgUrl(user.getId(),imgurl);
		user.setImgurl(imgurl);
		req.getSession().setAttribute("user", user);
		return "foreground/PersonalCenter";
		
	}
}
