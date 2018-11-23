/**
 *
 */
package com.starlc.designmode.strategy;

/**
 * 原价
 * @author liucheng2
 *
 */
public class OriginalPriceCash implements CashSuper {

	/* (non-Javadoc)
	 * @see com.starlc.designmode.strategy.CashSuper#acceptCash()
	 */
	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money;
	}

}
