package com.water.li.chapter01.ver04;

import java.util.Enumeration;
import java.util.Vector;

// tips: 个人总结代码最低要求得符合以下三原则：1. 函数是否只做一件事；2.是否有重复代码；3.函数或者属性是否属于当前类（职责划分）
// 该版本所做内容：运用设计模式重构
// 重构过程的思考：1.程序是否能应对未来的各种变化（扩展性）？把相同的部分留下，变化部分抽取封装，这样可以应对各种未来可能发生的改变（可以参考head first设计模式），例如打印功能
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
        String headerLines = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental eachRental = (Rental) rentals.nextElement();
            // 因为getAmount和getFrequentRenterPoints函数都是从Rental对象获取相关的信息然后进行计算，所以是属于Rental对象的职责
            double thisAmount = eachRental.getAmount();
            frequentRenterPoints += eachRental.getFrequentRenterPoints();
            totalAmount += thisAmount;
            headerLines += "\t" + eachRental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
        }
        return getPrintedResult(totalAmount, frequentRenterPoints, headerLines);
    }

    private String getPrintedResult(double totalAmount, int frequentRenterPoints, String headerLines) {
        // add footer lines（结尾打印）
        String footerLines = ("Amount owed is " + String.valueOf(totalAmount) + "\n");
        footerLines += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return headerLines + footerLines;
    }

}
