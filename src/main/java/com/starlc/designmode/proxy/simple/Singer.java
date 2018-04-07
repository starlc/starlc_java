/**
 * 
 */
package com.starlc.designmode.proxy.simple;

/**
 * @author liucheng2
 *
 */
public class Singer implements IAct {
	private String name;
	
	public Singer(String name) {
		this.name = name;
	}
	@Override
	public void sing() {
		System.out.println(name+"³ª¸è");
		
	}

	@Override
	public void dance() {
		System.out.println(name+"ÌøÎè");
	}
	
}
