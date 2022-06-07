package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sportyshoes.entity.Product;
import com.sportyshoes.exception.ProductNotFoundException;
import com.sportyshoes.service.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	ProductService productservice;
	
	@GetMapping("/manageproduct")
    public ModelAndView manageproduct()
    {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("manageproduct");
    	return mv;	
    }
	
	
	@GetMapping("/addProduct")
	public String addProduct()
	{
		return "addProduct";
	}
	
	@RequestMapping("/saveproduct")
	public String saveProduct(@ModelAttribute Product product,Model model)
	{
		productservice.saveProduct(product);
		int id=productservice.saveProduct(product).getId();
		String message="Product with ID '"+id+"' Saved Succesfully";
		model.addAttribute("message", message);
		return "addProduct";
	}
	
	@GetMapping("/allproduct")
	public String showAllproduct(@RequestParam(value="message",required=false)String message,Model model)
	{
		List<Product>list=productservice.getAllProduct();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "allproduct";
	}
	
	@GetMapping("/editproduct")
	public String editProduct(Model model,RedirectAttributes attributes,@RequestParam int id)
	{
			Product product=productservice.getProductById(id);		        
			model.addAttribute("product", product);
			
		return "editproduct";
	}
	
	@PostMapping("/update")
	    public String updateProduct(
	            @ModelAttribute Product product,
	            RedirectAttributes attributes
	            ) {
		   productservice.updateProduct(product);
	       int id = product.getId();
	       attributes.addAttribute("message", "Product with id: '"+id+"' is updated successfully !");
	       return "redirect:allproduct";
	    }
	
	 @GetMapping("/delete")
	    public String deleteProduct(
	            @RequestParam int id,
	            RedirectAttributes attributes
	            ) {
	        try {
	        productservice.deleteById(id);
	        attributes.addAttribute("message", "Product with Id : '"+id+"' is removed successfully!");
	        } catch (ProductNotFoundException e) {
	            e.printStackTrace();
	            attributes.addAttribute("message", e.getMessage());
	        }
	        return "redirect:allproduct";
	    }
	}
	

