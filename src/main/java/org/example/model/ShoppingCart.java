package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem>  items;

    public ShoppingCart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item){
        items.add(item);
    }

    public void removeItem(CartItem item){
        items.remove(item);
    }

    public void clearCart(){
        items.clear();
    }
}
