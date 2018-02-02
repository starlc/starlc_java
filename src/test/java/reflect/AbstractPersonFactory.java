/**
 * 
 */
package reflect;

/**
 * @author liucheng2
 *
 */
public abstract class AbstractPersonFactory {
	
	private static IPerson person;
	
	public static IPerson getPerson() {
		return ObjectUtil.createBean(person, Person.class);
	}
	
	 private static class ObjectUtil {
	        
	        public static <T extends M, M> M createBean(M facade, Class<T> clazz) {
	            if (facade == null) {
	                try {
	                    facade = clazz.newInstance();
	                } catch (InstantiationException e) {
	                    e.printStackTrace();
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                }
	            }
	            return facade;
	        }
	    }
}
