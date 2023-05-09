package com.nagarro.dao;

import java.util.List;

import com.nagarro.dto.Tshirt;

public interface Tshirtdao {
	public Tshirt readInput(String str);
	public void storeData(Tshirt t);
	public List<Tshirt> fetchData(String color, String size, String gender, String pref);
}
