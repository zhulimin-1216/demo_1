package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

public interface VideoDao {

	//��ȫ��
	List<Video> select(@Param("page")int page,@Param("v")Video video);
	//����ɾ��
	void deleteAll(Integer[] ids);
	//ɾ��һ��
	void delete(Integer id);
	//���
	void add(Video video);
	//����
	void update(Video video);
	//����
	Video  selectById(Integer id);
	//��Ƶ���Ŵ���
	void addPlayNum(Integer id);
	//ģ����ѯ
/*	List<Video>selectLike(String name);*/
	//��ҳ
/*	PageInfo<Video> selectPage(int page);*/
}
