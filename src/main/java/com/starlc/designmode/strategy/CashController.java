/**
 * 
 */
package com.starlc.designmode.strategy;

import com.starlc.designmode.simplefactory.Operation;
import com.starlc.designmode.simplefactory.OperationFactory;

/**
 * ����ģʽ ������
 * @author liucheng2
 *
 */
public class CashController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Commodity commodity = new Commodity("�ײ�", 18.00);
		int count = 10;
		test(commodity, count, "����");
	}
	
	
	/**
	 * �ͻ����շѴ���
	 * @param commodity
	 * @param type
	 */
	public static void test(Commodity commodity,int nums,String type){
		CashContext cashContext = new CashContext(type);
		double money = cashContext.getResultMoney(commodity.getPrice()*nums);
		System.out.println(commodity.getName()+"���ѣ�"+money);
	}
}
