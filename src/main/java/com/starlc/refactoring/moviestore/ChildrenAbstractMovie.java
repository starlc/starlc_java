package com.starlc.refactoring.moviestore;

/**
 * 电影类
 * 
 * @author starlc
 *
 */
public class ChildrenAbstractMovie extends AbstractMovie {

	public ChildrenAbstractMovie(String title) {
		super(title);
	}

	@Override
	public boolean isNewRelease() {
		return false;
	}

	@Override
	public Rental rental(int days) {
		return new ChildrenRental(this, days);
	}
}
