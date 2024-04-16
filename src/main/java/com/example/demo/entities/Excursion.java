package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Data
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    private Vacation vacation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_item_id", nullable = false, insertable = false, updatable = false)
    private Set<CartItem> cartitems;

}
