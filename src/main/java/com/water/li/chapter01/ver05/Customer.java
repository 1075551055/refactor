package com.water.li.chapter01.ver05;

import java.util.Enumeration;
import java.util.Vector;

// tips: 个人总结代码最低要求得符合以下三原则：1. 函数是否只做一件事；2.是否有重复代码；3.函数或者属性是否属于当前类（职责划分）
// 该版本所做内容：对版本四的设计模式的重构
// 重构过程的思考：1. 现实生活中，一个影片（对象）所属的电影类型是有可能改变的，就是说可以被分类到其他电影类别，并不是说一出生就决定了它所属类型，而使用多态
// 造成的后果就是一个对象（影片）一旦被new出来了，它的类型就是无法改变的了，这有点不符合实际情况 2.所以结论是应该使用策略模式抽象不同影片类型的计费方式
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

    // 把所有该变化的点都抽取成方法了，留下了共同部分的功能，未来如何想新增一个htmlStatement的函数也变得简单了
    public String statement() {
        Enumeration rentals = _rentals.elements();
        String headerLines = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental eachRental = (Rental) rentals.nextElement();
            // 因为getAmount和getFrequentRenterPoints函数都是从Rental对象获取相关的信息然后进行计算，所以是属于Rental对象的职责
            headerLines += "\t" + eachRental.getMovie().getTitle() + "\t"
                    + String.valueOf(eachRental.getAmount()) + "\n";
        }
        // add footer lines（结尾打印）
        String footerLines = ("Amount owed is " + String.valueOf(getTotalCharge()) + "\n");
        footerLines += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return headerLines + footerLines;
    }

    // 译注：此即所谓query method。这样可以减少局部变量的使用，局部变量会让整个函数变长，而且容易导致各种变量之间的依赖关系
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    // 译注：此即所谓query method
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getAmount();
        }
        return result;
    }

}
