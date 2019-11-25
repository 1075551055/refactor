package com.water.li.chapter01.ver02;

import java.util.Enumeration;
import java.util.Vector;

// tips: 个人总结代码最低要求得符合以下三原则：1. 函数是否只做一件事；2.是否有重复代码；3.函数或者属性是否属于当前类（职责划分）
// 该版本所做内容：从最上层去重构，让同一层次的函数只做一件事
public class Customer {
    private String _name; // 姓名
    private Vector _rentals = new Vector(); // 租借记

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental eachRental = (Rental) rentals.nextElement(); // 取得一笔租借记。
            // determine amounts for eachRental line
            int priceCode = eachRental.getMovie().getPriceCode();
            double thisAmount = getThisAmount(eachRental);
            frequentRenterPoints += getFrequentRenterPoints(eachRental, priceCode);
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + eachRental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        return result + getFooterPrintedLines(totalAmount, frequentRenterPoints);
    }

    private double getThisAmount(Rental eachRental) {
        double thisAmount = 0;
        switch (eachRental.getMovie().getPriceCode()) { // 取得影片出租价格
            case Movie.REGULAR: // 普通片
                thisAmount += 2;
                if (eachRental.getDaysRented() > 2)
                    thisAmount += (eachRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE: // 新片
                thisAmount += eachRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS: // 儿童。
                thisAmount += 1.5;
                if (eachRental.getDaysRented() > 3)
                    thisAmount += (eachRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    private int getFrequentRenterPoints(Rental eachRental, int priceCode) {
        int frequentRenterPoints = 0;
        // add frequent renter points （累计常客积点。
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((priceCode == Movie.NEW_RELEASE)
                && eachRental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private String getFooterPrintedLines(double totalAmount, int frequentRenterPoints) {
        // add footer lines（结尾打印）
        String footerLines = ("Amount owed is " + String.valueOf(totalAmount) + "\n");
        footerLines += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return footerLines;
    }
}
