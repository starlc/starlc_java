/**
 * 
 */
package com.starlc.designmode.factorymethod;

/**
 * @author liucheng2
 *
 */
public class Volunteer implements Leifeng {
	
	public Volunteer() {
		System.out.println("־Ը��");
	}
	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#sweep()
	 */
	@Override
	public void sweep() {
		System.out.println("��ɨ");

	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#wash()
	 */
	@Override
	public void wash() {
		// TODO Auto-generated method stub
		System.out.println("ϴˢ");
	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#buyRice()
	 */
	@Override
	public void buyRice() {
		// TODO Auto-generated method stub
		System.out.println("�����");
	}

}
