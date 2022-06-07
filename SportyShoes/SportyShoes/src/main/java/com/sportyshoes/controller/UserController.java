package com.sportyshoes.controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.entity.Product;
import com.sportyshoes.entity.User;
import com.sportyshoes.entity.UserVerify;
import com.sportyshoes.service.UserService;


@Controller
public class UserController
{
	@Autowired
	UserService userservice;
	
	@GetMapping("/useroperation")
    public ModelAndView userlist()
    {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("useroperation");
    	return mv;	
    }
	
	@GetMapping("/userlist")
	public String showAllproduct(@RequestParam(value="message",required=false)String message,Model model)
	{
		List<User>list=userservice.getAllUser();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "userlist";
	}
	
	
	@GetMapping("/userlogin")
	public String showlogin()
	{
		return "userlogin";
	}
    
	
		
	@GetMapping("/userregistration")
	public String UserRegistration()
	{
		return "userregistration";
	}
	
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user,Model model) throws ParseException
	{
	;
		userservice.saveuser(user);
		return "userregistration";
	}
	
	
	
	
}
