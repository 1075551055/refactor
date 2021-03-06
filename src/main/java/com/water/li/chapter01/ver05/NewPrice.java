package com.water.li.chapter01.ver05;

public class NewPrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
