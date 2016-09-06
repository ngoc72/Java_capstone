/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.business;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ngoc
 */
public class Cart implements Serializable{
    private List<LineItem> items;
    public Cart(){
        items = new ArrayList<>();
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }
    public int getCount(){
        return items.size();
    }
    public void addItem(LineItem item){
        
       String code = item.getProduct().getCode();
       int quantity = item.getQuantity();
       for(LineItem lineItem:items){
           if(lineItem.getProduct().getCode().equals(code))
           {
               lineItem.setQuantity(quantity);
               return;
           }
        }
        items.add(item);
    }
    public void removeItem(LineItem item){
        String code = item.getProduct().getCode();
        for(LineItem lineItem:items){
            if(lineItem.getProduct().getCode().equals(code)){
                items.remove(lineItem);
                return;
            }
        }
    }
    
}
