package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="carts")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;


    private BigDecimal package_price;
    private int party_size;
    private StatusType status;
    private Date create_date;
    private Date last_update;
    private Customer customer;
    private Set<CartItem> cartItem;
}
