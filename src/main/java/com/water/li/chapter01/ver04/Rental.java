package com.water.li.chapter01.ver04;

public class Rental {
    private Movie _movie; // 影片
    private int _daysRented; // 租期

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getAmount() {
        return this.getMovie().getAmount(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        // add frequent renter points （累计常客积点。
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && this.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
