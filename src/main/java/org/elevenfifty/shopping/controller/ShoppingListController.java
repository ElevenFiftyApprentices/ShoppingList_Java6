package org.elevenfifty.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.elevenfifty.shopping.beans.ShoppingList;
import org.elevenfifty.shopping.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/ShoppingList/{id}")
	public String list(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
//never forget to import the proper beans!
		ShoppingList u = listRepo.findOne(id);

		model.addAttribute("list", u);

// yes I am going with listing the lists, I thought it would be funny. 
		return "list_list";
	}
}
