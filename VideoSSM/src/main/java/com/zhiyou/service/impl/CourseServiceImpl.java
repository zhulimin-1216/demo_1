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

		//���þ�̬����PageHelper.startPage(page(��ǰҳ), 5(һҳ�ּ�������))
		PageHelper.startPage(page,5);
		//����ѯ�����Ľ��������list��
		List<Course> list = dao.select();
		//newһ��pageInfo ����list(list,2)��������ֿ��Դ���ҳ��չʾ��ҳ
		//��:��һҳ 123��һҳ ,�����������ʾչʾ��ҳ
		return new PageInfo<Course>(list);
	}


}
