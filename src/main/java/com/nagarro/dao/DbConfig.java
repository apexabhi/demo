package com.nagarro.dao;

import org.hibernate.Session;

public interface DbConfig {
	public Session getSession();
	public void beginSession();
	public void commitTransaction();
	public void closeSession();
	
}
