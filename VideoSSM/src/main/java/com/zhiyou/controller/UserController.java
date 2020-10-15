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
	//登录
	@RequestMapping("userLogin")
	public String userLogin(String accounts,String password,HttpServletRequest req,HttpServletResponse resp){
		//获得方法存入对象里
		User user = service.selectByName(accounts, password);
		//把user对象放进session域里
		req.getSession().setAttribute("user", user);
		System.out.println("哈哈");
		System.out.println(user);
		return "index";
	}
	
	//跟数据库对比账号是否存在
	@RequestMapping("checkUser.do")
	@ResponseBody//不走视图解析器,不加后缀
	public String checkUserAccounts(String accounts,HttpServletRequest req,HttpServletResponse resp){
		//从数据库查询结果存在user里
		User user = service.selectByAccounts(accounts);
		//判断账号与数据库账号
		if(user==null){//为空可以注册
			return JSON.toJSONString("success");
		}//一致不能注册
		return JSON.toJSONString("error");
		
	}
	//注册新用户
	@RequestMapping("addUser.do")
	public String userAccounts(User user,HttpServletRequest req,HttpServletResponse resp){
		service.add(user);
		return "index";
	}
	//退出
	@RequestMapping("loginOut.do")
	public String userOut(HttpServletRequest req,HttpServletResponse resp){
		req.getSession().setAttribute("user", null);
		return "index";
	}
	
	//更改资料
	@RequestMapping("userUpadte.do")
	public String update(User user,HttpServletRequest req,HttpServletResponse resp){
		service.update(user);
		return "foreground/UserUpdate";
	}
	//密码对比
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
	//更改密码
	@RequestMapping("passwordUpdate.do")
	public String passwordUpdate(String newPassword,HttpServletRequest req,HttpServletResponse resp){
		User user = (User) req.getSession().getAttribute("user");
		service.update1(newPassword,user.getId());
		user.setPassword(newPassword);
		req.getSession().setAttribute("user", user);
		return "foreground/PersonalCenter";
	}
	//头像上传
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
