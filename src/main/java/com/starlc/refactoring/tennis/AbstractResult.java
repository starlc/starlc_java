/**
 * 
 */
package com.starlc.refactoring.tennis;

/**
 * @author starlc
 *
 */
public abstract class AbstractResult implements Result {
	protected int score1;
	protected int score2;
	
	
	public AbstractResult(int score1, int score2) {
		super();
		this.score1 = score1;
		this.score2 = score2;
	}


	/* (non-Javadoc)
	 * @see com.starlc.refactoring.tennis.Result#getResult(int, int)
	 */
	@Override
	public abstract String getResult();

}
