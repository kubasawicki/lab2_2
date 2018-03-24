package lab2_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTests {

	@Test
	public void MultiplyByTestBigDecimal() {
		Money money = new Money(new BigDecimal(10.50));
        BigDecimal value = new BigDecimal(5.50);
        final Money EXPECTED = new Money(new BigDecimal(10.50).multiply(new BigDecimal(5.50)));
        assertThat(EXPECTED, is(money.multiplyBy(value)));
	}
	
	@Test
	public void MultiplyByTestDouble() {
		Money money = new Money(35.20);
        double value = 2.75;
        final Money EXPECTED = new Money(new BigDecimal(35.20).multiply(new BigDecimal(2.75)));
        assertThat(EXPECTED, is(money.multiplyBy(value)));
	}
}
