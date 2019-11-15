package com.water.li.chapter01.ver03;

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
        int priceCode = this.getMovie().getPriceCode();
        double amount = 0;
        switch (priceCode) { // 取得影片出租价格
            case Movie.REGULAR: // 普通片
                amount += 2;
                if (this.getDaysRented() > 2)
                    amount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE: // 新片
                amount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS: // 儿童。
                amount += 1.5;
                if (this.getDaysRented() > 3)
                    amount += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
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
