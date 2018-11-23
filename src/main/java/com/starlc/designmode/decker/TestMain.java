/**
 *
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IComponent component = new Person("张三");
		Tshit shit = new Tshit(component);
		Suit suit = new Suit(shit);

		suit.cross();
//		张三准备穿衣
//		穿上T恤
//		穿上西装
	}

}
