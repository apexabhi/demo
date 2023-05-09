package com.nagarro.daoimplementation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nagarro.dao.DbConfig;

public class HiberConfig implements DbConfig {
	private Configuration configuration = new Configuration().configure();
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	private Session session;
	
	public Session getSession() {
		// TODO Auto-generated method stub
		return session;
	}
	public void beginSession() {
		session=sessionFactory.openSession();
		session.beginTransaction();
		
	}
	public void commitTransaction() {
		session.getTransaction().commit();
		
	}
	public void closeSession() {
		// TODO Auto-generated method stub
		session.close();
	}
	
	
}
