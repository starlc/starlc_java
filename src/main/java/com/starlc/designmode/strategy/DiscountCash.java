/**
 *
 */
package com.starlc.designmode.strategy;

/**
 * 折扣型收费
 * @author liucheng2
 *
 */
public class DiscountCash implements CashSuper {

	/* (non-Javadoc)
	 * @see com.starlc.designmode.strategy.CashSuper#acceptCash()
	 */
	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money*0.8;
	}

}
