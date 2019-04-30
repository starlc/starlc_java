package com.starlc.refactoring.moviestore;

/**
 * 电影类
 * @author starlc
 *
 */
public abstract class AbstractMovie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;//新发布
    public static final int CHILDREN = 2;

    protected String title;
    //protected int priceCode;

    public AbstractMovie(String title) {//, int priceCode
        this.title = title;
       // this.priceCode = priceCode;
    }

//    public int getPriceCode() {
//        return priceCode;
//    }
//
//    public void setPriceCode(int price) {
//        priceCode = price;
//    }

    public String getTitle() {
        return title;
    }
    
    public abstract boolean isNewRelease();
//    {
//    	return priceCode == AbstractMovie.NEW_RELEASE;
//    }
    
    // add 每一本电影都应该知道自己的rental 这是一个行为
    public abstract Rental rental(int days);
}
