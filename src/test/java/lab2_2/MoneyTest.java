package lab2_2;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

//test dla multiplyBy, add, subtract, compatibleCurrency, isZero, determineCurrencyCode 
public class MoneyTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Money money=new Money(new BigDecimal(10), null);
    }

    @Test
    public void test() {
        
    }

}
