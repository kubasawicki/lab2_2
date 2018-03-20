package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    static Money money;

    @BeforeClass
    public static void createMoney() {
        money = new Money(new BigDecimal(10));
    }

    @Test
    public void multiplyByWhenArgumentIsBigDecimal() {
        assertThat(money.multiplyBy(new BigDecimal(10)), is(new Money(new BigDecimal(100))));
    }

    @Test
    public void multiplyByWhenArgumentIsDouble() {
        assertThat(money.multiplyBy(new Double(10)), is(new Money(new BigDecimal(100))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowingIllegalArgumentException() throws IllegalArgumentException {
        Currency testCurrency = Currency.getInstance("USD");
        Money testMoney = new Money(10, testCurrency);
        money.add(testMoney);
    }

    @Test
    public void addTwoMoneyObjects() {
        Money testMoney = new Money(10);
        assertThat(money.add(testMoney), is(new Money(20)));
    }


    @Test(expected = IllegalArgumentException.class)
    public void subtractThrowingIllegalArgumentException() throws IllegalArgumentException {
        Currency testCurrency = Currency.getInstance("USD");
        Money testMoney = new Money(10, testCurrency);
        money.subtract(testMoney);
    }

    @Test
    public void subtractTwoMoneyObject() {
        Money testMoney = new Money(5);
        assertThat(money.subtract(testMoney), is(new Money(5)));
    }

}