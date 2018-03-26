package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {


    @Test
    public void multiplyBy() throws Exception {
        Money priceEUR = new Money( 13.57 );
        double multiplier = 6.12;
        Money expectedValue = new Money( 13.57 * 6.12 );
        assertThat( priceEUR.multiplyBy( multiplier ), is( expectedValue ) );
    }

    @Test
    public void addPrice() throws Exception {
        Money priceEUR1 = new Money( 13.57 );
        Money priceEUR2 = new Money( 11.33 );
        Money expectedValue = new Money( 13.57 + 11.33, "EUR" );
        assertThat( priceEUR1.add( priceEUR2 ), is( expectedValue ) );
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPriceInOtherCurrency() throws Exception {
        Money priceEUR1 = new Money( 13.57 );
        Money priceEUR2 = new Money( 11.33, "PLN" );
        priceEUR1.add( priceEUR2 );
    }

    @Test
    public void subtract() throws Exception {
        Money priceEUR1 = new Money( 23.57 );
        Money priceEUR2 = new Money( 10.33 );
        Money expectedValue = new Money( 23.57 - 10.33, "EUR" );
        assertThat( priceEUR1.subtract( priceEUR2 ), is( expectedValue ) );
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractPriceInOtherCurrency() throws Exception {
        Money priceEUR1 = new Money( 23.57 );
        Money priceEUR2 = new Money( 10.33 , "PLN");
        priceEUR1.subtract( priceEUR2 );
    }

    @Test
    public void greaterThan() throws Exception {
        Money priceEUR1 = new Money( 23.57 );
        Money priceEUR2 = new Money( 10.33 );
        assertThat( priceEUR1.greaterThan( priceEUR2 ), is( true ) );
    }

    @Test
    public void lessThan() throws Exception {
        Money priceEUR1 = new Money( 23.57 );
        Money priceEUR2 = new Money( 10.33 );
        assertThat( priceEUR2.lessThan( priceEUR1 ), is( true ) );
    }

    @Test
    public void checkEquals() throws Exception {
        Money priceEUR1 = new Money( 11.11 );
        Money priceEUR2 = new Money( 11.11 );
        assertThat( priceEUR1.lessOrEquals( priceEUR2 ), is( true ) );
    }

    @Test
    public void checkLess() throws Exception {
        Money priceEUR1 = new Money( 11.11 );
        Money priceEUR2 = new Money( 12.11 );
        assertThat( priceEUR1.lessOrEquals( priceEUR2 ), is( true ) );
    }

}