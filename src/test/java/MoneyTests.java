import pl.com.bottega.ecommerce.sharedkernel.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyTests {

    @Test
    public void moneyMultipliedByDoubleShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(25.0));
        Money money = new Money(new BigDecimal(5.0));
        double multiplier = 5.0;
        assertThat(money.multiplyBy(multiplier), is(equalTo(expected)));
    }

    @Test
    public void moneyMultipliedByBigDecimalShouldBeEqualToExpectedMoney() {
        Money expected = new Money(new BigDecimal(48.0));
        Money money = new Money(new BigDecimal(6.0));
        BigDecimal multiplier = new BigDecimal(8.0);
        assertThat(money.multiplyBy(multiplier), is(equalTo(expected)));
    }
}
