package com.starlc.refactoring.moviestore;

/**
 * 电影类
 * 
 * @author starlc
 *
 */
public class RegularAbstractMovie extends AbstractMovie {

	public RegularAbstractMovie(String title) {
		super(title);
	}

	public boolean isNewRelease() {
		return false;
	}

	@Override
	public Rental rental(int days) {
		return new RegularRental(this, days);
	}
}
