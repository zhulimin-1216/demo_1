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
public class CourseController {//课程专辑

	@Autowired
	CourseService service;
	@Autowired
	SubjectService subjectService;
	//分页
	@RequestMapping("BackgroundCourseShow")
	public String pageShow(@RequestParam(required=false, defaultValue="1")Integer page,HttpServletRequest req,HttpServletResponse resp){
		PageInfo<Course> pageInfo = service.selectPage(page);
		//list集合传入前台
		req.setAttribute("pageInfo", pageInfo);
		return "background/BackgroundCourseShow";
}
		
	//因为要通过学科查课程,所以要查出所有的学科
	@RequestMapping("courseAddShow.do")
	public String showSubject(HttpServletRequest req,HttpServletResponse resp){
	////通过请求转发把select()查询出的全部结果放进list里,传给show
		req.setAttribute("list",subjectService.selectAll() );
		//返回给add.jsp
		return "background/BackgroundCourseAdd";
	}
	//添加
	@RequestMapping("courseAdd.do")
	public String add(Course course,HttpServletRequest req,HttpServletResponse resp){
		//调用service的add方法
		service.add(course);
		//重定向到show.jsp,用请求转发会每次刷新就添加一次数据
		return "redirect:BackgroundCourseShow";
		
	}
	//数据回显
	@RequestMapping("courseUpdateShow.do")
	public String byId(int id,HttpServletRequest req,HttpServletResponse resp){
		//先查出所有数据,然后将查出的全部结果入list里,
		req.setAttribute("course", service.selectById(id));
		//返回给update.jsp
		return "background/BackgroundCourseUpdate";
		
	}
	//修改
	@RequestMapping("courseUpdate.do")
	public String update(Course course,HttpServletRequest req,HttpServletResponse resp){
		//调用service的update方法
		service.update(course);
		//更改后返回show.jsp
		return "redirect:BackgroundCourseShow";
		
	}
	//删除一个
	@ResponseBody
	@RequestMapping("courseDelete.do")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		//调用service的delete方法
		service.delete(id);
		//返回给success
		return "success";
	}
	//批量删除
	@RequestMapping("courseDeleteAll.do")
	//批量删除参数传入int数组
	public String deleteAll(Integer[] select,HttpServletRequest req,HttpServletResponse resp){
		System.out.println(select[0]);
		//调用service的deleteAll方法
		service.deleteAll(select);
		//删除后返回给show.jsp
		return "redirect:BackgroundCourseShow";
		
	}
	//查出科目
	@RequestMapping("courseWithVideoAndSubject.do")
	public String subject(Integer subjectId,HttpServletRequest req,HttpServletResponse resp){
		List<Course> courses = service.selectBySubjectId(subjectId);
		req.setAttribute("courses", courses);
		System.out.println(courses);
		return "foreground/CourseShow";
	}
}
