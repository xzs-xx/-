package com.ssm.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerIntercept implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("1.afterCompletion");		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("1.postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("1.preHandle");
		StringBuffer url = request.getRequestURL();
		//ַ
		if(url.indexOf("login.do")>=0){
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username!=null){
			System.out.println(username+":"+"成功");
			return true;
		}else{
			if(url.indexOf("findUsername.do")>=0){
				return true;
			}
			request.getRequestDispatcher("/login.jsp").forward(request, arg1);
		}
		return false;
	}

}
