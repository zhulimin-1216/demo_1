package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Admin;
import com.zhiyou.model.User;

public class AdminInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��ȡsession�е�ADMIN
		Admin admin = (Admin) request.getSession().getAttribute("ADMIN");
		if(admin==null){//�����û�û�е�¼
			response.sendRedirect("index.jsp");//�ض��򵽵�¼ҳ��
			return false;//���÷���controller
		}
		return true;//���û��if��ʾ��¼��,���Է���controller
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