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
	
	//��ѯȫ��
	@RequestMapping("BackgroundVideoShow")
	public String select(@RequestParam(required=false, defaultValue="1")Integer page,Video video,HttpServletRequest req ,HttpServletResponse resp){
		//��װ��pageInfo
		PageInfo<Video> pageInfo = service.select(page,video);
		System.out.println(video);
		//��ѯ����list���ϴ���ǰ̨
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("speaker", speakerservice.select());
		req.setAttribute("course", courseService.select());
		req.setAttribute("name", video);
		return "background/BackgroundVideoShow";
	}
	//ģ����ѯ
	

	@RequestMapping("videoAddShow.do")
	public String showadd(HttpServletRequest req ,HttpServletResponse resp){
		req.setAttribute("speaker",speakerservice.select() );
		req.setAttribute("course", courseService.select());
		return "background/BackgroundVideoAdd";
	}
	//���
	@RequestMapping("videoAdd.do")
	public String add(Video video,HttpServletRequest req,HttpServletResponse resp){
		//����service��add����
		service.add(video);
		//�ض���show.jsp,������ת����ÿ��ˢ�¾����һ������
		return "redirect:BackgroundVideoShow";
		
	}
	
	
	//���ݻ���
	@RequestMapping("videoUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//�Ȳ����������,Ȼ�󽫲����ȫ�������list��,
		req.setAttribute("speaker",speakerservice.select());
		req.setAttribute("course", courseService.select());
		req.setAttribute("video", service.selectById(id));
		//���ظ�update.jsp
		return "background/BackgroundVideoUpdate";
		
	}
	//�޸�
	@RequestMapping("videoUpdate.do")
	public String update(Video video,HttpServletRequest req,HttpServletResponse resp){
		//����service��update����
		service.update(video);
		//���ĺ󷵻�show.jsp
		return "redirect:BackgroundVideoShow";
		
	}
	//ɾ��һ��
	@ResponseBody
	@RequestMapping("videoDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//����service��delete����
		service.delete(id);
		//���ظ�success
		return "success";
	}
	//����ɾ��
	@RequestMapping("videoDeleteAll.do")
	//����ɾ����������int����
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		//����service��deleteAll����
		service.deleteAll(select);
		//ɾ���󷵻ظ�show.jsp
		return "redirect:BackgroundVideoShow";
		
	}

	//
	@RequestMapping("videoPlay.do")
	private String showVideo(Integer videoId,Integer subjectId, HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("video", service.playVideo(videoId));
		req.setAttribute("course", courseService.selectBySubjectId(subjectId));
		//���Ӳ��Ŵ���
		
		return "foreground/VideoPlay";
	}
}
