/**
 * 
 */
package starlc_java.abstractclass;

import com.starlc.util.Console;

/**
 * @author liucheng2
 *
 */
public class ConcreatePerson extends AbstractPerson {
	
	public ConcreatePerson(String name) {
		super(name);
	}
	/* (non-Javadoc)
	 * @see starlc_java.abstractclass.AbstractPerson#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Console.log(name);
	}

}
