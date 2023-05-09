package com.nagarro.daoimplementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.DbConfig;
import com.nagarro.dao.Userdao;
import com.nagarro.dto.User;

public class UserdaoImp implements Userdao {
	@Autowired
	private DbConfig dbc;
	public User getUser(String uname) {
		dbc.beginSession();
		User user=(User) dbc.getSession().get(User.class,uname);
		dbc.commitTransaction();
		dbc.closeSession();
		return user;
	}
	public void insertUser(User u) {
		dbc.beginSession();
		dbc.getSession().saveOrUpdate(u);
		dbc.commitTransaction();
		dbc.closeSession();
		System.out.println("Register successful");
	}
}
