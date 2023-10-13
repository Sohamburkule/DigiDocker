package com.DigiDocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "register";
	}
	
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
}