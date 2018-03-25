package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {
    Money moneyTenDollars = new Money(10.0, Currency.getInstance("USD"));
    Money moneyFiveDollars = new Money(5.0, Currency.getInstance("USD"));

    @Test
    public void addMoneyDifferentCurrenciesThrowsExceptionTest() {
        Money moneyEuros = new Money(5.0, Currency.getInstance("EUR"));
        try {
            moneyTenDollars.add(moneyEuros);
            fail();
        } catch (IllegalArgumentException ex){}
    }

    @Test
    public void addMoneyTest() {
        assertThat(moneyTenDollars.add(moneyFiveDollars), is(new Money(15.0, Currency.getInstance("USD"))));
    }

    @Test
    public void substractMoneyTest() {
        assertThat(moneyTenDollars.subtract(moneyFiveDollars), is(new Money(5.0, Currency.getInstance("USD"))));
    }
}