import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void mulitplyingByDoubleShouldReturnCorrectMoney(){
        Money money = new Money(10);
        assertThat(money.multiplyBy(10), Matchers.is( new Money( new BigDecimal(100) )));
    }
    @Test
    public void mulitplyingByBigDecimalShouldReturnCorrectMoney(){
        Money money = new Money(10);
        assertThat(money.multiplyBy( new BigDecimal( 10 ) ), Matchers.is( new Money( new BigDecimal(100) )));
    }
    @Test(expected = IllegalArgumentException.class)
    public void addingMoneyWithDifferentCurrencyShouldThrowException(){
        Money money1 = new Money(10, "PLN");
        Money money2 = new Money(20, "EUR");

        money1.add(money2);
    }
    @Test
    public void addingMoneyWithSameCurrencyShouldReturnCorrectMoney(){
        Money money1 = new Money(10, "PLN");
        Money money2 = new Money(20, "PLN");

        assertThat( money1.add(money2), is(new Money(30, "PLN")) );
    }
    @Test(expected = IllegalArgumentException.class)
    public void subtractingMoneyWithDifferentCurrencyShouldThrowException(){
        Money money1 = new Money(10, "PLN");
        Money money2 = new Money(20, "EUR");

        money1.subtract(money2);
    }
    @Test
    public void subtractingMoneyWithSameCurrencyAndBiggerMinuendShouldReturnCorrectPositiveMoney(){
        Money money1 = new Money(20, "PLN");
        Money money2 = new Money(10, "PLN");

        assertThat( money1.subtract(money2), is(new Money(10, "PLN")) );
    }
    @Test
    public void subtractingMoneyWithSameCurrencyAndLowerMinuendShouldReturnCorrectNegativeMoney(){
        Money money1 = new Money(10, "PLN");
        Money money2 = new Money(20, "PLN");

        assertThat( money1.subtract(money2), is(new Money(-10, "PLN")) );
    }

}
