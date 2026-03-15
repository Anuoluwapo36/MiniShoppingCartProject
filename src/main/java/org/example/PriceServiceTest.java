package org.example;

import org.example.model.CartItem;
import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.example.service.PricingService;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceServiceTest {

    @org.junit.jupiter.api.Test
    public void testCalculationSubtotal(){
        Product product1 = new Product("laptop",1000,"macbook pro max 16gb");
        Product product2 = new Product("Iphone 17 pro max", 1200, "iphone 17 pro max come with a unique camera and smooth quality speakers");
        Product product3 = new Product("laptop",500,"air pod");

        CartItem item1 = new CartItem(product1,2);
        CartItem item2 = new CartItem(product2,1);
        CartItem item3 = new CartItem(product3,2);


        List<CartItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        ShoppingCart cart = new ShoppingCart(items);


        PricingService service = new PricingService();



        double subtotal = service.calculateSubTotal(cart);
        double calTax = service.calculateTax(cart);
        double discountAmount = service.calculateDiscount(cart);
        double finalPrice = service.priceAfterTaxAndDiscountAndShipping(cart);
        double shippingFess = service.calculateShipping(cart);

        assertEquals(4200.0, subtotal, 0.001);
        assertEquals(420.0, calTax,0.001);
        assertEquals(504.0, discountAmount , 0.001);
        assertEquals(4326.0, finalPrice, 0.001);
        assertEquals(210, shippingFess, 0.001);

    }



}
