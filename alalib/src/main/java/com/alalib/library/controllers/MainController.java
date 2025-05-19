package com.alalib.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String greeting(Model model) {
		model.addAttribute("title", "Главная страница");
		return "home";
	}

}