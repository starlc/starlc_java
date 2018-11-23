/**
 *
 */
package com.starlc.designmode.factorymethod;

/**
 * @author liucheng2
 *
 */
public class UnderGraduate implements Leifeng {
	public UnderGraduate() {
		System.out.println("大学生");
	}
	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#sweep()
	 */
	@Override
	public void sweep() {
		System.out.println("打扫");

	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#wash()
	 */
	@Override
	public void wash() {
		// TODO Auto-generated method stub
		System.out.println("洗刷");
	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.Leifeng#buyRice()
	 */
	@Override
	public void buyRice() {
		// TODO Auto-generated method stub
		System.out.println("买大米");
	}

}
