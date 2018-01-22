/**
 * 
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class Tshit extends Decker {

	public Tshit(IComponent component) {
		super(component);
	}
	
	@Override
	public void cross() {
		super.cross();
		System.out.println("´©ÉÏTÐô");
	}

}
