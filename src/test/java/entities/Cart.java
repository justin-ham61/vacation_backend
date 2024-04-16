package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="cart")
@Data
public class Cart {
    private Long id;
    private BigDecimal package_price;
    private int party_size;
    private StatusType status;
    private Date create_date;
    private Date last_update;
    private Customer customer;
    private Set<CartItem> cartItem
}
