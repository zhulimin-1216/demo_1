package com.zhiyou.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;

public interface CourseService {

	//查全部
	List<Course> select();
	//批量删除
	void deleteAll(Integer[] ids);
	//删除一个
	void delete(Integer id);
	//添加
	void add(Course course);
	//更改
	void update(Course course);
	//回显
	Course selectById(Integer id);
	//全部科目集合
	List<Course> selectBySubjectId(int subjectId);
	//分页
	PageInfo<Course> selectPage(int page);
}
