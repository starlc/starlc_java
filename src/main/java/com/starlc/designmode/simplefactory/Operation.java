/**
 *
 */
package com.starlc.designmode.simplefactory;

/**
 * 运算方式接口
 * @author liucheng2
 *
 */
public interface Operation {
	/**
	 * 运算接口
	 * @param dNumber1
	 * @param dNumber2
	 * @return
	 */
	public double getResult(double dNumber1,double dNumber2);
}
