package com.DigiDocker.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;

import com.DigiDocker.entity.User;

public class AuthHandler implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		User user=(User)request.getSession().getAttribute("userObj");
		if(user!=null) {
			
			return true;
		}
		else {	
			//response.sendRedirect("error");
			response.getWriter().print("<h1><center>Your Session has expired !</center></h1>");
			return false;
		}
	}
}
