/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.data;

import supply.business.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import supply.business.Product;



/**
 *
 * @author Ngoc
 */
public class LineItemDB {
    public static long insertLineItem(Long invoiceId, LineItem lineItem){
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "insert into lineitem" 
            + "(ProductId,Quantity, InvoiceId)"
            + "values(?, ?, ?)" ;
    try{
        ps = connection.prepareStatement(query);
        ps.setLong(1,lineItem.getProduct().getProductId());
        ps.setInt(2,lineItem.getQuantity());
        ps.setLong(3,invoiceId);
        return ps.executeUpdate();
    
    }catch (SQLException e) {
            System.err.println(e);
            return 0;
    }finally{
        DBUtil.closeResultSet(rs);
        DBUtil.closePrepareStatement(ps);
        pool.freeConnection(connection);
    }
    
}
    public static List<LineItem> selectLineItems(long invoiceId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM LineItem "
                + "WHERE InvoiceID = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setLong(1, invoiceId);
            rs = ps.executeQuery();
            List<LineItem> lineItems = new ArrayList<>();
            while (rs.next()){
                LineItem lineItem = new LineItem();
                int productId = rs.getInt("productId");
                Product product = ProductDB.selectProduct(productId);
                int quantity = rs.getInt("quantity");
                lineItem.setProduct(product);
                lineItem.setQuantity(quantity);
                
                lineItems.add(lineItem);
               
            }
            return lineItems;
        }catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePrepareStatement(ps);
            pool.freeConnection(connection);
        }
        
        
    }
    
}
