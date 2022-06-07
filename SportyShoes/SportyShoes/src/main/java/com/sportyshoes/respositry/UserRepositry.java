package com.sportyshoes.respositry;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepositry extends JpaRepository<User, Integer>
{
	
	
	

    
   



	
}
