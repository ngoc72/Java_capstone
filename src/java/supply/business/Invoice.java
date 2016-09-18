/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ngoc
 */
public class Invoice implements Serializable{
    private Long invoiceNumber;
    private Date invoiceDate;
    private User user;
    private List<LineItem> lineItems;
    private boolean isProcessed;

    public Invoice() {
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }
    public String getInvoiceDateFormat(){
        DateFormat dateFormat = DateFormat.getDateInstance();
        String invoiceDateFormatted = dateFormat.format(invoiceDate);
        return invoiceDateFormatted;
    }
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public boolean isIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    
    public Double getInvoiceTotal(){
        Double invoiceTotal = 0.0;
        for(LineItem lineItem:lineItems){
            invoiceTotal = invoiceTotal + lineItem.getTotal();
        }
        return invoiceTotal;
        
    }
    public String getInvoiceTotalCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(this.getInvoiceTotal());
        return formattedTotal;
         
    }    
   
}
