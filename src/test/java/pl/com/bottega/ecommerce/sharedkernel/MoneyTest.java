package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    Money pln1 = new Money(10,"PLN");
    Money pln2 = new Money(25,"PLN");
    @Test
    public void multiplierExpectedValueTest(){
        Money expected = new Money(100, "PLN");
        assertThat(pln1.multiplyBy(10), is(equalTo(expected)));

    }
    @Test
    public void addingValuesTest(){
        Money expected = new Money(35,"PLN");
        assertThat(pln1.add(pln2), is(equalTo(expected)));
    }

}