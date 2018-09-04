package lab2_2;

import static org.junit.Assert.assertThat;
import java.math.BigDecimal;
import java.util.Currency;
import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void addMoneyCompatibleCurrencyTest() {
    	Money money=new Money(new BigDecimal(10), Currency.getInstance("EUR"));
    	Money money2=new Money(new BigDecimal(100), Currency.getInstance("EUR"));
    	assertThat(money.add(money2), Matchers.is(new Money(new BigDecimal(110), Currency.getInstance("EUR"))));
    }

    @Test(expected=IllegalArgumentException.class)
    public void addMoneyExceptionTest(){
    	Money money=new Money(new BigDecimal(10));
    	Currency currency=Currency.getInstance("PLN");
    	Money moneyWithDifferentCurrency=new Money(new BigDecimal(10),currency);
    	money.add(moneyWithDifferentCurrency);
    }
    
    @Test
    public void subtractMoneyCompatibleCurrencyTest() {
    	Money money=new Money(new BigDecimal(100), Currency.getInstance("EUR"));
    	Money money2=new Money(new BigDecimal(50), Currency.getInstance("EUR"));
    	assertThat(money.subtract(money2), Matchers.is(new Money(new BigDecimal(50), Currency.getInstance("EUR"))));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void subtractMoneyExceptionTest() {
	    Money money=new Money(new BigDecimal(10));
		Currency currency=Currency.getInstance("PLN");
		Money moneyWithDifferentCurrency=new Money(new BigDecimal(10),currency);
		money.subtract(moneyWithDifferentCurrency);
    }
 
    @Test
    public void multiplyByTestDouble() {
    	 Money money=new Money(new BigDecimal(10));
    	 assertThat(money.multiplyBy(5.0), Matchers.is(new Money(new BigDecimal(50))));
    }
    

    @Test
    public void multiplyByBigDecimalTest() {
    	Money money=new Money(new BigDecimal(10));
    	assertThat(money.multiplyBy(new BigDecimal(5)), Matchers.is(new Money(new BigDecimal(50))));
    }
    
    @Test
    public void moneyGreaterThanOtherTest() {
    	Money money=new Money(new BigDecimal(100));
    	Money money2=new Money(new BigDecimal(10));
    	assertThat(money.greaterThan(money2), Matchers.is(true));
    }
    
    @Test
    public void moneyLessThanOtherTest() {
    	Money money=new Money(new BigDecimal(100));
    	Money money2=new Money(new BigDecimal(10));
    	assertThat(money2.lessThan(money), Matchers.is(true));
    }
    
    @Test
    public void moneyEqualOrLessThanOtherTest()
    {
    	Money money=new Money(new BigDecimal(100));
    	Money money2=new Money(new BigDecimal(100));
    	assertThat(money2.lessOrEquals(money), Matchers.is(true));
    }
    
}
