package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	public boolean existsByEmail(String email);
	public UserDtls findByEmail(String email);
	
	public UserDtls findByEmailAndMobileNumber(String email,String mobileNum);
}
