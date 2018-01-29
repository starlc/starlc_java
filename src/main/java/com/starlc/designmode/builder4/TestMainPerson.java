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
        .street("����·")
        .district("����")
        .city("������")
        .province("����")
        .isFemale(false)
        .isEmployed(true)
        .create();

		System.out.println(person);
	}

}
