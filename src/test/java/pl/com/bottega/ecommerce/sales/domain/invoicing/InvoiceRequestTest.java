package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InvoiceRequestTest {
    static InvoiceRequest invoiceRequest;
    static ClientData clientData;
    static RequestItem requestItem;

    @BeforeClass
    public static void setUp() {
        clientData = new ClientData(new Id("X"), "Test");
        requestItem = new RequestItem(new ProductData(), 1, new Money(10));
        invoiceRequest = new InvoiceRequest(clientData);
    }

    @Test
    public void itemsShouldBeEmpty() {
        InvoiceRequest clearInvoiceRequest = new InvoiceRequest(clientData);
        assertThat(clearInvoiceRequest.getItems().isEmpty(), is(true));
    }

    @Test
    public void itemsShouldBeAdded() {
        invoiceRequest.add(requestItem);
        assertThat(invoiceRequest.getItems().isEmpty(), is(false));
        assertThat(invoiceRequest.getItems().size(), is(1));
        assertThat(invoiceRequest.getItems().contains(requestItem), is(true));
    }
}