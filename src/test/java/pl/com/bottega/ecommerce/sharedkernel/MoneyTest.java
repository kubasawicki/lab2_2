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


}