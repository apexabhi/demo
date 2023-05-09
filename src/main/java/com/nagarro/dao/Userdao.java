package com.nagarro.dao;

import com.nagarro.dto.User;

public interface Userdao {
	public void insertUser(User user);
	public User getUser(String uname);
}
