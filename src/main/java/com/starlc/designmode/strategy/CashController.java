/**
 *
 */
package com.starlc.designmode.strategy;


/**
 * 策略模式 测试类
 * @author liucheng2
 *
 */
public class CashController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Commodity commodity = new Commodity("白菜", 18.00);
		int count = 10;
		test(commodity, count, "八折");
	}


	/**
	 * 客户端收费代码
	 * @param commodity
	 * @param type
	 */
	public static void test(Commodity commodity,int nums,String type){
		CashContext cashContext = new CashContext(type);
		double money = cashContext.getResultMoney(commodity.getPrice()*nums);
		System.out.println(commodity.getName()+"花费："+money);
	}
}
