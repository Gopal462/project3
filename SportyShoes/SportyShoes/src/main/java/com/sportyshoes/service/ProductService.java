package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportyshoes.entity.Product;

import com.sportyshoes.exception.ProductNotFoundException;
import com.sportyshoes.respositry.ProductRepositry;

@Service
public class ProductService 
{
    @Autowired
	ProductRepositry productrepo;
    
    public Product saveProduct(Product product)
    {
    	return productrepo.save(product);
    }
	
	
    public List<Product> getAllProduct()
    {
    	List<Product>list=new ArrayList<Product>();
    	productrepo.findAll().forEach(product ->list.add(product));
		return list;
    }
    public Product getProductById(int id) {
        Optional<Product> opt = productrepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new ProductNotFoundException("Product with Id : "+id+" Not Found");
        }
     }
    
    public void deleteById(int id)
    {
    	productrepo.deleteById(id);
    }
    
   
    public void updateProduct(Product product)
    {
    	productrepo.save(product);
    	
    }
    
    
}
