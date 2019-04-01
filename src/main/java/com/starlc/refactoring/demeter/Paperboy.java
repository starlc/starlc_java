package com.starlc.refactoring.demeter;

/**
 * 收银员
 * @author starlc
 *
 */
public class Paperboy {
    private Customer myCustomer;
    public void pay(float payment) {
    	//顾客付款 成功带走商品 失败 byebye
    	myCustomer.payMoney(payment);
    }
    
    public static void main(String[] args) {
    	Customer customer = new Customer().createCustomer("张", "三").keepMoney(100);
    	customer.payMoney(88);
	}
}
