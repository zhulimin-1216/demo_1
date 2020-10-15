package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;

@Controller
public class SpeakerController {

	@Autowired
	SpeakerService service;
	//查询全部
	@RequestMapping("BackgroundSpeakerShow")
	public String select(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//将查询出的全部结果放入list集合里
		req.setAttribute("list", service.select());
		//返回给show.jsp
		return "background/BackgroundSpeakerShow";
		
	}
	
	//添加
	@RequestMapping("speakerAddShow.do")
	public String add(HttpServletRequest req,HttpServletResponse resp){
		
		return "background/BackgroundSpeakerAdd";
		
	}
	@RequestMapping("speakerAdd.do")
	public String add2(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//调用service的add方法
		service.add(speaker);
		//重定向到show.jsp,用请求转发会每次刷新就添加一次数据
		return "redirect:BackgroundSpeakerShow";
	}

	//数据回显
	@RequestMapping("speakerUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//先查出所有数据,然后将查出的全部结果入list里,
		req.setAttribute("speaker", service.selectById(id));
		//返回给update.jsp
		return "background/BackgroundSpeakerUpdate";
		
	}
	//修改
	@RequestMapping("speakerUpdate.do")
	public String update(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//调用service的update方法
		service.update(speaker);
		//更改后返回show.jsp
		return "redirect:BackgroundSpeakerShow";
	
	}
	//删除一个
	@ResponseBody
	@RequestMapping("speakerDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//调用service的delete方法
		service.delete(id);
		//返回给success
		return "success";
	}
	//批量删除
	@RequestMapping("speakerDeleteAll.do")
	//批量删除参数传入int数组
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		//调用service的deleteAll方法
		service.deleteAll(select);
		//删除后返回给show.jsp
		return "redirect:BackgroundSpeakerShow";
		
	}
}
