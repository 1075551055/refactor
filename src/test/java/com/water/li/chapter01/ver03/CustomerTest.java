package com.water.li.chapter01.ver03;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testChilrenMovie() {
        Customer customer = new Customer("customer1");
        Movie childrenMovie = new Movie("儿童类电影", Movie.CHILDRENS);
        Rental rental = new Rental(childrenMovie, 2);
        customer.addRental(rental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

    @Test
    public void testRecularMovie() {
        Customer customer = new Customer("customer1");
        Movie regularMovie = new Movie("常规类电影", Movie.REGULAR);
        Rental rental = new Rental(regularMovie, 2);
        customer.addRental(rental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

    @Test
    public void testNewMovie() {
        Customer customer = new Customer("customer1");
        Movie newMovie = new Movie("新类型电影", Movie.NEW_RELEASE);
        Rental rental = new Rental(newMovie, 2);
        customer.addRental(rental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + newMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

    @Test
    public void testChildrenAndRecularMovie() {
        Customer customer = new Customer("customer1");
        Movie childrenMovie = new Movie("儿童类电影", Movie.CHILDRENS);
        Rental childrenRental = new Rental(childrenMovie, 2);
        customer.addRental(childrenRental);
        Movie regularMovie = new Movie("常规类电影", Movie.REGULAR);
        Rental recularRental = new Rental(regularMovie, 2);
        customer.addRental(recularRental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 3.5\n" +
                "You earned 2 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

    @Test
    public void testChildrenAndNewMovie() {
        Customer customer = new Customer("customer1");
        Movie childrenMovie = new Movie("儿童类电影", Movie.CHILDRENS);
        Rental childrenRental = new Rental(childrenMovie, 2);
        customer.addRental(childrenRental);
        Movie newMovie = new Movie("新类型电影", Movie.NEW_RELEASE);
        Rental newRental = new Rental(newMovie, 2);
        customer.addRental(newRental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "\t" + newMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

    @Test
    public void testRegularAndNewMovie() {
        Customer customer = new Customer("customer1");
        Movie regularMovie = new Movie("常规类电影", Movie.REGULAR);
        Rental regularRental = new Rental(regularMovie, 2);
        customer.addRental(regularRental);
        Movie newMovie = new Movie("新类型电影", Movie.NEW_RELEASE);
        Rental newRental = new Rental(newMovie, 2);
        customer.addRental(newRental);

        String statement = customer.statement();

        String expectedResult = "Rental Record for " + customer.getName() + "\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "\t" + newMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 3 frequent renter points";
        Assert.assertEquals(expectedResult, statement);
    }

}
