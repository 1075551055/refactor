package com.water.li.chapter01.ver05;

public class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}
