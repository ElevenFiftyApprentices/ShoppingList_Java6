package org.elevenfifty.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.elevenfifty.shopping.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingListController {

	@Autowired
	private ShoppingListRepository listRepo;
	
	@GetMapping("")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}
	
	@GetMapping("/ShoppingList")
	public String ShoppingList(Model model){
		model.addAttribute("Shopping List", listRepo.findAll());
		return "shopping_list";
	}
}
