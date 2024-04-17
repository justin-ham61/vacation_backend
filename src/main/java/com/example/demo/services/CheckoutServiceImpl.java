package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;
import java.util.UUID;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //get cart from purchase
        Cart cart = purchase.getCart();

        //get customer from purchase
        Customer customer = purchase.getCustomer();

        //Sets tracking number to cart
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrder_tracking_number(orderTrackingNumber);

        //sets cart's item from cartitems in purchase
        Set<CartItem> cartItems = purchase.getCartItems();
        cart.setCartItem(cartItems);

        //adds cart to customer and sets cart's customer to customer
        customer.addToCart(cart);
        cart.setCustomer(customer);
        cart.setStatus(StatusType.ordered);

        //saves customer and cart to the repository
        customerRepository.save(customer);
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
