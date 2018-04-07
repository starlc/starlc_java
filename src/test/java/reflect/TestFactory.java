package reflect;

import org.junit.Test;

public class TestFactory {
	
	@Test
	public void testPerson(){
		IPerson person = AbstractPersonFactory.getPerson();
		person.eat();
	}
}
