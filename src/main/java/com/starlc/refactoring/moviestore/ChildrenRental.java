package com.starlc.refactoring.moviestore;

public class ChildrenRental extends Rental {

	public ChildrenRental(AbstractMovie abstractMovie, int daysRented) {
		super(abstractMovie, daysRented);
	}
	
	@Override
	public double account() {
		thisAmount += 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

}
