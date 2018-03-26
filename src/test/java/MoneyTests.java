import pl.com.bottega.ecommerce.sharedkernel.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
}
