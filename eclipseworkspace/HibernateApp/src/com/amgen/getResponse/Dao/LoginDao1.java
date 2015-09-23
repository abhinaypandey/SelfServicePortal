package com.amgen.getResponse.Dao;

import com.amgen.getResponse.entity.userProfileManagement.User;

public interface LoginDao1 {
	//public boolean authenticate(String username, String password) ;
	public User getUserByUsername(String username);
	public boolean loginCheck(String username,String password);
}
