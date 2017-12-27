/**
 * 
 */
package com.starlc.designmode.strategy;

/**
 * @author liucheng2
 *
 */
public class ReduceCash implements CashSuper {
	private static double TOTAL = 500d;
	
	private static double SUB  =200d;

	/* (non-Javadoc)
	 * @see com.starlc.designmode.strategy.CashSuper#acceptCash(double)
	 */
	@Override
	public double acceptCash(double money) {
		if(money>TOTAL){
			return money-SUB;
		}
		return money;
	}

}
