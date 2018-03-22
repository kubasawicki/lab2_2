package lab2_2;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

//test dla multiplyBy, add, subtract, greaterThan, LessThan, EqualTo...
public class MoneyTest {

    @Test
    public void multiplyByTestWithArgumentDouble() {
    	 Money money=new Money(new BigDecimal(10));
    	 assertThat(money.multiplyBy(5.0), Matchers.is(new Money(new BigDecimal(50))));
    }
    @Test
    public void multiplyByTestWithArgumentBigDecimal() {
    	Money money=new Money(new BigDecimal(10));
    	assertThat(money.multiplyBy(new BigDecimal(5)), Matchers.is(new Money(new BigDecimal(50))));
    }
    @Test(expected=IllegalArgumentException.class)
    public void addMoneyTestThrowsException(){
    	Money money=new Money(new BigDecimal(10));
    	Currency currency=Currency.getInstance("PLN");
    	Money moneyWithDifferentCurrency=new Money(new BigDecimal(10),currency);
    	money.add(moneyWithDifferentCurrency);
    }
    @Test
    public void addMoneyWithCompatibleCurrencyTest() {
    	Money money=new Money(new BigDecimal(10), Currency.getInstance("EUR"));
    	Money money2=new Money(new BigDecimal(100), Currency.getInstance("EUR"));
    	assertThat(money.add(money2), Matchers.is(new Money(new BigDecimal(110), Currency.getInstance("EUR"))));
    }
    
}
