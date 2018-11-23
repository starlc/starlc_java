/**
 *
 */
package com.starlc.designmode.builder4;

/**
 * @author liucheng2
 *
 */
public class TestMainPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = new PersonBuilder()
				.firstName("ricky")
				.lastName("fung")
				.age(27)
				.street("建国路")
				.district("朝阳")
				.city("北京市")
				.province("北京")
				.isFemale(false)
				.isEmployed(true)
				.create();

		System.out.println(person);
	}

}
