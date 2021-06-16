package com.dh.narihair.controller;

import com.dh.narihair.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired 
	private TempService tempService;
	@Autowired
	Environment env;
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		return "redirect:/main";
	}

	@RequestMapping("/main")
	public String main(ModelMap model) {
		return "/content/main";
	}
}
