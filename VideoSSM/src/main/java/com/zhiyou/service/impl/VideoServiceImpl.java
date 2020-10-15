package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.dao.VideoDao;
import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoDao dao;
	public PageInfo<Video> select(int page,Video video) {
		PageHelper.startPage(page,5);
		//����ѯ�����Ľ��������list��
		List<Video> list = dao.select(page,video);
		//newһ��pageInfo ����list(list,2)��������ֿ��Դ���ҳ��չʾ��ҳ
		//��:��һҳ 123��һҳ ,�����������ʾչʾ��ҳ
		return new PageInfo<Video>(list);
	}

	public void deleteAll(Integer[] ids) {
		dao.deleteAll(ids);
		
	}

	public void delete(Integer id) {
		dao.delete(id);
		
	}

	public void add(Video video) {
		dao.add(video);
		
	}

	public void update(Video video) {
		dao.update(video);
		
	}

	public Video selectById(Integer id) {
		
		return dao.selectById(id);
	}


	public Video playVideo(Integer videoId) {
		dao.addPlayNum(videoId);
		return dao.selectById(videoId);
	}
/*	//ģ��
	public List<Video> selectLike(String name) {
		//�жϴ����name�Ȳ�����null
		//����null��ȫ����ѯ
		//������null��ģ����ѯ
		if(name==null||name.equals("")){
			return dao.selectLike(name);
		}
		return dao.selectLike(name);
	}*/
	//��ҳ
/*	public PageInfo<Video> selectPage(int page) {
		//���þ�̬����PageHelper.startPage(page(��ǰҳ), 5(һҳ�ּ�������))
		PageHelper.startPage(page,5);
		//����ѯ�����Ľ��������list��
		List<Video> list = dao.select(page);
		//newһ��pageInfo ����list(list,2)��������ֿ��Դ���ҳ��չʾ��ҳ
		//��:��һҳ 123��һҳ ,�����������ʾչʾ��ҳ
		return new PageInfo<Video>(list);
	}*/
}
