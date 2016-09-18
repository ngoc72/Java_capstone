/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supply.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import supply.business.Product;

/**
 *
 * @author Ngoc
 */
public class ProductDB {

    public static Product selectProduct(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getLong("ProductId"));
                p.setCode(rs.getString("ProductCode"));
                p.setBrand(rs.getString("Brand"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("Price"));
                p.setDescription(rs.getString("Description"));
                p.setCategory(rs.getString("Category"));

                return p;

            } else {
                return null;
            }

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;

        } finally {
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
        }
    }

    public static Product selectProduct(int productId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from Product where ProductId = ?";
        try {
            ps = connection.prepareStatement(query);
            String strProductId = Integer.toString(productId);
            ps.setString(1, strProductId);// 
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getLong("ProductId"));
                p.setCode(rs.getString("ProductCode"));
                p.setBrand(rs.getString("Brand"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("Price"));
                p.setDescription(rs.getString("Description"));
                p.setCategory(rs.getString("Category"));

                return p;

            } else {
                return null;

            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        } finally {
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);

        }
    }

    public static ArrayList<Product> selectAllProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from Product";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getLong("ProductId"));
                p.setCode(rs.getString("ProductCode"));
                p.setBrand(rs.getString("Brand"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("Price"));
                p.setDescription(rs.getString("Description"));
                p.setCategory(rs.getString("Category"));
                products.add(p);

            }
            return products;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        } finally {
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);

        }
    }
    public static void insertProduct(Product product){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO Product" +
                "(ProductName,ProductCode,Description,Brand,Category,Price)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            
            ps = connection.prepareStatement(query);
            ps.setString(1,product.getProductName());
            ps.setString(2,product.getCode());
            ps.setString(3,product.getDescription());
            ps.setString(4,product.getBrand());
            ps.setString(5,product.getCategory());
            ps.setString(6,(Double.toString(product.getPrice())));
            ps.executeUpdate();
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            long productId = identityResultSet.getLong("IDENTITY");
            product.setProductId(productId);
            identityResultSet.close();
            identityStatement.close();
            
        }catch(SQLException e){
            System.err.println(e);
            
        }finally{
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            
        }
    }
        public static void updateProduct(Product product){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE Product SET "                
               +"ProductCode =?,"
               +"ProductName=?,"
               +"Description=?,"
               +"Brand=?,"
               +"Category=?,"
               +"Price=? "
               +"WHERE productId =?";
        try{
            ps = connection.prepareStatement(query); 
           
            ps.setString(1,product.getCode());
            ps.setString(2,product.getProductName());
            ps.setString(3,product.getDescription());
            ps.setString(4,product.getBrand());
            ps.setString(5,product.getCategory());
            Double dPrice = product.getPrice();
            ps.setString(6,dPrice.toString());
            Long lProductId = product.getProductId();
            String strProductId = lProductId.toString();
            int intProductId = Integer.parseInt(strProductId);
            ps.setInt(7,intProductId);
            ps.executeUpdate();
        }catch (SQLException sqle) {
            System.err.println(sqle);
            
        } finally {
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            

        }
        }
  public static void deleteProduct(int productId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
       
        String query = "DELETE FROM Product WHERE ProductId = ?";
        try {
            ps = connection.prepareStatement(query);
            String strProductId = Integer.toString(productId);
            ps.setString(1,strProductId );
            ps.executeUpdate();
            

            
        } catch (SQLException sqle) {
            System.err.println(sqle);
            
        } finally {
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
           

        }
            
        }
    
}
