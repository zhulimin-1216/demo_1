package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.dao.CourseDao;
import com.zhiyou.model.Course;

import com.zhiyou.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseDao dao;
	
	
	public List<Course> select() {
		
		return dao.select();
	}

	public void deleteAll(Integer[] ids) {
		dao.deleteAll(ids);
		
	}

	public void delete(Integer id) {
		dao.delete(id);
		
	}

	public void add(Course course) {
		dao.add(course);		
	}

	public void update(Course course) {
		dao.update(course);		
	}

	public Course selectById(Integer id) {
		
		return dao.selectById(id);
	}

	public List<Course> selectBySubjectId(int subjectId) {
		
		return dao.selectBySubjectId(subjectId);
	}

	public PageInfo<Course> selectPage(int page) {
		
		PageHelper.startPage(page,5);

		//调用静态方法PageHelper.startPage(page(当前页), 5(一页分几条数据))
		PageHelper.startPage(page,5);
		//将查询出来的结果集放入list里
		List<Course> list = dao.select();
		//new一个pageInfo 传入list(list,2)后面的数字可以代表页数展示几页
		//如:上一页 123下一页 ,后面的数字显示展示几页
		return new PageInfo<Course>(list);
	}


}
