package org.example.model;

public class Product  {

    private String name;
    private double price;
    private String description;


    public Product( String name, double price, String description){
        this.name=name;
        this.price=price;
        this.description=description;
    }

    public  String  getName(){
        return this.name;
    }

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw  new IllegalArgumentException("product name required");
        }else{
            this.name=name;
        }
    }


    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("price required:please enter product price");
        }else{
            this.price=price;
        }
    }


    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("product description required");
        }else{
            this.description=description;
        }
    }
}
