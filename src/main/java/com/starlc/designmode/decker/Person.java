/**
 * 
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class Person implements IComponent {
	//����
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �Զ��幹�췽��
	 * @param name
	 */
	public Person(String name){
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.starlc.designmode.decker.IComponent#cross()
	 */
	@Override
	public void cross() {
		System.out.println(name+"׼������");
	}
	
}
