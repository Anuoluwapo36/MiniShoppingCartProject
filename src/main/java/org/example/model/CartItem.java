package org.example.model;

public class CartItem {
    private Product product;
    private int quantity;
    private double taxPercentage;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if(quantity < 1){
            throw new IllegalArgumentException("Quantity must be at least 1");
        }else {
            this.quantity = quantity;
        }
    }


    public double subTotal(){
         return product.getPrice() * quantity;
    }
}
