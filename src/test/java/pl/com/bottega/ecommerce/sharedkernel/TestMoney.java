package pl.com.bottega.ecommerce.sharedkernel;
import static org.hamcrest.CoreMatchers.is;
import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;

public class TestMoney {
	
	@Test
	public void multiplyDoubleEqualsMultiplyBigDecimal() {
		Money multiplyDoubleMoney=(new Money(new BigDecimal(120.30))).multiplyBy(2.21);
		Money multiplyBigDecimalMoney= (new Money(new BigDecimal(120.30))).multiplyBy(new BigDecimal(2.21));
		
		Assert.assertThat(multiplyDoubleMoney, is(multiplyBigDecimalMoney));
	}
	
	@Test
	public void addingMoneyInTheSameCurrency() {
		Money moneyFirst = new Money(new BigDecimal(12.20));
		Money moneySecond= new Money(new BigDecimal(13.20));
		Money result= new Money(new BigDecimal(12.20+13.20));
		Assert.assertThat(moneyFirst.add(moneySecond), is(result));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addingMoneyInDifferentCurrency() {
		Money moneyFirst = new Money(new BigDecimal(12.20));
		Money moneySecond= new Money(new BigDecimal(13.20), Currency.getInstance("PLN"));
		moneyFirst.add(moneySecond);
	}
	
	@Test
	public void substractMoneyInTheSameCurrency() {
		Money moneyFirst=new Money(new BigDecimal(12.20));
		Money moneySecond=new Money(new BigDecimal(11.20));
		Money result = new Money(new BigDecimal(12.20-11.20));
		Assert.assertThat(moneyFirst.subtract(moneySecond), is(result));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void substractMoneyInDifferentCurrency() {
		Money moneyFirst=new Money(new BigDecimal(12.20));
		Money moneySecond=new Money(new BigDecimal(11.20),Currency.getInstance("PLN"));
		moneyFirst.subtract(moneySecond);
	}
}
