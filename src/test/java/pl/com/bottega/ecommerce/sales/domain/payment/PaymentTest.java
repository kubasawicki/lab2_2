package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.lang.reflect.Field;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void rollBackTest() {
        ClientData clientData = new ClientData(Id.generate(), "test");
        Payment payment = new Payment(Id.generate(), clientData , new Money(10.0));
        Payment expectedPayment = new Payment(Id.generate(), clientData, new Money(-10.0));
        Payment actualPayment = payment.rollBack();

        Class clsAc = actualPayment.getClass();
        Class clsEx = expectedPayment.getClass();
        try {
            Field fieldAc = clsAc.getDeclaredField("amount");
            Field fieldEx = clsEx.getDeclaredField("amount");
            fieldAc.setAccessible(true);
            fieldEx.setAccessible(true);
            assertThat(fieldAc.get(actualPayment), is(fieldEx.get(expectedPayment)));
        } catch (NoSuchFieldException ex) {
            fail("Test failed because class 'Payment' does not have field named 'amount'.");
        } catch (IllegalAccessException ex){
            fail("Probably test fix is needed. " + ex.getMessage());
        };
    }

}
