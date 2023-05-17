package com.mpho.salesinvoiceapplication.repository;
import com.mpho.salesinvoiceapplication.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}




