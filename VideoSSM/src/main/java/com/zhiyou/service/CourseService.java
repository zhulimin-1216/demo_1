package com.zhiyou.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;

public interface CourseService {

	//��ȫ��
	List<Course> select();
	//����ɾ��
	void deleteAll(Integer[] ids);
	//ɾ��һ��
	void delete(Integer id);
	//���
	void add(Course course);
	//����
	void update(Course course);
	//����
	Course selectById(Integer id);
	//ȫ����Ŀ����
	List<Course> selectBySubjectId(int subjectId);
	//��ҳ
	PageInfo<Course> selectPage(int page);
}
