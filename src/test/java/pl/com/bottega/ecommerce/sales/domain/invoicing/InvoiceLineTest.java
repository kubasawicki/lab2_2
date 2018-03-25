package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InvoiceLineTest {
    double productPrise = 2.00;
    int productQuantity = 5;
    double net = 10.00;
    double tax = 5.00;

    ProductData productData = new ProductData(Id.generate(), new Money(productPrise), "test product",
            ProductType.FOOD, new Date());

    @Test
    public void invoiceLineConstructorCalculateGrossTest() {
        InvoiceLine invoiceLine = new InvoiceLine(productData, productQuantity, new Money(net),
                new Tax(new Money(tax), "tax test description"));
        assertThat(invoiceLine.getGros(), is(new Money(net + tax)));
    }

}