package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookKeeperTest {
    static InvoiceRequest invoiceRequest;
    static TaxPolicy taxPolicy;
    static RequestItem requestItem;
    static Invoice invoice;

    static BookKeeper bookKeeper;

    @BeforeClass
    public static void setUpTax() {
        taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                return new Tax(net.multiplyBy(0.1), "Test tax");
            }
        };
        requestItem = new RequestItem(new ProductData(), 1, new Money(10));
        bookKeeper = new BookKeeper(new InvoiceFactory());
    }

    @Before
    public void setUpInvoice() {
        invoiceRequest = new InvoiceRequest(new ClientData(new Id("1"), "Test"));
        invoiceRequest.add(requestItem);
        invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
    }

    @Test
    public void itemsShouldBeAdded() {
        assertThat(invoice.getItems().size(), is(1));
    }

    @Test
    public void correctNetValueShouldBeReturned() {
        assertThat(invoice.getNet(), is(new Money(10)));
    }

    @Test
    public void correctGrosValueShouldBeReturned() {
        assertThat(invoice.getGros(), is(new Money(11)));
    }

    @Test
    public void multipleItemsShouldSumNetValues() {
        invoiceRequest.add(requestItem);
        invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(invoice.getNet(), is(new Money(20)));
    }

    @Test
    public void multipleItemsShouldSumGrosValues() {
        invoiceRequest.add(requestItem);
        invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(invoice.getGros(), is(new Money(22)));
    }
}