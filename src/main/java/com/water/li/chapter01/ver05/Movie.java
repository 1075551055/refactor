package com.water.li.chapter01.ver05;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    // 都是在操控movie的数据去获取amount，所以这个函数要移到movie类中，而不是rental类
    public double getAmount(int daysRented) {
        int priceCode = this.getPriceCode();
        double amount = 0;
        switch (priceCode) { // 取得影片出租价格
            case Movie.REGULAR: // 普通片
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE: // 新片
                amount += daysRented * 3;
                break;
            case Movie.CHILDRENS: // 儿童。
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }

    // 都是在操控movie的数据去获取amount，所以这个函数要移到movie类中，而不是rental类
    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
