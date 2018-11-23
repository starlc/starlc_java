/**
 *
 */
package com.starlc.designmode.simplefactory;

/**
 * 简单工厂模式 实现一个简单的计算器
 * 测试类
 * @author liucheng2
 *
 */
public class CalController {
	public static void main(String[] args) {
		Operation operation = OperationFactory.createOperation("+");
		System.out.println(operation.getResult(1, 2));
	}
}
