package org.elevenfifty.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.shopping.beans.List;
import org.elevenfifty.shopping.beans.ListItem;
import org.elevenfifty.shopping.repository.ListItemRepository;
import org.elevenfifty.shopping.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {
	
	@Autowired
	private ListRepository listRepo;

	@GetMapping("")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	// method for displaying lists
	@GetMapping("/ListsofLists")
	public String List(Model model) {
		model.addAttribute("lists", listRepo.findAll());
		return "list_of_lists";

	}
	//methods for adding and editing lists
	@GetMapping("/ListsofLists/add")
	public String listAdd(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		List u = listRepo.findOne(id);
		model.addAttribute("lists", u);
		return "add_list";
	}

	@PostMapping("/ListsofLists/add")
	public String listSave(@ModelAttribute @Valid List list, BindingResult result, Model model) {
		
		listRepo.save(list);
		return "redirect:/ListsofLists";
	}
	@PostMapping("/ListsofLists")
	public String listDelete(Model model, @RequestParam(name = "listId")int listId) {
		listRepo.delete(listRepo.findOne(listId));
		return "redirect:/ListsofLists";
	}

}