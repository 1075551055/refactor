package com.water.li.chapter01.ver05;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR: // 普通片
                _price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE: // 新片
                _price = new NewPrice();
                break;
            case Movie.CHILDRENS: // 儿童。
                _price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public String getTitle() {
        return _title;
    }

    // 都是在操控movie的数据去获取amount，所以这个函数要移到movie类中，而不是rental类
    public double getAmount(int daysRented) {
        return _price.getAmount(daysRented);
    }

    // 都是在操控movie的数据去获取amount，所以这个函数要移到movie类中，而不是rental类
    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);

    }
}
