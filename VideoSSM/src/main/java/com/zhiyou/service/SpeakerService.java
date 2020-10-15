package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;

public interface SpeakerService {

	//��ȫ��
		List<Speaker> select();
		//����ɾ��
		void deleteAll(Integer[] ids);
		//ɾ��һ��
		void delete(Integer id);
		//���
		void add(Speaker speaker);
		//����
		void update(Speaker speaker);
		//����
		Speaker selectById(Integer id);
}
