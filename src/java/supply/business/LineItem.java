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
public class LineItem implements Serializable{
    private Long lineItemId;
    private Product product;
    private int quantity = 1;

    public LineItem() {
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
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
        this.quantity = quantity;
    }
    
    public Double getTotal(){
        Double total = product.getPrice()*quantity;
    return total;
    }
    public String getTotalCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
        
    }
    
    
}
