package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.customerRepository=customerRepository;
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Cart cart = purchase.getCart();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);


        // populate cart with cartitems
        Set<CartItem> cartItems=purchase.getCartItems();
        cartItems.forEach(item -> {
            item.setCart(cart);
            item.getExcursions().forEach(excursion -> {
                excursion.setVacation(item.getVacation());
                excursion.getCartitems().add(item);
            });
        });

        cart.setCustomer(purchase.getCustomer());
        cart.setCartItem(purchase.getCartItems());

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        cart.setStatus(StatusType.ordered);
        cart.setCartItem(cartItems);
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);

        /*
        cart.getCartItem().add(item));

        System.out.println(cart);


        // populate customer with order
        Customer customer=purchase.getCustomer();
        customer.getCarts().add(cart);


        // save to database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
        */
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number
        return UUID.randomUUID().toString();

    }
}

