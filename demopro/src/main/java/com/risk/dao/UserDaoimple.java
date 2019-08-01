package com.risk.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;


import com.risk.model.User;

@Repository
public class UserDaoimple extends AbstractDao<Integer, User> implements UserDao{
	
	
	
	@Override
	public void saveEmployee(User user) {
		/*
		 * String EncrpPass=getMD5EncryptedValue(user.getPassword());
		 * user.setPassword(EncrpPass);
		 */
		
		String EncrpPass=hashPassword(user.getPassword());
		user.setPassword(EncrpPass);
		try {
			persist(user);
		}catch (Exception e) {
			System.out.println("----------------------My exception------------------------"+e.toString());
		}
		
	}
	
	
	private String hashPassword(String plainTextPassword){
		/* return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt()); */
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getActiveUser(String email) {
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", email));
		
		
		
		 return (List<User>)  criteria.list();
		
		/*
		 * User user;
		 * 
		 * Query oneUser = null; try {
		 * 
		 * oneUser = getOneUser(value); System.out.println(oneUser);
		 * 
		 * } catch (NoResultException e) { user = null; }
		 * 
		 * return oneUser;
		 */
	}

	
	

}
