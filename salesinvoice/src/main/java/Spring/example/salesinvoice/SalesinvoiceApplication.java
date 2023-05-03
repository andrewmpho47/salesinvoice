package Spring.example.salesinvoice;

import Spring.example.salesinvoice.Entity.Invoice;
import Spring.example.salesinvoice.Repository.InvoiceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class SalesinvoiceApplication {

	public static void main(String[] args)
	{
		//access the context
		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(SalesinvoiceApplication.class, args);

		//object to get bean from context and storing
		InvoiceRepository invoiceRepository = configurableApplicationContext.getBean(InvoiceRepository.class);

		Invoice myInvoice = new Invoice();
		invoiceRepository.save(myInvoice);
	}

}
