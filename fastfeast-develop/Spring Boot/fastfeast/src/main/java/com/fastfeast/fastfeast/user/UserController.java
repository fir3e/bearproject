package com.fastfeast.fastfeast.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserDAO userDAO;

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping(value = "/registeruser")
  public String registerUser(@RequestParam("email") String email, @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("name") String name, @RequestParam("birthDate") String birthDate,
      @RequestParam("role") String role) {
    User user = new User(name, username, password, email, birthDate, role);
    userDAO.insertUser(user);
    return "redirect:/";
  }

}