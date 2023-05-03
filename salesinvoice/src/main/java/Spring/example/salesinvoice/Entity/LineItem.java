package Spring.example.salesinvoice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_lineItem")
public class LineItem {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "lt_id")
     private Long id;
     @Column(name = "quantity")
     private Long quantity;

     @Column(name = "description")
     private String description;
     @Column(name = "unitPrice")
     private BigDecimal unitPrice;

     @ManyToOne
     @JoinColumn(name = "inv_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @JsonIgnore
     private Invoice invoice;


     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public Long getQuantity() {
          return quantity;
     }

     public void setQuantity(Long quantity) {
          this.quantity = quantity;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public BigDecimal getUnitPrice() {
          return unitPrice;
     }

     public void setUnitPrice(BigDecimal unitPrice) {
          this.unitPrice = unitPrice;
     }

     public Invoice getInvoice() {
          return invoice;
     }

     public void setInvoice(Invoice invoice) {
          this.invoice = invoice;
     }

     public BigDecimal getLineItemTotal(){

        return unitPrice.multiply(BigDecimal.valueOf(quantity));

    }
}
