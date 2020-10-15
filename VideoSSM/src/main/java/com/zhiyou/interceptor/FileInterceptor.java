package com.zhiyou.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FileInterceptor implements HandlerInterceptor{
	//��ִ��controller����֮ǰִ��,�������true�������,�������false��������
	long maxSize;// �ļ�������С
	
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		// �ȼ��������Ƿ�Ϊ�ļ��ϴ�����
		if(request instanceof MultipartHttpServletRequest){
			// ����ת��Ϊ�ļ��ϴ�����
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			// ��ȡ�ļ�map 
			Map<String,MultipartFile> fileMap = req.getFileMap();
			// �����ļ�map
			for(String key : fileMap.keySet()){
				// ����key ��ö�Ӧ���ļ�
				MultipartFile file = fileMap.get(key);
				// �ȶ��ļ��Ĵ�С����У��
				if(file.getSize() > maxSize){
					return false;
				} else{
					// �ȶ��ļ���׺��ʽ
					// ����ļ����ͣ�ͼƬ�ļ�������Ϊimage/jpeg���������е�ͼƬ�ļ�����image��ͷ��
					String type = file.getContentType();
					// ȥ�ļ����͵�ǰ������
					String pre = type.split("/")[0];
					// ������image�Ա�
					if(!pre.equals("image")){
						return false;
					}
				}
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
