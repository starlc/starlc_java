/**
 * 
 */
package com.starlc.refactoring.moviestore;

/**
 * @author starlc
 *
 */
public class RegularRental extends Rental {

	public RegularRental(AbstractMovie abstractMovie, int daysRented) {
		super(abstractMovie, daysRented);
	}
	@Override
	public double account() {
		 thisAmount += 2;
         if (daysRented > 2)
             thisAmount +=( daysRented - 2) * 1.5;
		return thisAmount;
	}
	
}
