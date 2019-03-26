/**
 * 
 */
package com.starlc.thread2.runner;

/**
 * @author starlc
 *
 */
public abstract class AbstractJudger implements Judger {

	/* (non-Javadoc)
	 * @see com.starlc.thread2.runner.Judger#judge()
	 */
	@Override
	public void judge() {
		try {
			Thread.sleep(5000);
			System.out.println("开跑令响");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
