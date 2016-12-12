package org.elevenfifty.shopping.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.shopping.beans.List;
import org.elevenfifty.shopping.beans.ListItem;
import org.elevenfifty.shopping.beans.User;
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

	// Anthony: method for displaying lists
	@GetMapping("/ListsofLists")
	public String List(Model model) {
		model.addAttribute("lists", listRepo.findAll());

		return "list_of_lists";

	}

	// Anthony: methods for adding and editing lists
	@GetMapping("/ListsofLists/add")
	public String listAdd(Model model, List list) {
		List u = new List();
		model.addAttribute(list);
		return "add_list";
	}

	@PostMapping("/ListsofLists/add")
	public String listSave(@ModelAttribute @Valid List list, BindingResult result, Model model) {
		list.setCreatedUtc(new Date(System.currentTimeMillis()));
		list.setModifiedUtc(new Date(System.currentTimeMillis()));
		listRepo.save(list);
		return "redirect:/ListsofLists";
	}

	// Anthony: PostMapping for deleting lists
	@PostMapping("/ListsofLists")
	public String listDelete(Model model, @RequestParam(name = "listId") int listId) {
		listRepo.delete(listRepo.findOne(listId));
		return "redirect:/ListsofLists";
	}

	// //Checkboxes
	//
	@GetMapping("/ListsofLists/{id}/check/")
	public String listCheck(Model model, @PathVariable(name = "id") int id) {
		// User currentUser = ListController.getCurrentUser();
		// if(!currentUser.equals(listRepo.findOne(id).getUser())){
		// return "redirect:/ListsofLists";
		// } else {
		List i = listRepo.findOne(id);
		i.setIsChecked(true);
		listRepo.save(i);
		model.addAttribute("lists", listRepo.findAll());
		// model.addAttribute("lists", listRepo.findOne(id).getLists());
		return "list_of_lists";
	}	


@GetMapping("/ListsofLists/{id}/uncheck/")
public String listUncheck(Model model, @PathVariable(name = "id") int id) {
	List i = listRepo.findOne(id);
	i.setIsChecked(false);
	listRepo.save(i);
	model.addAttribute("lists", listRepo.findAll());
    return "list_of_lists";
    }


@PostMapping("/ListsofLists/{id}/check/")
public String listCheckDelete(Model model, @RequestParam(name = "listId") int listId) {
	listRepo.delete(listRepo.findOne(listId));
	return "redirect:/ListsofLists";
}
@PostMapping("/ListsofLists/{id}/uncheck/")
public String listUncheckDelete(Model model, @RequestParam(name = "listId") int listId) {
	listRepo.delete(listRepo.findOne(listId));
	return "redirect:/ListsofLists";
}
}