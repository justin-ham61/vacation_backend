package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Data
public class Division {
    private Long id;
    private String division_name;
    private Date create_date;
    private Date last_update;
    private Country country;
    private Long country_id;
    private Set<Customer> customers;
}
