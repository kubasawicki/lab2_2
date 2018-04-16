package lab2_2;

import static org.junit.Assert.assertThat;
import java.math.BigDecimal;
import java.util.Currency;
import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void addMoneyCompatibleCurrencyTest() {
    	Money money=new Money(new BigDecimal(10), Currency.getInstance("EUR"));
    	Money money2=new Money(new BigDecimal(100), Currency.getInstance("EUR"));
    	assertThat(money.add(money2), Matchers.is(new Money(new BigDecimal(110), Currency.getInstance("EUR"))));
    }

}
