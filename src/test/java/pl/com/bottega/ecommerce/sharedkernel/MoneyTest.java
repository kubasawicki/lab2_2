package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    Money pln1 = new Money(10, "PLN");
    Money pln2 = new Money(25, "PLN");
    Money pln3 = new Money(25, "PLN");
    Money usd1 = new Money(50, "USD");
    Money usd2 = new Money(0, "USD");

    @Test public void multiplierExpectedValueTest() {
        Money expected = new Money(100, "PLN");
        assertThat(pln1.multiplyBy(10), is(equalTo(expected)));

    }

    @Test public void addingValuesTest() {
        Money expected = new Money(35, "PLN");
        assertThat(pln1.add(pln2), is(equalTo(expected)));
    }

    @Test public void subtractValuesTest() {
        Money expected = new Money(15, "PLN");
        assertThat(pln2.subtract(pln1), is(equalTo(expected)));
    }

    @Test public void greaterThanValueTest() {
        assertThat(pln2.greaterThan(pln1), is(true));
    }

    @Test public void lesserThanValueTest() {
        assertThat(pln1.lessThan(pln2), is(true));
    }

    @Test public void lessOrEqualTest() {
        assertThat(pln2.lessOrEquals(pln3), is(true));
        assertThat(pln1.lessOrEquals(pln2), is(true));
    }
}
