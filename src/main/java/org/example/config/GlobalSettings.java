package org.example.config;

public class GlobalSettings {

    /**
     * tax constant
     */
    private static  final  double TAX_PERCENTAGE = 10.0;
    private static double taxPercentageUpdate = TAX_PERCENTAGE;

    /**
     * discount constant
     */
    private static  final  double  DISCOUNT_PERCENTAGE = 12.0;
    private static double  discountPercentage = DISCOUNT_PERCENTAGE;

    public static double getTaxPercentage() {
        return taxPercentageUpdate;
    }


    /**
     * shipping  constant
     */

    private static  final double SHIPPING_PERCENTAGE = 5.0;
    private static  double shipping_Update = SHIPPING_PERCENTAGE;




    /**
     * validating and updating the global rule of tax
     * @param taxPercentage
     */
    public static void setTaxPercentage(double taxPercentage) {
        if(taxPercentage < 0){
            throw new IllegalArgumentException("required tax percentage");
        }else{
            GlobalSettings.taxPercentageUpdate = taxPercentage;
        }
    }

    /**
     * rest back to the default global rule set for tax
     */
    public static void  resetTaxPercentage(){
        taxPercentageUpdate = TAX_PERCENTAGE;
        System.out.println("tax reset to default");

    }


    /**
     * policy rule for discount price
     */


    public static double getDiscountPercentage(){
        return discountPercentage ;
    }

    /**
     * this allows updating the default global rule for discount,
     * and it takes new value assign to it
     * to reset back to default global policy
     * use resetDiscountToDefault() method below
     * @param discountPercentage
     */
    public static  void setDiscountPercentage(double discountPercentage){
        if(discountPercentage < 0){
            throw new IllegalArgumentException("No discount apply yet");
        }else {
            GlobalSettings.discountPercentage=discountPercentage;
        }
    }

    /**
     * fallback to default of discount global rule policy
     */
    public static  void  resetDiscountToDefault(){
        discountPercentage = DISCOUNT_PERCENTAGE;
        System.out.println("discount reset back to factory default");
    }

    /**
     * getter for shipping percentage
     * @return
     */

    public static double getShipping_Update() {
        return shipping_Update;
    }

    /**
     * updating shipping percentage
     * @param shipping_Update
     */
    public static void setShipping_Update(double shipping_Update) {
        if(shipping_Update < 0){
            throw new IllegalArgumentException(" shipping percentage required");
        }else {
            GlobalSettings.shipping_Update = shipping_Update;
        }
    }

    /**
     * resting back to default rule of shipping percentage
     */
    public static  void  resetShippingDefault(){
        shipping_Update = SHIPPING_PERCENTAGE;
        System.out.println("shipping reset to default");

    }
}
