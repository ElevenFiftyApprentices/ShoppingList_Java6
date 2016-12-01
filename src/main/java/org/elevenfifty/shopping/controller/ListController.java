package org.elevenfifty.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.shopping.beans.List;
import org.elevenfifty.shopping.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {

	@Autowired
	private ListRepository listRepo;

	@GetMapping("")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	@GetMapping("/ListsofLists")
	public String List(Model model) {
		model.addAttribute("lists", listRepo.findAll());
		return "list_of_lists";
	}

	@GetMapping("/ListsofLists/{id}")
	public String list(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		// never forget to import the proper beans!
		List u = listRepo.findOne(id);

		model.addAttribute("lists", u);

		// yes I am going with listing the lists, I thought it would be funny.
		return "list_list";
	}

	// GetMapping and PostMapping for editing items in lists.
	@GetMapping("/ListsofLists/{id}/edit")
	public String listEdit(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		List u = listRepo.findOne(id);
		model.addAttribute("lists", u);
		return "list_edit";
	}

	@PostMapping("/ListsofLists/{userId}/edit")
	public String listEditSave(@ModelAttribute @Valid List list, BindingResult result, Model model) {
		listRepo.save(list);
		return "redirect:/ListsofLists/" + list.getId();
	}
}
