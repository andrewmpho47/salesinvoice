package com.mpho.salesinvoiceapplication.controller;

import com.mpho.salesinvoiceapplication.entity.Invoice;
import com.mpho.salesinvoiceapplication.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }
    @PostMapping("/invoices")
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoiceService.addInvoice(invoice);
    }

    @GetMapping("invoices")
    public List<Invoice> viewAllInvoices(){
        return  invoiceService.viewAllInvoices();
    }
    @GetMapping("invoices/{id}")
    public Invoice viewALLInvoiceById(@PathVariable Long id) {
        return invoiceService.viewALLInvoiceById(id);
    }

}
