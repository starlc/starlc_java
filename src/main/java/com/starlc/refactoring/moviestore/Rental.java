package com.starlc.refactoring.moviestore;
/**
 * 租赁
 * @author starlc
 *
 */
public abstract class Rental {
	//此时可以修改为protected 让子类可以访问
    protected AbstractMovie abstractMovie;
    protected int daysRented;
    protected double thisAmount = 0;

    public Rental(AbstractMovie abstractMovie, int daysRented) {
        this.abstractMovie = abstractMovie;
        this.daysRented = daysRented;
    }

//    public int getDaysRented() {
//        return daysRented;
//    }
//
//    public AbstractMovie getMovie() {
//        return abstractMovie;
//    }
    
    /**
     * 当前电影租赁金额
     * 对thisAmount的处理写的有点死了，假如加入新的促销方式 改为抽象方法
     * @return
     */
    public abstract double account();
    /*{
        switch (abstractMovie.getPriceCode()) {
            case AbstractMovie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount +=( daysRented - 2) * 1.5;
                break;
            case AbstractMovie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case AbstractMovie.CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
       
    	return thisAmount;
    }*/
    
    /**
     * 是否有奖金 这里访问了movie的priceCode 并且进行了比较
     * @return
     */
    public boolean isBonus() {
		return abstractMovie.isNewRelease() && daysRented > 1;

	}
    
    /**
     * 状态信息
     * @return
     */
    public String statement(){
    	return "\t" + abstractMovie.getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
    }
}
