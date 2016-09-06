/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ngoc
 */
public class Catalog implements Serializable{
    private List<Product> productList;
    public Catalog(){
        productList = new ArrayList<Product>();
    }

    public Catalog(List<Product> productList) {
        this.productList = productList;
    }
    
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    
    
}
