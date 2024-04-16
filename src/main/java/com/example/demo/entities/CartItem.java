package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    private Vacation vacation;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "excursion_id", nullable = false, insertable = false, updatable = false )
    private Set<Excursion> excursions;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
    private Cart cart;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;
}
