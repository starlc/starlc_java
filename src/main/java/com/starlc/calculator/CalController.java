/**
 *
 */
package com.starlc.calculator;

/**
 * 计算中心
 * @author liucheng2
 *
 */
public class CalController {
	public static String getResult(double strNum1,double strNum2,String operator ){
		double result = 0l;
		switch (operator) {
			case "+":
				result = strNum1+strNum2;
				break;
			case "-":
				result = strNum1-strNum2;
				break;
			case "*":
				result = strNum1*strNum2;
				break;
			case "/":
				result = strNum1/strNum2;
				break;

			default:
				result = 0;
				break;
		}
		return String.valueOf(result);
	}
}
