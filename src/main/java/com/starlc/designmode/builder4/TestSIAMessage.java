/**
 *
 */
package com.starlc.designmode.builder4;

/**
 * @author liucheng2
 *
 */
public class TestSIAMessage {
	public static void main(String[] args) {
		//1.
		SIAMessage message = new SIAMessage.Builder()
				.setBusinessCode("yrd")
				.setMessage("hello world")
				.setTimeout(1000)
				.build();

		System.out.println(message);

		//2.
		message = SIAMessage.custom()
				.setBusinessCode("yrd")
				.setMessage("hello world")
				.setTimeout(1000)
				.build();

		System.out.println(message);
	}
}
