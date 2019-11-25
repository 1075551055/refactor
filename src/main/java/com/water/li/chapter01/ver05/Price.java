package com.water.li.chapter01.ver05;

public abstract class Price {
    abstract int getPriceCode();

    public abstract double getAmount(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
