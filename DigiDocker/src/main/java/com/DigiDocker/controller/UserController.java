package com.DigiDocker.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.DigiDocker.dao.UserDao;
import com.DigiDocker.entity.Documents;
import com.DigiDocker.entity.User;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/AddDocument")
	public String AddDocument() {
		return "AddDocument";
	}

	@RequestMapping("/ViewDocument")
	public String ViewDocument(HttpSession session, Model model) {

		User us = (User) session.getAttribute("userObj");
		List<Documents> list = userDao.getDocumentsByUser(us);
		model.addAttribute("list", list);
		System.out.println(list);
		return "ViewDocument";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "redirect:/login";
	}

	@RequestMapping(path = "/saveDocuments", method = RequestMethod.POST)
	public String saveDocuments(@RequestParam("FileData") MultipartFile file, HttpSession session,
			@RequestParam("FileTitle") String FileTitle, @RequestParam("FileDescription") String FileDescription) {

		User us = (User) session.getAttribute("userObj");
		try {
			Documents documents = new Documents();
			documents.setUser(us);
			documents.setFileTitle(FileTitle);
			documents.setFileDescription(FileDescription);
			documents.setFileData(file.getBytes());

			userDao.saveDocuments(documents);
			session.setAttribute("msg", "Document Added Sucessfully");
			return "redirect:/user/AddDocument";

		} catch (Exception e) {
			System.out.println("File Upload Error" + e);
			session.setAttribute("msg", "File Not Found");
			return "redirect:/user/AddDocument";
		}
	}
}
