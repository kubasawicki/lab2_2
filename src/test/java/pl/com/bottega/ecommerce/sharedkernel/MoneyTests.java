package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.BeforeClass;

public class MoneyTests {

    static Money oneHundredPLN;

    static Money minusEightyEUR;
    static Money twentyEUR;
    static Money eightyEUR;
    static Money oneHundredEUR;
    static Money oneHundredTwentyEUR;

    static Money zero;

    @BeforeClass
    public static void createFewMoneyObjects() {
        oneHundredPLN = new Money(100, "PLN");

        minusEightyEUR = new Money(-80);
        twentyEUR = new Money(20);
        eightyEUR = new Money(80);
        oneHundredEUR = new Money(100, Currency.getInstance("EUR"));
        oneHundredTwentyEUR = new Money(120);

        zero = new Money(0);
    }

    @org.junit.Test
    public void addingTwoMoneyObjectsShouldEqualObjectWithAddedValue() {
        assertThat(oneHundredEUR.add(twentyEUR).equals(oneHundredTwentyEUR), is(true));
    }

    @org.junit.Test
    public void subtractingTwoMoneyObjectsShouldEqualObjectWithSubstractedValue() {
        assertThat(oneHundredEUR.subtract(twentyEUR).equals(eightyEUR), is(true));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addingTwoDifferentCurrencyMoneyObjectsShouldCauseException() {
        oneHundredPLN.add(oneHundredEUR);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void subtractingTwoDifferentCurrencyMoneyObjectsShouldCauseException() {
        oneHundredPLN.subtract(oneHundredEUR);
    }

    @org.junit.Test
    public void substractingHigherValueMoneyFromLowerValueMoneyShouldEqualObjectWithMinusValue() {
        assertThat(twentyEUR.subtract(oneHundredEUR).equals(minusEightyEUR), is(true));
    }

    @org.junit.Test
    public void moneyMultiplyingMethodShouldReturnEqualResultAsBigDecimalMultiplyMethod() {
        Money money = new Money(new BigDecimal(100));
        BigDecimal multiplyValue = new BigDecimal(2.5);

        assertThat(money.multiplyBy(multiplyValue), is(new Money(new BigDecimal(100).multiply(new BigDecimal(2.5)))));
    }

    @org.junit.Test
    public void oneHundredEuroShouldBeGreaterThanTwentyEuro() {
        assertThat(oneHundredEUR.greaterThan(twentyEUR), is(true));
    }

    @org.junit.Test
    public void twentyEuroShouldBeLessThanOneHundredEuro() {
        assertThat(twentyEUR.lessThan(oneHundredEUR), is(true));
    }

    @org.junit.Test
    public void minusEightyEURShouldBeLesThanoneHundredEuro() {
        assertThat(minusEightyEUR.lessOrEquals(zero), is(true));
    }

}
