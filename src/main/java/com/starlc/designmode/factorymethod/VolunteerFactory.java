/**
 * 
 */
package com.starlc.designmode.factorymethod;

/**
 * @author liucheng2
 *
 */
public class VolunteerFactory implements IFactory {

	/* (non-Javadoc)
	 * @see com.starlc.designmode.factorymethod.IFactory#createLeifeng()
	 */
	@Override
	public Leifeng createLeifeng() {
		// TODO Auto-generated method stub
		return new Volunteer();
	}

}
