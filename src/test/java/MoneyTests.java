import pl.com.bottega.ecommerce.sharedkernel.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyTests {

    @Test
    public void moneyMultipliedByDoubleShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(25.0));
        Money money = new Money(new BigDecimal(5.0));
        double multiplier = 5.0;
        assertThat(money.multiplyBy(multiplier), is(equalTo(expected)));
    }

    @Test
    public void moneyMultipliedByBigDecimalShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(48.0));
        Money money = new Money(new BigDecimal(6.0));
        BigDecimal multiplier = new BigDecimal(8.0);
        assertThat(money.multiplyBy(multiplier), is(equalTo(expected)));
    }

    @Test
    public void addedMoneyShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(15.0));
        Money money1 = new Money(6.5);
        Money money2 = new Money(8.5);
        assertThat(money1.add(money2), is(equalTo(expected)));
    }

    @Test
    public void subtractedMoneyShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(20.0));
        Money money1 = new Money(30.0);
        Money money2 = new Money(10.0);
        assertThat(money1.subtract(money2), is(equalTo(expected)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void additionOfMoneyWithDifferentCurrenciesShouldThrowIllegalArgumentException() {
        Money money1 = new Money(39.99, "CNY");
        Money money2 = new Money(61.01, "PLN");
        money1.add(money2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractionOfMoneyWithDifferentCurrenciesShouldThrowIllegalArgumentException() {
        Money money1 = new Money(99.99, "EUR");
        Money money2 = new Money(39.99, "GBP");
        money1.add(money2);
    }

    @Test
    public void moneyWithDifferentCurrenciesButSameDenominationShouldNotBeEqual() {
        Money money1 = new Money(25.0, "EUR");
        Money money2 = new Money(25.0, "USD");
        assertThat(money1, is(not(equalTo(money2))));
    }

    @Test
    public void moneyWithTheSameCurrenciesButDifferentDenominationShouldNotBeEqual() {
        Money money1 = new Money(2.50, "CHF");
        Money money2 = new Money(1.49, "CHF");
        assertThat(money1, is(not(equalTo(money2))));
    }

    @Test
    public void moneyWithTheSameCurrenciesAndDenominationShouldBeEqual() {
        Money money1 = new Money(100.0, "PLN");
        Money money2 = new Money(100.0, "PLN");
        assertThat(money1, is((equalTo(money2))));
    }

    @Test
    public void denominationOfOneMoneyShouldBeGreaterThanTheOther() {
        Money money1 = new Money(60.0);
        Money money2 = new Money(40.0);
        assertThat(money1.greaterThan(money2), is(true));
    }

    @Test
    public void denominationOfOneMoneyShouldBeLessThanTheOther() {
        Money money1 = new Money(30.0);
        Money money2 = new Money(70.0);
        assertThat(money1.lessThan(money2), is(true));
    }

    @Test
    public void denominationOfOneMoneyShouldBeLessOrEqualToTheOther() {
        Money money1 = new Money(69.99);
        Money money2 = new Money(120.50);
        assertThat(money1.lessOrEquals(money2), is(true));
    }

    @Test
    public void denominationOfOneMoneyShouldBeLessOrEqualToTheOtherWithTheSameDenomination() {
        Money money1 = new Money(10.0);
        Money money2 = new Money(10.0);
        assertThat(money1.lessOrEquals(money2), is(true));
    }
}
