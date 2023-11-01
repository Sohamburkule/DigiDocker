package com.DigiDocker.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/")
public class UserController {

	@RequestMapping("/AddDocument")
	public String AddDocument() {
		return "AddDocument";
	}

	@RequestMapping("/ViewDocument")
	public String ViewDocument() {
	
		return "ViewDocument";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "redirect:/login";
	}
	
	@RequestMapping(path = "/saveDocuments", method = RequestMethod.POST)
	public String saveDocuments() {

		return "redirect:/user/AddDocument";
	}
}
