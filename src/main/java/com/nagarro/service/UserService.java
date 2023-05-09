package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Userdao;
import com.nagarro.dto.User;

public class UserService {
	@Autowired
	Userdao userdao;
	
	public boolean checkUser(String uname, String pwd) {
		User user = userdao.getUser(uname);
		return user != null && user.getPassword().equals(pwd);
	}

	public void saveUser(String uname, String pwd) {

		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		userdao.insertUser(user);

	}

}
