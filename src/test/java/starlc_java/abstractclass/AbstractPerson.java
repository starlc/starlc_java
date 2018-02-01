/**
 * 
 */
package starlc_java.abstractclass;

import com.starlc.util.Console;

/**
 * @author liucheng2
 *
 */
public abstract class AbstractPerson {
	
	protected String name;
	
	public AbstractPerson(String name) {
		this.name = name;
	}
	public abstract void show();
	
	public static void eat(){
		Console.log("xxxxxxxx");
	}
}
