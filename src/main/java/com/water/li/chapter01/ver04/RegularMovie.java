package com.water.li.chapter01.ver04;

public class RegularMovie extends Movie {
    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    protected double getAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

}
