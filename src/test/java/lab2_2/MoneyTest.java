package lab2_2;

<<<<<<< HEAD
public class MoneyTest {

}
=======
import static org.junit.Assert.assertThat;
import java.math.BigDecimal;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

@BeforeClass
public static void setUpBeforeClass() throws Exception {
	Money money=new Money(new BigDecimal(10), null);
	assertThat(money.multiplyBy(5.0), Matchers.is(new Money(new BigDecimal(50))));
}

}
>>>>>>> c10739f9d2f2ef36ab73fa9639c4c7ab001e02d8
