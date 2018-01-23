/**
 * 
 */
package com.starlc.designmode.factorymethod;

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
		IFactory factory = new UnderGraduateFactory();
		Leifeng leifeng = factory.createLeifeng();
		leifeng.sweep();
		leifeng.wash();
		
		Leifeng leifeng2 = factory.createLeifeng();
		leifeng2.sweep();
		leifeng2.wash();
		
		IFactory voFactory = new VolunteerFactory();
		Leifeng leifeng3 = voFactory.createLeifeng();
		leifeng3.sweep();
		leifeng3.wash();
	}

}
