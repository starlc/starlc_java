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
		IComponent component = new Person("����");
		Tshit shit = new Tshit(component);
		Suit suit = new Suit(shit);
		
		suit.cross();
//		����׼������
//		����T��
//		������װ
	}

}
