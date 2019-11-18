package com.water.li.chapter01.ver04;

public class Movie {
    private String _title;

    public Movie(String title) {
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    protected double getAmount(int daysRented) {
        return 0;
    }
}
