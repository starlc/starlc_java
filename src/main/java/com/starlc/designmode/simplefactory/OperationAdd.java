/**
 * 
 */
package com.starlc.designmode.simplefactory;

/**
 * @author liucheng2
 *
 */
public class OperationAdd implements Operation {

	/* (non-Javadoc)
	 * @see com.starlc.designmode.simplefactory.Operation#getResult(double, double)
	 */
	@Override
	public double getResult(double dNumber1, double dNumber2) {
		return dNumber1+dNumber2;
	}

}
