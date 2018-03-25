package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTests {

	@Test
	public void MultiplyByTestBigDecimalShouldReturnSameValueAsMultiply() {
		Money money = new Money(new BigDecimal(10.50));
        BigDecimal value = new BigDecimal(5.50);
        final Money EXPECTED = new Money(new BigDecimal(10.50).multiply(new BigDecimal(5.50)));
        assertThat(EXPECTED, is(money.multiplyBy(value)));
	}
	
	@Test
	public void MultiplyByTestDoubleShouldReturnSameValueAsMultiply() {
		Money money = new Money(35.20);
        double value = 2.75;
        final Money EXPECTED = new Money(new BigDecimal(35.20).multiply(new BigDecimal(2.75)));
        assertThat(EXPECTED, is(money.multiplyBy(value)));
	}
	
	@Test
	public void MoneyAddedToMoneyWithTheSameCurrencyShouldReturnSameValueAsAddition() {
		Currency currency = Currency.getInstance("PLN");
		Money money = new Money(new BigDecimal(110.37), currency);
        Money money2 = new Money(new BigDecimal(39.63), currency);
        final Money EXPECTED = new Money(new BigDecimal(110.37 + 39.63), currency);
        assertThat(EXPECTED, is(money.add(money2)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void MoneyAddedToMoneyWithAnotherCurrencyShouldThrowIllegalArgumentException() {
		Currency currencyPLN = Currency.getInstance("PLN");
		Currency currencyUSD = Currency.getInstance("USD");
		Money moneyUSD = new Money(new BigDecimal(110.37), currencyUSD);
        Money moneyPLN = new Money(new BigDecimal(39.63), currencyPLN);
        final Money EXPECTED = new Money(new BigDecimal(110.37 + 39.63), currencyPLN);
        assertThat(EXPECTED, is(moneyUSD.add(moneyPLN)));      
	}	
	
	@Test
	public void MoneySubtractedFromMoneyWithTheSameCurrencyShouldReturnSameValueAsSubtraction() {
		Currency currency = Currency.getInstance("PLN");
		Money money = new Money(new BigDecimal(1200.50), currency);
        Money money2 = new Money(new BigDecimal(200.50), currency);
        final Money EXPECTED = new Money(new BigDecimal(1200.50 - 200.50), currency);
        assertThat(EXPECTED, is(money.subtract(money2)));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void MoneySubtractedFromMoneyWithAnotherCurrencyShouldThrowIllegalArgumentException() {
		Currency currencyPLN = Currency.getInstance("PLN");
		Currency currencyUSD = Currency.getInstance("USD");
		Money moneyUSD = new Money(new BigDecimal(1200.50), currencyUSD);
        Money moneyPLN = new Money(new BigDecimal(200.50), currencyPLN);
        final Money EXPECTED = new Money(new BigDecimal(1200.50 - 200.50), currencyPLN);
        assertThat(EXPECTED, is(moneyUSD.subtract(moneyPLN)));      
	}
	
	@Test
	public void MoneyGreaterThanAnotherMoneyShouldBeGreater() {
		Currency currency = Currency.getInstance("PLN");
		Money money = new Money(new BigDecimal(1200.50), currency);
        Money money2 = new Money(new BigDecimal(200.50), currency);
        final boolean EXPECTED = true;
        assertThat(EXPECTED, is(money.greaterThan(money2)));
	}
	
	@Test
	public void MoneyLessThanAnotherMoneyShouldBeLess() {
		Currency currency = Currency.getInstance("PLN");
		Money money = new Money(new BigDecimal(1200.50), currency);
        Money money2 = new Money(new BigDecimal(200.50), currency);
        final boolean EXPECTED = true;
        assertThat(EXPECTED, is(money2.lessThan(money)));
	}
	
	@Test
	public void MoneyLessThanOrEqualToAnotherMoneyShouldBeLessOrEqual() {
		Currency currency = Currency.getInstance("PLN");
		Money money = new Money(new BigDecimal(200.50), currency);
        Money money2 = new Money(new BigDecimal(200.50), currency);
        Money money3 = new Money(new BigDecimal(100.50), currency);
        final boolean EXPECTED = true;
        assertThat(EXPECTED, is(money.lessOrEquals(money2)));
        assertThat(EXPECTED, is(money3.lessOrEquals(money2)));
	}	
}
