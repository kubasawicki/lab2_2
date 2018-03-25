package pl.com.bottega.ecommerce.sales.domain.purchase;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PurchaseTest {

    @Test
    public void confirmChangesPaidStatusTest() {
        Purchase purchase = new Purchase(Id.generate(), new ClientData(Id.generate(), "test"),
                new ArrayList<PurchaseItem>() , new Date(), false, new Money(10.0));
        purchase.confirm();
        assertThat(purchase.isPaid(), is(true));
    }
}