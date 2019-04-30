package com.starlc.refactoring.moviestore;

public class NewReleaseRental extends Rental {

	public NewReleaseRental(AbstractMovie abstractMovie, int daysRented) {
		super(abstractMovie, daysRented);
	}
	
	@Override
	public double account() {
		return thisAmount += daysRented * 3;
	}
}
