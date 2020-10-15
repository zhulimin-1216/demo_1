package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;

public interface CourseDao {
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
	////ȫ����Ŀ����
	List<Course> selectBySubjectId(int subjectId);
	//��ҳ
	PageInfo<Course> selectPage(int page);
}
