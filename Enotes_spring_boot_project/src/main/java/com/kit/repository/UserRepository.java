package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.kit.entity.User;
@Repository 
public interface UserRepository extends JpaRepository<User, Integer>{
	//public boolean existByEmail(String email);
	
	public User fingByEmail(String email);
}