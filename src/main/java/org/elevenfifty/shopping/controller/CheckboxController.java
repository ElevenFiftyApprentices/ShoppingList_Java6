//package org.elevenfifty.shopping.controller;
//
//import java.awt.Checkbox;
//import java.awt.List;
//import java.util.ArrayList;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class CheckboxController {
//	
//		ModelAndView mav = null;
//		@SuppressWarnings("unchecked")
//		@ModelAttribute("listOfLists")
//		public List getListOfLists()
//		{
//			ArrayList listOfLists = new ArrayList();
//			listOfLists.add("Football");
//			return listOfLists;
//		}
//		
//		@SuppressWarnings("unchecked")
//		@RequestMapping("/ListOfLists/")
//		public String initializeForm(Map model)
//		{
//			Checkbox cb = new Checkbox();
//			model.put("cb",cb);
//			return "/ListOfLists";
//			
//		}
//		@RequestMapping("/ListOfLists/")
//		public String processForm(@Valid @ModelAttribute("cb") Checkbox cb,BindingResult result)
//		{
//			if(result.hasErrors())
//			{
//				return "/ListOfLists";
//			}
//			else
//			{
//
//				return "/ListOfLists";
//			}
//}
//}
//
