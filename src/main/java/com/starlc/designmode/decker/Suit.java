/**
 * 
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class Suit extends Decker {

	public Suit(IComponent component) {
		super(component);
	}
	
	@Override
	public void cross() {
		super.cross();
		System.out.println("´©ÉÏÎ÷×°");
	}
}
