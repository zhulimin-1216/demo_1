package com.zhiyou.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Video;

public interface VideoService {

	//��ȫ��
	PageInfo<Video> select(int page,Video video);
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
	//������Ƶ
	Video playVideo(Integer videoId);
/*	//ģ����ѯ
	List<Video>selectLike(String name);
	//��ҳ
	PageInfo<Video> selectPage(int page);*/
}
