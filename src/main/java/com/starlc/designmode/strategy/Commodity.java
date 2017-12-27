/**
 * 
 */
package com.starlc.designmode.strategy;

/**
 * …Ã∆∑
 * @author liucheng2
 *
 */
public class Commodity {
	private String name;
	private double price;
	
	public Commodity() {
		
	}
	
	/**
	 * @param name
	 * @param price
	 */
	public Commodity(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
