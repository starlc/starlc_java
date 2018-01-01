/**
 * 
 */
package com.starlc.designmode.strategy;

/**
 * 收费 策略模式和简单工厂模式结合
 * @author liucheng2
 *
 */
public class CashContext {
	private CashSuper cashSuper;
	
	/**
	 * 简单工厂模式
	 * 注意 这个参数的类型
	 * @param type
	 */
	public CashContext(String type) {
		switch (type) {
		case "八折":
			cashSuper = new DiscountCash();
			break;
		case "满减":
			cashSuper = new ReduceCash();
			break;
		default:
			cashSuper = new OriginalPriceCash();
		}
	}
	
	public double getResultMoney(double money){
		return cashSuper.acceptCash(money);
	}

	/**
	 * @return the cashSuper
	 */
	public CashSuper getCashSuper() {
		return cashSuper;
	}

	/**
	 * @param cashSuper the cashSuper to set
	 */
	public void setCashSuper(CashSuper cashSuper) {
		this.cashSuper = cashSuper;
	}
	
	
}
