package com.starlc.refactoring.demeter;

/**
 * 钱包类  具有保存钱的功能
 * @author starlc
 *
 */
public class Wallet {
	
    private float value;

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}
	/**
	 * 取钱
	 * @param money
	 */
	public void drawMoney(float money){
		this.value -= money;
	}
}
