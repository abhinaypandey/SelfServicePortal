package com.amgen.getResponse.Dao;

import com.amgen.getResponse.entity.userProfileManagement.User;

public interface UserDAO {
	public void addUserDetails(String userName, String password, String email,int phone, String address,String firstName,String lastName,int fax );
	
	/**
	 * @param userName
	 * @param password
	 * @param email
	 * @param phone
	 * @param address
	 * @param firstName
	 * @param lastName
	 * @param fax
	 */
	void updateUser(String username, String password, String email, int phone,
			String address, String firstname, String lastname, int fax);
}