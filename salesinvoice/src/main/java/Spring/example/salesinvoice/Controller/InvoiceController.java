package Spring.example.salesinvoice.Controller;

import Spring.example.salesinvoice.Entity.Invoice;
import Spring.example.salesinvoice.Repository.InvoiceRepository;
import Spring.example.salesinvoice.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    InvoiceRepository invoiceRepository;

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoiceService.addInvoice(invoice);
    }


    @GetMapping
    public List<Invoice> viewAllInvoices(){
        return  invoiceService.viewAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice viewALLInvoiceById(@PathVariable Long id) {

        return invoiceService.viewALLInvoiceById(id); }

}
