/**
 * 
 */
package com.starlc.designmode.simplefactory;

/**
 * �򵥹���ģʽ ʵ��һ���򵥵ļ�����
 * ������
 * @author liucheng2
 *
 */
public class CalController {
	public static void main(String[] args) {
		Operation operation = OperationFactory.createOperation("+");
		System.out.println(operation.getResult(1, 2));
	}
}
