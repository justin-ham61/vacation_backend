package com.example.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
