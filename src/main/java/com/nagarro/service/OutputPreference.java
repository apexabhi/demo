package com.nagarro.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dto.Tshirt;

public class OutputPreference {
	@Autowired
	private TshirtComparatorService tshirtComparator;
	public void sortProducts(List<Tshirt> t, String pref) {
		Comparator<Tshirt> comparator;

		if (pref.equalsIgnoreCase("Price")) {
			comparator = tshirtComparator.compareByPrice();
			Collections.sort(t, comparator);
		} 
		else if(pref.equalsIgnoreCase("Rating")) {
			comparator = tshirtComparator.compareByRating();
			Collections.sort(t, comparator);
		}
		else if(pref.equalsIgnoreCase("Both")) {
			comparator = tshirtComparator.compareByBoth();
			Collections.sort(t, comparator);
		}
	}
}
