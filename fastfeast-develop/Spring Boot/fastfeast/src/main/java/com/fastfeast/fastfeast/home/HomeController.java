package com.fastfeast.fastfeast.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fastfeast.fastfeast.user.User;
import com.fastfeast.fastfeast.user.UserDAO;

@Controller
public class HomeController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping("/")
	public String listUsers(Model model) {
		List<User> userList = userDAO.listUsers();
		model.addAttribute("users", userList);
		return "index";
	}
}