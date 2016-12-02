package org.elevenfifty.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
	@Autowired
	private ListItemRepository listItemRepo;

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

	// controller for displaying list items
	@GetMapping("/ListsofLists/{id}")
	public String listitems(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id",id);
		model.addAttribute("list_items", listItemRepo.findAll());
		// yes I am going with listing the lists, I thought it would be funny.
		return "list_list";
	}

	// GetMapping and PostMapping for editing items in lists.
	@GetMapping("/ListsofLists/{id}/add")
	public String listItemAdd(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		ListItem u = listItemRepo.findOne(id);
		model.addAttribute("list_items", u);
		return "list_item_add";
	}

	@PostMapping("/ListsofLists/{id}/add")
	public String listItemSave(@ModelAttribute @Valid ListItem listItem, BindingResult result, Model model) {
		listItemRepo.save(listItem);
		return "redirect:/ListsofLists/{id}";
	}
//PostMapping for deleting items in a list
	@PostMapping("/ListsofLists/{id}")
	public String listItemDelete(Model model, @RequestParam(name = "id") int id) {

		listItemRepo.delete(listItemRepo.findOne(id));
		return "redirect:/ListsofLists/{id}";
	}
}
