package org.elevenfifty.shopping.controller;


import org.elevenfifty.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
}
