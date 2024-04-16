package com.example.demo.entities;

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


    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    private StatusType status;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cutomer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;


    private Set<CartItem> cartItem;
}
