package com.mpho.salesinvoiceapplication.Service;
import com.mpho.salesinvoiceapplication.entity.Invoice;
import com.mpho.salesinvoiceapplication.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> viewAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice viewALLInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

}
