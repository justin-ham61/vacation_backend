package com.example.demo.services;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
