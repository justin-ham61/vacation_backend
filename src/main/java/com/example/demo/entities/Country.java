package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.dialect.pagination.FetchLimitHandler;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="countries")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false, insertable = false, updatable = false)
    private Set<Division> divisions;
}
