package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMoney {

    static Money money;

    @BeforeClass
    public static void createMoney() {
        money = new Money(new BigDecimal(10));
    }

    @Test
    public void multiplyBigDecimalArgument() {
        assertThat(money.multiplyBy(new BigDecimal(10)), is(new Money(new BigDecimal(100))));
    }

    @Test
    public void multiplyDoubleArgument() {
        assertThat(money.multiplyBy(new Double(10)), is(new Money(new BigDecimal(100))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentException() throws IllegalArgumentException {
        Currency testCurrency = Currency.getInstance("USD");
        Money testMoney = new Money(10, testCurrency);
        money.add(testMoney);
    }
}
