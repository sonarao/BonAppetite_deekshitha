package com.risk.dao;





import java.util.List;

import com.risk.model.User;

public interface UserDao {
	
	
	
	void saveEmployee(User user);

	public List<User> getActiveUser(String value); 
	
	
	

}
