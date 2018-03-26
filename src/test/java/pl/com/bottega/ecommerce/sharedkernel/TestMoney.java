package pl.com.bottega.ecommerce.sharedkernel;
import static org.hamcrest.CoreMatchers.is;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TestMoney {
	
	@Test
	public void multiplyDoubleEqualsMultiplyBigDecimal() {
		Money multiplyDoubleMoney=(new Money(new BigDecimal(120.30))).multiplyBy(2.21);
		Money multiplyBigDecimalMoney= (new Money(new BigDecimal(120.30))).multiplyBy(new BigDecimal(2.21));
		
		Assert.assertThat(multiplyDoubleMoney, is(multiplyBigDecimalMoney));
	}
}
