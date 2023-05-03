package Spring.example.salesinvoice.Entity;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_invoice")
@Component
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id")
    private Long id;
    @Column(name = "client")
    private String client;
    @Column(name = "vatRate")
    private Double vatRate;
    @Column(name = "invoiceDate")
    private LocalDate invoiceDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
    private List<LineItem> lineItem;

    //getter and setter
    public Long getId(){
        return id;
    }

    public void setId(Long inId){
        this.id = inId;
    }

    public String getClient(){
        return client;
    }

    public void setClient(String inClient){
        this.client = inClient;
    }

    public Double getVatRate() {
        return vatRate;
    }

    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }
    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getSubTotal() {
        return this.getTotal().subtract(this.getVat());
    }
    public BigDecimal getVat() {
        return this.getTotal().multiply(new BigDecimal(Double.toString(this.vatRate/100)));
    }
    public BigDecimal getTotal() {
        if (this.lineItem == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (LineItem lineItem : this.lineItem) {
            total = total.add(lineItem.getLineItemTotal());
        }
        return total;
    }
}
