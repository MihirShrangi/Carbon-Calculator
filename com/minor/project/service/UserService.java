package com.minor.project.service;

import com.minor.project.model.UserDtls;

public interface UserService {
	public UserDtls createUser(UserDtls user);
	public boolean checkEmail(String email);
}
