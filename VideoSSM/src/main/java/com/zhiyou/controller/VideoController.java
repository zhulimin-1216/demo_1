package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	VideoService service;
	@Autowired
	SpeakerService speakerservice;
	@Autowired
	CourseService courseService;
	
	//查询全部
	@RequestMapping("BackgroundVideoShow")
	public String select(@RequestParam(required=false, defaultValue="1")Integer page,Video video,HttpServletRequest req ,HttpServletResponse resp){
		//包装成pageInfo
		PageInfo<Video> pageInfo = service.select(page,video);
		System.out.println(video);
		//查询出的list集合传入前台
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("speaker", speakerservice.select());
		req.setAttribute("course", courseService.select());
		req.setAttribute("name", video);
		return "background/BackgroundVideoShow";
	}
	//模糊查询
	

	@RequestMapping("videoAddShow.do")
	public String showadd(HttpServletRequest req ,HttpServletResponse resp){
		req.setAttribute("speaker",speakerservice.select() );
		req.setAttribute("course", courseService.select());
		return "background/BackgroundVideoAdd";
	}
	//添加
	@RequestMapping("videoAdd.do")
	public String add(Video video,HttpServletRequest req,HttpServletResponse resp){
		//调用service的add方法
		service.add(video);
		//重定向到show.jsp,用请求转发会每次刷新就添加一次数据
		return "redirect:BackgroundVideoShow";
		
	}
	
	
	//数据回显
	@RequestMapping("videoUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//先查出所有数据,然后将查出的全部结果入list里,
		req.setAttribute("speaker",speakerservice.select());
		req.setAttribute("course", courseService.select());
		req.setAttribute("video", service.selectById(id));
		//返回给update.jsp
		return "background/BackgroundVideoUpdate";
		
	}
	//修改
	@RequestMapping("videoUpdate.do")
	public String update(Video video,HttpServletRequest req,HttpServletResponse resp){
		//调用service的update方法
		service.update(video);
		//更改后返回show.jsp
		return "redirect:BackgroundVideoShow";
		
	}
	//删除一个
	@ResponseBody
	@RequestMapping("videoDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//调用service的delete方法
		service.delete(id);
		//返回给success
		return "success";
	}
	//批量删除
	@RequestMapping("videoDeleteAll.do")
	//批量删除参数传入int数组
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		//调用service的deleteAll方法
		service.deleteAll(select);
		//删除后返回给show.jsp
		return "redirect:BackgroundVideoShow";
		
	}

	//
	@RequestMapping("videoPlay.do")
	private String showVideo(Integer videoId,Integer subjectId, HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("video", service.playVideo(videoId));
		req.setAttribute("course", courseService.selectBySubjectId(subjectId));
		//增加播放次数
		
		return "foreground/VideoPlay";
	}
}
