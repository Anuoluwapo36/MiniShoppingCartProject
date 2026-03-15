package org.example.service;


import org.example.config.GlobalSettings;
import org.example.model.CartItem;
import org.example.model.ShoppingCart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PricingService {


    /**
     * calculating subtotal of all items in shopping cart
     *by looping through the cart model to get items in the cart model
     *
     * @param shoppingCart
     * @return
     */
    public double  calculateSubTotal(ShoppingCart shoppingCart){

        double subtotal = 0.0;

        for (CartItem item : shoppingCart.getItems()){
            subtotal += item.subTotal();
        }
        return subtotal;

    }

    /**
     * tax calculation for all item in cart model
     * @param cart
     * @return
     */
    public double calculateTax(ShoppingCart cart){

        double taxAmount= 0.0;
        double taxPercentage = GlobalSettings.getTaxPercentage();

        if(cart == null){
            return  taxAmount;
        }
        for (CartItem item : cart.getItems()){

            if(item == null) continue;


            taxAmount += item.getProduct().getPrice() * item.getQuantity() * taxPercentage / 100;
        }
        return taxAmount;

    }


    /**
     * calculating discount for all items in cart model
     * and return back the amount of discount minus from
     * after base price and quantity are multiply and minus discount
     * and return the discount price
     * @param cart
     * @return
     */
    public double calculateDiscount(ShoppingCart cart){
        double discountAmount = 0.0;
        double discountPercentage = GlobalSettings.getDiscountPercentage();

        if(cart == null) return discountAmount;

        for(CartItem item : cart.getItems()){
            if(item == null) continue;
            discountAmount += item.getProduct().getPrice() * item.getQuantity() * discountPercentage / 100;
        }
        return discountAmount;

    }

    /**
     * total price of all items in cart and shopping cart after the
     * tax have been applied and minus the discount
     * and get the remaining price
     * @param cart
     * @return
     */
    public double priceAfterTaxAndDiscountAndShipping(ShoppingCart cart){
        double totalPrice=0.0;

        if(cart == null ) return totalPrice;

        totalPrice = calculateSubTotal(cart) + calculateTax(cart) - calculateDiscount(cart) + calculateShipping(cart);

        return totalPrice;
    }

    /**
     * shipping price of items in subtotal
     * this how the amount will be pay for shipping fees
     * @param cart
     * @return
     */
    public double calculateShipping(ShoppingCart cart){
        double shippingPrice = 0.0;
        double shippingPercentage = GlobalSettings.getShipping_Update();

        if(cart == null) return  shippingPrice;

        shippingPrice = calculateSubTotal(cart) * shippingPercentage / 100;

        return shippingPrice;

    }


    /**
     * price breakdown for good visual track
     * used Map LinkedHaspMap to return the receipt for the price breakdown
     * calling each method calculation return back the actual data we need
     * @param cart
     * @return
     */
    public  Map<String, Double> getPriceBreakDown(ShoppingCart cart){
        double tax = calculateTax(cart);
        double shippingPrice = calculateShipping(cart);
        double discount = calculateDiscount(cart);
        double finalPrice = priceAfterTaxAndDiscountAndShipping(cart);


        Map<String, Double> breakDown = new LinkedHashMap<>();
        breakDown.put("tax", tax);
        breakDown.put("discount", discount);
        breakDown.put("shippingFees", shippingPrice);
        breakDown.put("finalPrice", finalPrice);




        return breakDown;
    }


}
