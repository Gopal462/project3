package com.sportyshoes.respositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Product;

@Repository
public interface ProductRepositry extends CrudRepository<Product, Integer>
{

}
