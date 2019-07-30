package com.risk.dao;

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
		persist(user);
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	/*
	 * public static String getMD5EncryptedValue(String password) { final byte[]
	 * defaultBytes = password.getBytes(); try { final MessageDigest md5MsgDigest =
	 * MessageDigest.getInstance("MD5"); md5MsgDigest.reset();
	 * md5MsgDigest.update(defaultBytes); final byte messageDigest[] =
	 * md5MsgDigest.digest();
	 * 
	 * final StringBuffer hexString = new StringBuffer(); for (final byte element :
	 * messageDigest) { final String hex = Integer.toHexString(0xFF & element); if
	 * (hex.length() == 1) { hexString.append('0'); } hexString.append(hex); }
	 * password = hexString + ""; } catch (final NoSuchAlgorithmException nsae) {
	 * nsae.printStackTrace(); } return password; }
	 */
	

}
