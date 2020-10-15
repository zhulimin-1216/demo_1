package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SubjectService;

@Controller
public class CourseController {//�γ�ר��

	@Autowired
	CourseService service;
	@Autowired
	SubjectService subjectService;
	//��ҳ
	@RequestMapping("BackgroundCourseShow")
	public String pageShow(@RequestParam(required=false, defaultValue="1")Integer page,HttpServletRequest req,HttpServletResponse resp){
		PageInfo<Course> pageInfo = service.selectPage(page);
		//list���ϴ���ǰ̨
		req.setAttribute("pageInfo", pageInfo);
		return "background/BackgroundCourseShow";
}
		
	//��ΪҪͨ��ѧ�Ʋ�γ�,����Ҫ������е�ѧ��
	@RequestMapping("courseAddShow.do")
	public String showSubject(HttpServletRequest req,HttpServletResponse resp){
	////ͨ������ת����select()��ѯ����ȫ������Ž�list��,����show
		req.setAttribute("list",subjectService.selectAll() );
		//���ظ�add.jsp
		return "background/BackgroundCourseAdd";
	}
	//���
	@RequestMapping("courseAdd.do")
	public String add(Course course,HttpServletRequest req,HttpServletResponse resp){
		//����service��add����
		service.add(course);
		//�ض���show.jsp,������ת����ÿ��ˢ�¾����һ������
		return "redirect:BackgroundCourseShow";
		
	}
	//���ݻ���
	@RequestMapping("courseUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//�Ȳ����������,Ȼ�󽫲����ȫ�������list��,
		req.setAttribute("course", service.selectById(id));
		//���ظ�update.jsp
		return "background/BackgroundCourseUpdate";
		
	}
	//�޸�
	@RequestMapping("courseUpdate.do")
	public String update(Course course,HttpServletRequest req,HttpServletResponse resp){
		//����service��update����
		service.update(course);
		//���ĺ󷵻�show.jsp
		return "redirect:BackgroundCourseShow";
		
	}
	//ɾ��һ��
	@ResponseBody
	@RequestMapping("courseDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//����service��delete����
		service.delete(id);
		//���ظ�success
		return "success";
	}
	//����ɾ��
	@RequestMapping("courseDeleteAll.do")
	//����ɾ����������int����
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		System.out.println(select[0]);
		//����service��deleteAll����
		service.deleteAll(select);
		//ɾ���󷵻ظ�show.jsp
		return "redirect:BackgroundCourseShow";
		
	}
	//�����Ŀ
	@RequestMapping("courseWithVideoAndSubject.do")
	public String subject(Integer subjectId,HttpServletRequest req,HttpServletResponse resp){
		List<Course> courses = service.selectBySubjectId(subjectId);
		req.setAttribute("courses", courses);
		System.out.println(courses);
		return "foreground/CourseShow";
	}
}
