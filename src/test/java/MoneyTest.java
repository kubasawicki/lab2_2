import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void mulitplyingByDoubleShouldReturnCorrectMoney(){
        Money money = new Money(10);
        assertThat(money.multiplyBy(10), Matchers.is( new Money( new BigDecimal(100) )));
    }
    @Test
    public void mulitplyingByBigDecimalShouldReturnCorrectMoney(){
        Money money = new Money(10);
        assertThat(money.multiplyBy( new BigDecimal( 10 ) ), Matchers.is( new Money( new BigDecimal(100) )));
    }
}
