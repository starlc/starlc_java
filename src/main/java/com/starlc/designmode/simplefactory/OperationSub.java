/**
 *
 */
package com.starlc.designmode.simplefactory;

/**
 * 减法运算
 * @author liucheng2
 *
 */
public class OperationSub implements Operation {

	/* (non-Javadoc)
	 * @see com.starlc.designmode.simplefactory.Operation#getResult(double, double)
	 */
	@Override
	public double getResult(double dNumber1, double dNumber2) {
		// TODO Auto-generated method stub
		return dNumber1-dNumber2;
	}

}
