package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.model.UserPayVerifyDtls;
 

public interface UserPayVerifyRepository extends JpaRepository<UserPayVerifyDtls, Integer>{
      
	public  UserPayVerifyDtls findByverificationCode(String code);
}
