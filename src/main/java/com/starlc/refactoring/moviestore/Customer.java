package com.starlc.refactoring.moviestore;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾客类
 * 
 * @author starlc
 *
 */
class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	//根据预留集合的原则 这个还要抽出来的。

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		//这一段可以抽取出来 一个单独的函数
		for (Rental each : rentals) {
			double thisAmount = 0;
			thisAmount += each.account();
			// determine amounts for each line
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (each.isBonus())
				frequentRenterPoints++;
			// show figures
			result += each.statement();
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
}
