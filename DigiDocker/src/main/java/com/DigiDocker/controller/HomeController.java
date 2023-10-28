package com.DigiDocker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DigiDocker.entity.User;

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
	
	@RequestMapping(path="/registerUser",method= RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,HttpSession session) {
		
		System.out.println(user);
		return "redirect:/register";
	}
}
