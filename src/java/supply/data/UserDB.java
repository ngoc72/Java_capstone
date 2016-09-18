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
import supply.business.User;

/**
 *
 * @author Ngoc
 */
public class UserDB {
    public static User selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getLong("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setCompanyName(rs.getString("Company"));
                user.setAddress1(rs.getString("Address1"));
                user.setAddress2(rs.getString("Address2"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZip(rs.getString("Zip"));
                user.setCountry(rs.getString("country"));
                user.setCreditCardType(rs.getString("CreditCardType"));
                user.setCreditCardNumber(rs.getString("CreditCardNumber"));
                user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));
                 
            }
                        
        return user;
        }catch(SQLException sqle){
            System.err.println(sqle);
            return null;
        }finally{
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
        }
    }
    
    
    
    public static void insertUser(User user){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into User (FirstName, LastName, Email, Password,"
        + "Company, Address1, Address2, City, State, Zip, Country, "
        + "CreditCardType, CreditCardNumber,CreditCardExpirationDate)"
        + "values(?, ?, ?, ?,"
        + "?, ?, ?, ?, ?, ?, ?,"
        + "?, ?, ? )";
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getCompanyName());
            ps.setString(6, user.getAddress1());
            ps.setString(7, user.getAddress2());
            ps.setString(8, user.getCity());
            ps.setString(9, user.getState()); 
            ps.setString(10, user.getZip());
            ps.setString(11, user.getCountry());
           
            ps.setString(12, user.getCreditCardType());
            ps.setString(13, user.getCreditCardNumber());
            ps.setString(14, user.getCreditCardExpirationDate());
            ps.executeUpdate();
            //Get the user ID from the last INSERT statement.
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            long userId = identityResultSet.getLong("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            // Set the user ID in the User object
            user.setUserId(userId);
            
        }catch (SQLException e) {
            System.err.println(e);
            
        }finally{
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
        }
        
    }
    public static void updateUser(User user){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE User SET "
                + "FirstName = ?, "
                + "LastName = ?, "
                + "Company = ?, "
                + "Address1 = ?, "
                + "Address2 = ?, "
                + "City = ?, "
                + "State = ?, "
                + "Zip = ?, "
                + "Country = ?, "
                + "CreditCardType = ?, "
                + "CreditCardNumber = ?, "
                + "CreditCardExpirationDate = ? "
                + "WHERE Email = ? and Password = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getCompanyName());
            ps.setString(4, user.getAddress1());
            ps.setString(5, user.getAddress2());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getState()); 
            ps.setString(8, user.getZip());
            ps.setString(9, user.getCountry());           
            ps.setString(10, user.getCreditCardType());
            ps.setString(11, user.getCreditCardNumber());
            ps.setString(12, user.getCreditCardExpirationDate());
            ps.setString(13, user.getEmail());
            ps.setString(14, user.getPassword());
            ps.executeUpdate();
            
        }catch (SQLException e) {
            System.err.println(e);
            
        }finally{
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
        }
        
    }
    public static void updateUser(String password, String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "UPDATE User SET "
                + "password= ? "                
                + "WHERE Email = ? ";
        try{
            ps = connection.prepareStatement(query);
           
            
            ps.setString(1,password);
            ps.setString(2,email);
            ps.executeUpdate();
            
        }catch (SQLException e) {
            System.err.println(e);
            
            
        }finally{
            pool.freeConnection(connection);
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
        }
        
    }
    
    public static boolean emailExists(String email, String pass) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM User "
                + "WHERE Email = ? and Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePrepareStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static User selectUser(long userId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * from User "
                + "WHERE userId =?";
        try{
            ps = connection.prepareStatement(query);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            User user = null;
            if(rs.next()){
                user = new User();
                 user.setUserId(rs.getLong("UserId"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setCompanyName(rs.getString("Company"));
                user.setAddress1(rs.getString("Address1"));
                user.setAddress2(rs.getString("Address2"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZip(rs.getString("Zip"));
                user.setCountry(rs.getString("country"));
                user.setCreditCardType(rs.getString("CreditCardType"));
                user.setCreditCardNumber(rs.getString("CreditCardNumber"));
                user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));
            }
            return user;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }finally{
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
        
    }
    
}
