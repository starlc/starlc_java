/**
 * 
 */
package com.starlc.designmode.proxy.simple;


/**
 * @author liucheng2
 *
 */
public class Proxyer implements IAct {
	private Singer singer;
	
	public Proxyer(Singer singer) {
		this.singer = singer;
	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.proxy.simple.IAct#sing()
	 */
	@Override
	public void sing() {
		singer.sing();
	}

	/* (non-Javadoc)
	 * @see com.starlc.designmode.proxy.simple.IAct#dance()
	 */
	@Override
	public void dance() {
		// TODO Auto-generated method stub
		singer.dance();
	}

}
