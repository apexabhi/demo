package com.nagarro.service;

import java.util.Comparator;

import com.nagarro.dto.Tshirt;

public class TshirtComparatorService {
	public Comparator<Tshirt> compareByPrice(){
		return new Comparator<Tshirt>() {
			public int compare(Tshirt t1, Tshirt t2) {
				return Double.compare(t1.getPrice(), t2.getPrice());
			}
		};
	}
	public Comparator<Tshirt> compareByRating(){
		return new Comparator<Tshirt>() {
			public int compare(Tshirt t1, Tshirt t2) {
				return Double.compare(t1.getRating(), t2.getRating());
			}
		};
	}
	public Comparator<Tshirt> compareByBoth(){
		return new Comparator<Tshirt>() {
			public int compare(Tshirt t1, Tshirt t2) {
				 if ((t1.getPrice()==t2.getPrice()) && (t1.getRating()==t2.getRating()))
			            return 0;
			        else if ((t1.getPrice()>t2.getPrice()) && (t1.getRating()>t2.getRating()))
			            return 1;
			        else
			            return -1;
			}
		};
	}
}
