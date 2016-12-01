package org.elevenfifty.shopping.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.shopping.beans.ShoppingList;
import org.elevenfifty.shopping.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

		model.addAttribute("lists", u);

// yes I am going with listing the lists, I thought it would be funny. 
		return "list_list";
	}
	// GetMapping and PostMapping for editing items in lists.
//	@GetMapping("/user/{id}/edit")
//	public String userEdit(Model model, @PathVariable(name = "id") int id) {
//		model.addAttribute("id", id);
//		User u = userRepo.findOne(id);
//		model.addAttribute("user", u);
//		return "user_edit";
//	}
//
//	@PostMapping("/user/{userId}/edit")
//	public String userEditSave(@ModelAttribute @Valid User user, BindingResult result, Model model,
//			@RequestParam("file") MultipartFile file,
//			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {
//
//		log.info("here");
//		if (result.hasErrors()) {
//			model.addAttribute("user", user);
//			//
//			return "user_edit";
//		} else {
//			if (removeImage) {
//				// See if the user even has an user image
//				UserImage image = userImageRepo.findByUserId(user.getId());
//				if (image != null) {
//					// Removes if it exists
//					userImageRepo.delete(image);
//					log.info("Image Removed" + user.getId());
//
//				}
//			}
//			// Check to see if there is an upload file
//			else if (file != null && !file.isEmpty()) {
//
//				try {
//					// Load the file in the proper format(Spring does this!)
//
//					// Load or create a UserImage
//					UserImage image = userImageRepo.findByUserId(user.getId());
//
//					if (image == null) {
//						image = new UserImage();
//						image.setUserId(user.getId());
//
//					}
//					image.setContentType(file.getContentType());
//					image.setImage(file.getBytes());
//
//					// Store in a Database
//					userImageRepo.save(image);
//				} catch (IOException e) {
//					log.error("Failed to upload file", e);
//				}
//			}
//			userRepo.save(user);
//			return "redirect:/user/" + user.getId();
//		}
//	}
}

