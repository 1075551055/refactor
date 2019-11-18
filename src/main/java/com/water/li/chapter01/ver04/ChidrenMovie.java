package com.water.li.chapter01.ver04;

public class ChidrenMovie extends Movie {
    public ChidrenMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    protected double getAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
