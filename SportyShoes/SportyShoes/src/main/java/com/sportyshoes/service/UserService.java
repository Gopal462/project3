package com.sportyshoes.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Product;
import com.sportyshoes.entity.User;
import com.sportyshoes.exception.ProductNotFoundException;
import com.sportyshoes.respositry.UserRepositry;

@Service
public class UserService
{
	@Autowired
	UserRepositry userrepo;
	
	public User saveuser(User user)
	{
		return userrepo.save(user);
	}
	
	 public List<User> getAllUser()
	    {
	    	List<User>list=new ArrayList<User>();
	    	userrepo.findAll().forEach(user ->list.add(user));
			return list;
	    }

	   
	
     
	 
	 
	
	
	 
	
}
