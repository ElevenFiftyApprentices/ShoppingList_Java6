package org.elevenfifty.shopping.controller;


import org.elevenfifty.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
