/**
 * 
 */
package com.starlc.designmode.simplefactory;

/**
 * 运算工厂
 * @author liucheng2
 *
 */
public class OperationFactory {
	/**
	 * 创建运算法则
	 * @param operate
	 * @return
	 */
	public static Operation createOperation(String operate){
		Operation operation = null;
		switch (operate) {
		case "+":
			operation = new OperationAdd();
			break;
		case "-":
			operation = new OperationSub();
			break;
		case "*":
			operation = new OperationMult();
			break;
		case "/":
			operation = new OperationDevide();
			break;
		}
		return operation;
	}
}
