package com.starlc.refactoring.demeter;

/**
 * 顾客
 * @author starlc
 *
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Wallet myWallet;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the myWallet
	 */
	public Wallet getMyWallet() {
		return myWallet;
	}

	/**
	 * @param myWallet the myWallet to set
	 */
	public void setMyWallet(Wallet myWallet) {
		this.myWallet = myWallet;
	}

	public Customer createCustomer(String firstName,String lastName){
    	this.firstName = firstName;
    	this.lastName = lastName;
    	return this;
    }
    
    public Customer keepMoney(float money){
    	this.myWallet = new Wallet();
    	this.myWallet.setValue(money);
    	return this;
    }
    
    private boolean isMoneyEnough(float money){
    	return this.myWallet.getValue()-money>=0;
    }
    
    public boolean payMoney(float money){
    	if (isMoneyEnough(money)) {
    		System.out.println("金钱足够，付款");
    		this.myWallet.drawMoney(money);
    		return true;
		}
    	System.out.println("金钱不足，放弃购买");
    	return false;
    }
}
