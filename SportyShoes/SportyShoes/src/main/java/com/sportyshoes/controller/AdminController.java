package com.sportyshoes.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.entity.Admin;

@Controller
public class AdminController 
{
	@GetMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute(name="loginForm")Admin admin,Model model)
	{
		String username=admin.getUsername();
		String password=admin.getPassword();
		
		if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin"))
		{
			model.addAttribute("username",username);
			model.addAttribute("password",password);
			return "dashboard";
		}
		model.addAttribute("error","Incorrect Username and Password");
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	



	
	
}
