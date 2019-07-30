package com.risk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.UserDao;
import com.risk.model.User;

@Service("UserService")
@Transactional
public class UserServiceImple implements UserService {
	
	
	@Autowired
	private UserDao dao;
	
	@Override
	public void saveEmployee(User user) {
		 dao.saveEmployee(user);
		
	}

	
	

}
