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
    public void substractPriceInOtherCurrency() throws Exception {
        Money priceEUR1 = new Money( 23.57 );
        Money priceEUR2 = new Money( 10.33 );
        priceEUR1.add( priceEUR2 );
    }


}