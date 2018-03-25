package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InvoiceTest {
    double productPrise = 2.00;
    int productQuantity = 5;
    double net = 10.00;
    double tax = 5.00;

    ProductData productData = new ProductData(Id.generate(), new Money(productPrise), "test product",
            ProductType.FOOD, new Date());
    InvoiceLine invoiceLine = new InvoiceLine(productData, productQuantity, new Money(net),
            new Tax(new Money(tax), "tax test description"));

    @Test
    public void addTwoItemsTest(){
        Invoice invoice = new Invoice(Id.generate(), new ClientData(Id.generate(), "test"));
        invoice.addItem(invoiceLine);
        invoice.addItem(invoiceLine);

        assertThat(invoice.getNet(), is(new Money(2 * net)));
        assertThat(invoice.getGros(), is(new Money(2 * (net + tax))));
        ArrayList<InvoiceLine> list = new ArrayList<InvoiceLine>(){{
            add(invoiceLine);
            add(invoiceLine);
        }};
        assertThat(invoice.getItems(), Matchers.<List<InvoiceLine>>is(list));
    }

}