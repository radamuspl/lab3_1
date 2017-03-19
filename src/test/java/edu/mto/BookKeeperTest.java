package edu.mto;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;

public class BookKeeperTest {
    @Test
    public void sampleTest(){
        InvoiceFactory invoiceFactory = Mockito.mock(InvoiceFactory.class);
        TaxPolicy taxPolicy = Mockito.mock(TaxPolicy.class);

        InvoiceRequest invoiceRequest = new InvoiceRequest(new ClientData(new Id("1"), "Kowalsk"));
        BookKeeper keeper = new BookKeeper(invoiceFactory);

        Invoice invoice = keeper.issuance(invoiceRequest, taxPolicy);

        Assert.assertThat(invoice.getItems(), Matchers.empty());
    }
}