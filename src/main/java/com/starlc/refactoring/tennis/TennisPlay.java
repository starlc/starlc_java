/**
 * 
 */
package com.starlc.refactoring.tennis;

/**
 * @author starlc
 *
 */
public class TennisPlay {
	private int score;
	
	private String name;

	public TennisPlay(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void winPoint(){
		this.score++;
	}
	
}
