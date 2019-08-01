package com.risk.service;


import com.risk.model.User;

public interface UserService {
	
	boolean saveEmployee(User user);

	boolean isEmailAlreadyInUse(String value);

	

}
