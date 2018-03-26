package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Currency;

import org.junit.BeforeClass;

public class MoneyTests {

    static Money oneHundredPLN;
    static Money oneHundredEUR;
    static Money twentyEUR;

    @BeforeClass
    public static void createMoney() {
        oneHundredPLN = new Money(100, "PLN");
        oneHundredEUR = new Money(100, Currency.getInstance("EUR"));
        twentyEUR = new Money(20);
    }

    @org.junit.Test
    public void addTwoMoneyObjects() {
        Money oneHundredTwentyEUR = new Money(120);
        assertThat(oneHundredEUR.add(twentyEUR).equals(oneHundredTwentyEUR), is(true));
    }

    @org.junit.Test
    public void subtractTwoMoneyObjects() {
        Money eightyEUR = new Money(80);
        assertThat(oneHundredEUR.subtract(twentyEUR).equals(eightyEUR), is(true));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addTwoDifferentCurrencyMoneyObjects() {
        oneHundredPLN.add(oneHundredEUR);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void subtractTwoDifferentCurrencyMoneyObjects() {
        oneHundredPLN.subtract(oneHundredEUR);
    }
}
