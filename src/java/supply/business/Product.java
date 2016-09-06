/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Ngoc
 */
public class Product implements Serializable{
    private Long productId;
    private String productName;
    private String code;
    private String description;
    private String brand;
    private String category;    
    private double price;

    public Product() {
         productName ="";
         code ="";
         description ="";
         brand ="";
         category ="";
         price =0.0;
    }

    public Product(Long productId, String productName, String code, String description, String brand, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getPriceCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
         
        return currency.format(price);
    }
    public String getURLImage(){
        String URLImage = "../../images/" + code +".jpg";
        return URLImage;
    }
            
            
    
}
