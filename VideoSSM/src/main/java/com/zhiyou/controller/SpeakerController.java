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
	//��ѯȫ��
	@RequestMapping("BackgroundSpeakerShow")
	public String select(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//����ѯ����ȫ���������list������
		req.setAttribute("list", service.select());
		//���ظ�show.jsp
		return "background/BackgroundSpeakerShow";
		
	}
	
	//���
	@RequestMapping("speakerAddShow.do")
	public String add(HttpServletRequest req,HttpServletResponse resp){
		
		return "background/BackgroundSpeakerAdd";
		
	}
	@RequestMapping("speakerAdd.do")
	public String add2(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//����service��add����
		service.add(speaker);
		//�ض���show.jsp,������ת����ÿ��ˢ�¾����һ������
		return "redirect:BackgroundSpeakerShow";
	}

	//���ݻ���
	@RequestMapping("speakerUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//�Ȳ����������,Ȼ�󽫲����ȫ�������list��,
		req.setAttribute("speaker", service.selectById(id));
		//���ظ�update.jsp
		return "background/BackgroundSpeakerUpdate";
		
	}
	//�޸�
	@RequestMapping("speakerUpdate.do")
	public String update(Speaker speaker,HttpServletRequest req,HttpServletResponse resp){
		//����service��update����
		service.update(speaker);
		//���ĺ󷵻�show.jsp
		return "redirect:BackgroundSpeakerShow";
	
	}
	//ɾ��һ��
	@ResponseBody
	@RequestMapping("speakerDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//����service��delete����
		service.delete(id);
		//���ظ�success
		return "success";
	}
	//����ɾ��
	@RequestMapping("speakerDeleteAll.do")
	//����ɾ����������int����
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		//����service��deleteAll����
		service.deleteAll(select);
		//ɾ���󷵻ظ�show.jsp
		return "redirect:BackgroundSpeakerShow";
		
	}
}
