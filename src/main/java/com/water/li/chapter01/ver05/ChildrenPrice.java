package com.water.li.chapter01.ver05;

public class ChildrenPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    public double getAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}
