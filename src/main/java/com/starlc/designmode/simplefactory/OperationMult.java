/**
 *
 */
package com.starlc.designmode.simplefactory;

/**
 * 乘法运算
 * @author liucheng2
 *
 */
public class OperationMult implements Operation {

	@Override
	public double getResult(double dNumber1, double dNumber2) {
		// TODO Auto-generated method stub
		return dNumber1*dNumber2;
	}

}
