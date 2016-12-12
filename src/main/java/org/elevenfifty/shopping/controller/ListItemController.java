package org.elevenfifty.shopping.controller;

import java.util.Date;

import javax.validation.Valid;

import org.elevenfifty.shopping.beans.ListItem;
import org.elevenfifty.shopping.repository.ListItemRepository;
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
public class ListItemController {
	
	@Autowired
	private ListItemRepository listItemRepo;

	//Anthony: controller for displaying list items
	@GetMapping("/ListsofLists/{id}")
	public String listitems(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		model.addAttribute("listItems", listItemRepo.findAll());
		//Anthony: yes I am going with listing the lists, I thought it would be funny. Edit: I am horrible at naming conventions
		return "list_list";
	}

	// Anthony: GetMapping and PostMapping for editing items in lists.
	@GetMapping("/ListsofLists/{id}/add")
	public String listItemAdd(Model model, ListItem listItem) {
		 ListItem u = new ListItem();
		 model.addAttribute(listItem);
		return "list_item_add";
	}

	@PostMapping("/ListsofLists/{id}/add")
	public String listItemSave(@ModelAttribute @Valid ListItem listItem, BindingResult result, Model model) {
		//Anthony: Rather then allow user error, we are just having these time fields being auto created by the system
		listItem.setCreatedUtc(new Date(System.currentTimeMillis()));
		listItem.setModifiedUtc(new Date(System.currentTimeMillis()));
		listItemRepo.save(listItem);
		return "redirect:/ListsofLists/{id}";
	}

	// Anthony: PostMapping for deleting items in a list
	@PostMapping("/ListsofLists/{id}")
	public String listItemDelete(Model model, @RequestParam(name = "id") int id) {
		listItemRepo.delete(listItemRepo.findOne(id));
		return "redirect:/ListsofLists/{id}";
	}
	@GetMapping("/ListsofLists/{id}/uncheck/{itemid}")
	public String listItemUncheck(Model model, @PathVariable(name = "itemid") int itemid, @PathVariable(name = "id") int id) {
		// User currentUser = ListController.getCurrentUser();
		// if(!currentUser.equals(shoppingListRepo.findOne(id).getUser())){
		// return "redirect:/lists";
		// } else {
		ListItem i = listItemRepo.findOne(itemid);
		i.setChecked(false);
		listItemRepo.save(i);
		model.addAttribute("listItems", listItemRepo.findAll());
		return "list_list";
	}
	@GetMapping("/ListsofLists/{id}/check/{itemid}")
	public String listItemCheck(Model model, @PathVariable(name = "itemid") int itemid, @PathVariable(name = "id") int id) {
		// User currentUser = ListController.getCurrentUser();
		// if(!currentUser.equals(shoppingListRepo.findOne(id).getUser())){
		// return "redirect:/lists";
		// } else {
		ListItem i = listItemRepo.findOne(itemid);
		i.setChecked(true);
		listItemRepo.save(i);
		model.addAttribute("listItems", listItemRepo.findAll());
		return "list_list";
	}
	@PostMapping("/ListsofLists/{id}/uncheck/{itemid}")
	public String listItemUncheckDelete(Model model, @RequestParam(name = "id") int id) {
		listItemRepo.delete(listItemRepo.findOne(id));
		return "redirect:/ListsofLists/{id}";
	}
	@PostMapping("/ListsofLists/{id}/check/{itemid}")
	public String listItemCheckDelete(Model model, @RequestParam(name = "id") int id) {
		listItemRepo.delete(listItemRepo.findOne(id));
		return "redirect:/ListsofLists/{id}";
	}
}
