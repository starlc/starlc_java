/**
 * 
 */
package com.starlc.designmode.strategy;

/**
 * �շ� ����ģʽ�ͼ򵥹���ģʽ���
 * @author liucheng2
 *
 */
public class CashContext {
	private CashSuper cashSuper;
	
	/**
	 * �򵥹���ģʽ
	 * ע�� �������������
	 * @param type
	 */
	public CashContext(String type) {
		switch (type) {
		case "����":
			cashSuper = new DiscountCash();
			break;
		case "����":
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
