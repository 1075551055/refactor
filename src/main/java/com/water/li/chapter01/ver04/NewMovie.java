package com.water.li.chapter01.ver04;

public class NewMovie extends Movie {
    public NewMovie(String title) {
        super(title);
    }

    @Override
    protected double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
