/**
 * 
 */
package com.starlc.designmode.proxy.simple;

/**
 * @author liucheng2
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proxyer proxyer = new Proxyer(new Singer("¡ı»Ù”¢"));
		proxyer.sing();
		proxyer.dance();
	}

}
