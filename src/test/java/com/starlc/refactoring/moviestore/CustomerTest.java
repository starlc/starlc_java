package com.starlc.refactoring.moviestore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试驱动的存在 不仅仅是保证代码的可用性和稳定性
 * 更为我们后续进行重构和优化提供了保障
 * @author starlc
 *
 */
public class CustomerTest {
	public static final String REGULAR_MOVIE_NAME = "Brave Heart";
    public static final String NEW_RELEASE_MOVIE_NAME = "Iron Man";
    public static final String CUSOMTER_NAME = "zhangyi";
    public static final String CHILDREN_MOVIE = "Kongfu Panda";
    private AbstractMovie regularAbstractMovie;
    private Customer customer;
    private AbstractMovie newRleaseAbstractMovie;
    private AbstractMovie childrenAbstractMovie;

    @Before
    public void setUp() throws Exception {
        regularAbstractMovie = new RegularAbstractMovie(REGULAR_MOVIE_NAME);
        customer = new Customer(CUSOMTER_NAME);
        newRleaseAbstractMovie = new NewReleaseAbstractMovie(NEW_RELEASE_MOVIE_NAME);
        childrenAbstractMovie = new ChildrenAbstractMovie(CHILDREN_MOVIE);
    }

    @Test
    public void should_statement_for_regular_movie_and_rental_days_less_than_or_equal_to_2() {
        Rental rental = regularAbstractMovie.rental(2);//new RegularRental(regularAbstractMovie, 2);
        Customer customer = new Customer(CUSOMTER_NAME);
        customer.addRental(rental);

        double expectedTotalAmount = 2.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, REGULAR_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_regular_movie_and_rental_days_greater_than_2() {
        Rental rental = regularAbstractMovie.rental(3);//new RegularRental(regularAbstractMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 3.5;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, REGULAR_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_new_release_movie_and_rental_days_less_than_or_equal_to_1() {
        Rental rental = newRleaseAbstractMovie.rental(1);//new NewReleaseRental(newRleaseAbstractMovie, 1);
        customer.addRental(rental);

        double expectedTotalAmount = 3.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, NEW_RELEASE_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_new_release_movie_and_rental_days_greater_than_1() {
        Rental rental = newRleaseAbstractMovie.rental(3);//new NewReleaseRental(newRleaseAbstractMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 9.0;
        int expectedFrequentRenterPoints = 2;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, NEW_RELEASE_MOVIE_NAME, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_children_movie_and_rental_days_less_than_or_equal_to_3() {
        Rental rental = childrenAbstractMovie.rental(3);//new ChildrenRental(childrenAbstractMovie, 3);
        customer.addRental(rental);

        double expectedTotalAmount = 1.5;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, CHILDREN_MOVIE, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_children_movie_and_rental_days_greater_than_3() {
        Rental rental = childrenAbstractMovie.rental(4);//new ChildrenRental(childrenAbstractMovie, 4);
        customer.addRental(rental);

        double expectedTotalAmount = 3.0;
        int expectedFrequentRenterPoints = 1;
        assertThat(customer.statement(), is(result(CUSOMTER_NAME, CHILDREN_MOVIE, expectedTotalAmount, expectedFrequentRenterPoints)));
    }

    @Test
    public void should_statement_for_all_kinds_of_movie() {
        Rental rentalForRegularMovie = regularAbstractMovie.rental(3);// new RegularRental(regularAbstractMovie, 3);
        Rental rentalForNewReleaseMovie = newRleaseAbstractMovie.rental(3);//new NewReleaseRental(newRleaseAbstractMovie, 3);
        Rental rentalForChildrenMovie = childrenAbstractMovie.rental(3);//new ChildrenRental(childrenAbstractMovie, 3);
        customer.addRental(rentalForRegularMovie);
        customer.addRental(rentalForNewReleaseMovie);
        customer.addRental(rentalForChildrenMovie);

        assertThat(customer.statement(), is("Rental Record for zhangyi\n\t" +
                "Brave Heart\t3.5\n" +
                "\tIron Man\t9.0\n" +
                "\tKongfu Panda\t1.5\n" +
                "Amount owed is 14.0\n" +
                "You earned 4 frequent renter points"));

    }

    private String result(String customerName, String movieName, double totalAmout, int frequentRenterPoints) {
        return String.format("Rental Record for %s\n\t" +
                "%s\t%s\nAmount owed is %s\n" +
                "You earned %d frequent renter points", customerName, movieName, totalAmout, totalAmout, frequentRenterPoints);
    }
}
