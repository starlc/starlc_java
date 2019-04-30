package com.starlc.refactoring.moviestore;

/**
 * 电影类
 * 
 * @author starlc
 *
 */
public class NewReleaseAbstractMovie extends AbstractMovie {

	public NewReleaseAbstractMovie(String title) {
		super(title);
	}

	public boolean isNewRelease() {
		return true;
	}

	@Override
	public Rental rental(int days) {
		return new NewReleaseRental(this, days);
	}
}
