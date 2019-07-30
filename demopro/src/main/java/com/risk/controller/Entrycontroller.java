package com.risk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.risk.model.User;
import com.risk.service.UserService;

@Controller
public class Entrycontroller {

	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/")
	public String register(Model model) {
		model.addAttribute("data", new User());

		return "register";
	}

	@RequestMapping(value = "/success_register", method = RequestMethod.POST)
	public String registerSuccess(@Valid @ModelAttribute("data") User user, BindingResult result,ModelMap model) {

		if (result.hasErrors()) {
			return "register";
		}
		
		service.saveEmployee(user);
		
		model.addAttribute("success", "Employee " + user.getName() + " registered successfully");
        return "success";
	

	}
	

}
