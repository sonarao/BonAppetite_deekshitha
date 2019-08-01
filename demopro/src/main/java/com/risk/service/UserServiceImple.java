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
	public boolean saveEmployee(User user) {
		
		if (dao.getActiveUser(user.getEmail()).size() == 0) {
			dao.saveEmployee(user);
			return true;
		}
		return false;
		

	}

	@Override
	public boolean isEmailAlreadyInUse(String value) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean isEmailAlreadyInUse(String value) {
//		boolean emailInDb = false;
//
//		if (dao.getActiveUser(value).size() == 0) {
//
//			 emailInDb=true;
//		}
//
//		List<User> l = new ArrayList<User>();
//		if (dao.getActiveUser(value) != null) {
//
//			l.addAll(dao.getActiveUser(value));
//
//		}
//
//		if (l.size() == 0) {
//			emailInDb = false;
//		}
//		return emailInDb;
//		
//		
//		
//	}

}
