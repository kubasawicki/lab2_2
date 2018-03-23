package lab2_2;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void moneyMultiplyByBigDecimalShouldReturnSameResultAsBigDecimalMultiplyMethod() {
        Money money = new Money(new BigDecimal(50.25));
        BigDecimal value = new BigDecimal(3.22);
        Money expectedMoney = new Money(new BigDecimal(50.25).multiply(new BigDecimal(3.22)));
        assertThat(money.multiplyBy(value), Matchers.is(expectedMoney));
    }
    
    @Test
    public void moneyMultiplyByDoubleShouldReturnSameResultAsBigDecimalMultiplyMethod() {
        Money money = new Money(new BigDecimal(27.14));
        double value = 4.92;
        Money expectedMoney = new Money(new BigDecimal(27.14).multiply(new BigDecimal(4.92)));
        assertThat(money.multiplyBy(value), Matchers.is(expectedMoney));
    }
    
    @Test
    public void moneyAddedToOtherMoneyInTheSameCurrencyShouldBeAdded() {
        Money firstMoneyEUR = new Money(new BigDecimal(20.25));
        Money secondMoneyEUR = new Money(new BigDecimal(14.50));
        Money expectedMoney = new Money(new BigDecimal(20.25 + 14.50));
        assertThat(firstMoneyEUR.add(secondMoneyEUR), Matchers.is(expectedMoney));
    }
}
