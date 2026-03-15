package org.example;

import org.example.config.GlobalSettings;
import org.example.model.CartItem;
import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.example.service.PricingService;

import java.util.ArrayList;
import java.util.Map;


public class Main {
    static void main() {
        updateGlobalRule();
        Product laptop = new Product("laptop",1000,"mac book bro");
        Product iphone = new Product("iPhone 17 Air",1200,"Think different");


        CartItem item1 = new CartItem(laptop,5);
        CartItem item2 = new CartItem(iphone,5);

        ShoppingCart cart = new ShoppingCart(new ArrayList<>());
        cart.addItem(item1);
        cart.addItem(item2);
        displayCartItem(cart);
        PricingService service = new PricingService();



        Map<String, Double> breakDown = service.getPriceBreakDown(cart);

        System.out.println("==============Price Summary=================");
        for(String key : breakDown.keySet()){


            System.out.println("" + key + ": " + "$" +  + breakDown.get(key));
        }



    }


    public static  void displayCartItem(ShoppingCart cart){

        System.out.println("==============Cart items=================");

        for(CartItem items: cart.getItems()){
            System.out.println(" " + "Name: " + items.getProduct().getName() +"\n"
                    +" Descriptions: " + items.getProduct().getDescription() +"\n"
                    + " price: "+ "$" + items.getProduct().getPrice() +"\n"
                    + " Qty: " + items.getQuantity() +"\n"
                    + " SubTotal: " + "$" +  items.subTotal());
        }

    }

    public  static  void updateGlobalRule(){
        GlobalSettings.setShipping_Update(7.0);
        GlobalSettings.setDiscountPercentage(0.0);
        GlobalSettings.setTaxPercentage(0.0);
        GlobalSettings.resetTaxPercentage();
        GlobalSettings.resetShippingDefault();
        GlobalSettings.resetDiscountToDefault();



    }


}
