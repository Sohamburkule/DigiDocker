package com.DigiDocker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@RequestMapping("/AddDocument")
	public String AddDocument()
	{
		return "AddDocument";
	}
	
	@RequestMapping("/ViewDocument")
	public String ViewDocument()
	{
		return "ViewDocument";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "login";
	}
}
