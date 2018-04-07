/**
 * 
 */
package starlc_java.abstractclass;

import org.junit.Test;

/**
 * @author liucheng2
 *
 */
public class TestPerson {
	
	@Test
	public void test() {
		AbstractPerson.eat();
		
		AbstractPerson person = new ConcreatePerson("уехЩ");
		person.show();
	}
}
