package Spring.example.salesinvoice;

import Spring.example.salesinvoice.Entity.Invoice;
import Spring.example.salesinvoice.Entity.LineItem;
import Spring.example.salesinvoice.Repository.InvoiceRepository;
import Spring.example.salesinvoice.Service.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceServiceTest {

    @Autowired
    private InvoiceService invoiceService;

    @MockBean
    private InvoiceRepository invoiceRepository;

    @Test
    public void testAddInvoice(){
        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setClient("Mpho");
        invoice.setVatRate(14.00);
        invoice.setInvoiceDate(LocalDate.now());
        LineItem lineItem = new LineItem();
        lineItem.setId(1L);
        lineItem.setQuantity(2L);
        lineItem.setUnitPrice(BigDecimal.valueOf(200));

        when(invoiceRepository.save(invoice)).thenReturn(invoice);

        assertThat(invoiceService.addInvoice(invoice)).isEqualTo(invoice);

    }

    @Test
    public void testViewAllInvoices(){

        Invoice invoice1 = new Invoice();
        invoice1.setId(1L);
        invoice1.setClient("Mpho");
        invoice1.setVatRate(14.00);
        invoice1.setInvoiceDate(LocalDate.now());
        LineItem lineItem1 = new LineItem();
        lineItem1.setId(1L);
        lineItem1.setQuantity(2L);
        lineItem1.setUnitPrice(BigDecimal.valueOf(200));

        Invoice invoice2 = new Invoice();
        invoice2.setId(1L);
        invoice2.setClient("Mpho");
        invoice2.setVatRate(14.00);
        invoice2.setInvoiceDate(LocalDate.now());
        LineItem lineItem2 = new LineItem();
        lineItem2.setId(1L);
        lineItem2.setQuantity(2L);
        lineItem2.setUnitPrice(BigDecimal.valueOf(200));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        List<LineItem> lineItemList = new ArrayList<>();
        lineItemList.add(lineItem1);
        lineItemList.add(lineItem2);

        when(invoiceRepository.findAll()).thenReturn(invoiceList);
        assertThat(invoiceService.viewAllInvoices()).isEqualTo(invoiceList);

    }

}
