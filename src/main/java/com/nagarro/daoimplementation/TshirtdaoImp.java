package com.nagarro.daoimplementation;

import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.DbConfig;
import com.nagarro.dao.Tshirtdao;
import com.nagarro.dto.Tshirt;

public class TshirtdaoImp implements Tshirtdao{
	@Autowired
	private DbConfig dbc;
	public Tshirt readInput(String str) {
		StringTokenizer st=new StringTokenizer(str,"|");
		String id=st.nextToken();
		id=id.substring(1);
		String name=st.nextToken();
		String color=st.nextToken();
		String g=st.nextToken();
		String s=st.nextToken();
		Double price=Double.parseDouble(st.nextToken());
		Double rating=Double.parseDouble(st.nextToken());
		String av=st.nextToken();
		av=av.substring(0, av.length()-1);
		Tshirt t=new Tshirt(id,name,color,g,s,price,rating,av);	
		return t;
	}
	public void storeData(Tshirt t) {
		dbc.beginSession();
		dbc.getSession().saveOrUpdate(t);
		dbc.commitTransaction();
		dbc.closeSession();
	}
	public List<Tshirt> fetchData(String color,String size,String gender,String pref){
		dbc.beginSession();
		Query q = dbc.getSession().createQuery("from Tshirt t where (t.color=:color and t.size=:size and t.gender in(:gender1,:gender2))");
		q.setParameter("color", color);
		q.setParameter("size", size);
		q.setParameter("gender1", gender);
		q.setParameter("gender2", "U");
		List<Tshirt> t=q.list();
		dbc.commitTransaction();
		dbc.closeSession();
		return t;
	}
}
