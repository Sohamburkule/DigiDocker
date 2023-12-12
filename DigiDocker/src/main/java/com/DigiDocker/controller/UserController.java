package com.DigiDocker.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Documents> documents = userDao.getDocumentsByUser(us);
		model.addAttribute("list", documents);
		return "ViewDocument";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully");
		return "redirect:/login";
	}

	@RequestMapping(path = "/saveDocuments", method = RequestMethod.POST)
	public String saveDocuments(@ModelAttribute Documents documents, HttpSession session) {

		try {
			User us = (User) session.getAttribute("userObj");
			documents.setUser(us);
			// Handle the conversion from MultipartFile to byte[]
			if (documents.getFile() != null && !documents.getFile().isEmpty()) {
				documents.setFileData(documents.getFile().getBytes());
			}
			userDao.saveDocuments(documents);
			session.setAttribute("msg", "Document Added Sucessfully");
		} catch (Exception e) {
			session.setAttribute("msg", "Error adding document: " + e.getMessage());
		}
		return "redirect:/user/AddDocument";
	}
	
	@RequestMapping("/editDocuments")
	public String editDocuments(@RequestParam("id") int id, Model m) {
		Documents n = userDao.getDocumentsById(id);
		m.addAttribute("documents", n);
		return "EditDocument";
	}
	
	@RequestMapping("/deleteDocuments")
	public String deleteDocuments(@RequestParam("id") int id, HttpSession session) {
		userDao.deleteDocuments(id);
		session.setAttribute("msg", "Document Deleted Sucessfully");
		return "ViewDocument";
	}
	
	@RequestMapping(path = "/updateDocuments", method = RequestMethod.POST)
	public String updateDocuments(@ModelAttribute Documents documents, HttpSession session) {

		try {
			User us = (User) session.getAttribute("userObj");
			documents.setUser(us);
			// Handle the conversion from MultipartFile to byte[]
			if (documents.getFile() != null && !documents.getFile().isEmpty()) {
				documents.setFileData(documents.getFile().getBytes());
			}
			userDao.updateDocuments(documents);
			session.setAttribute("msg", "Document updated Sucessfully");
		} catch (Exception e) {
			session.setAttribute("msg", "Error adding document: " + e.getMessage());
		}
		return "EditDocument";
	}
}
