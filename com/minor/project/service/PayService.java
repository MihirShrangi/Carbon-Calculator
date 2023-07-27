package com.minor.project.service;

import com.minor.project.model.UserPayVerifyDtls;

public interface PayService {
public UserPayVerifyDtls createUser(UserPayVerifyDtls user,String url);
	
	public boolean verifyPayment(String code);
}
