/**
 * 
 */
package com.starlc.designmode.decker;

/**
 * @author liucheng2
 *
 */
public class Decker implements IComponent {
	
	private IComponent component;
	
	public Decker(IComponent component) {
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.decker.IComponent#cross()
	 */
	@Override
	public void cross() {
		// TODO Auto-generated method stub
		component.cross();
	}

}
