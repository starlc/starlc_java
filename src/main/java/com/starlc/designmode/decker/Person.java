/**
 * 
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class Person implements IComponent {
	//名称
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 自定义构造方法
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
		System.out.println(name+"准备穿衣");
	}
	
}
