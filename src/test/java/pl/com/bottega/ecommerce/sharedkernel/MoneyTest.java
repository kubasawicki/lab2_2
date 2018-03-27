package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoneyTest {
    private static Money testMoney;

    @BeforeClass
    public static void setUp() {
        testMoney = new Money(new BigDecimal(5), Currency.getInstance("EUR"));
    }

    @Test
    public void multiplyByBigDecimal() {
        Money multipliedMoney = new Money(new BigDecimal(25));
        assertThat(testMoney.multiplyBy(new BigDecimal(5)), is(multipliedMoney));
    }

    @Test
    public void multiplyByDouble() {
        Money multipliedMoney = new Money(new BigDecimal(25));
        assertThat(testMoney.multiplyBy(5d), is(multipliedMoney));
    }

    @Test
    public void add() {
        Money addedMoney = new Money(new BigDecimal(20));
        assertThat(testMoney.add(new Money(new BigDecimal(15))), is(addedMoney));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithOtherCurrency() {
        Money addedMoney = new Money(new BigDecimal(20), Currency.getInstance("PLN"));
        testMoney.add(addedMoney);
    }

    @Test
    public void subtract() {
        Money subtractedMoney = new Money(new BigDecimal(2));
        assertThat(testMoney.subtract(new Money(new BigDecimal(3))), is(subtractedMoney));
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractWithOtherCurrency() {
        Money subtractedMoney = new Money(new BigDecimal(2), Currency.getInstance("PLN"));
        testMoney.subtract(subtractedMoney);
    }


    @Test
    public void greaterThan() {
        Money greaterMoney = new Money(new BigDecimal(10));
        assertThat(greaterMoney.greaterThan(testMoney), is(true));
    }

    @Test
    public void lessThan() {
        Money lessMoney = new Money(new BigDecimal(1));
        assertThat(lessMoney.lessThan(testMoney), is(true));
    }

    @Test
    public void lessThanWthEqual() {
        Money equalMoney = new Money(new BigDecimal(5));
        assertThat(equalMoney.lessThan(testMoney), is(false));
    }

    @Test
    public void lessOrEqualsWithEqual() {
        Money equalMoney = new Money(new BigDecimal(5));
        assertThat(equalMoney.lessOrEquals(testMoney), is(true));
    }

}