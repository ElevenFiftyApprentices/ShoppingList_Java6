package org.elevenfifty.shopping.controller;

import javax.validation.Valid;

import org.elevenfifty.shopping.beans.User;
import org.elevenfifty.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	// Anthony: method to display User info page
	@GetMapping("/user/{id}")
	public String user(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);

		model.addAttribute("user", u);

		return "user_detail";
	}
	//Anthony: Methods for creating new users in the user list
	@GetMapping("/user/add")
	public String userAdd(Model model, User user) {
		User u = new User();
		model.addAttribute(user);
		return "user_add";
	}

	@PostMapping("/user/add")
	public String userAddSave(@ModelAttribute @Valid User user, Model model) {

		userRepo.save(user);
		return "redirect:/user/" + user.getId();
	}
	//Anthony: Method for deleting user from user list
	@PostMapping("/user/list")
	public String userListDelete( Model model, @RequestParam(name = "userId") int userId) {
		
		userRepo.delete(userRepo.findOne(userId));
		return "redirect:/index";
	}
	
	
	//Anthony: methods for adding a new user through Login page
	@GetMapping("/user/new")
	public String userNew(Model model, User user) {
		User u = new User();
		model.addAttribute(user);
		return "user_new";
	}

	@PostMapping("/user/new")
	public String userNewSave(@ModelAttribute @Valid User user, Model model) {

		userRepo.save(user);
		return "redirect:/login";
	}
	//Anthony: method for deleting user on user page.
	@PostMapping("/user/{id}")
	public String userDelete( Model model, @RequestParam(name = "userId") int userId) {
		
		userRepo.delete(userRepo.findOne(userId));
		return "redirect:/index";
	}
	
}
