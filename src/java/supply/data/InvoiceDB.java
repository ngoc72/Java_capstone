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
import java.util.List;
import supply.business.Invoice;
import supply.business.LineItem;
import java.util.ArrayList;
import supply.business.User;

/**
 *
 * @author Ngoc
 */
public class InvoiceDB {

    public static void insert(Invoice invoice) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method adds a record to the Invoices table.
        //To insert the exact invoice date, the SQL NOW() function is used.
        String query = "INSERT INTO Invoice (UserId, InvoiceDate, TotalAmount, IsProcessed) "
                + "VALUES (?, NOW(), ?, 'n')";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, invoice.getUser().getUserId());
            ps.setDouble(2, invoice.getInvoiceTotal());
            ps.executeUpdate();

            //Get the InvoiceID from the last INSERT statement.
            String idQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement idStatement = connection.createStatement();
            ResultSet idResultSet = idStatement.executeQuery(idQuery);
            idResultSet.next();
            long invoiceID = idResultSet.getLong("IDENTITY");
            idResultSet.close();
            idStatement.close();

            //Write line items to the LineItem table.
            List<LineItem> lineItems = invoice.getLineItems();
            for (LineItem item : lineItems) {
                LineItemDB.insertLineItem(invoiceID, item);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePrepareStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Invoice> selectUnprocessedInvoices() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * "
                + "FROM User "
                + "INNER JOIN Invoice "
                + "ON User.UserID = Invoice.UserID "
                + "WHERE Invoice.IsProcessed = 'n' "
                + "ORDER BY InvoiceDate";

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Invoice> unprocessedInvoices = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user = UserDB.selectUser(rs.getString("Email"));
                Long invoiceId = rs.getLong("InvoiceId");
                List<LineItem> lineItems = new ArrayList<>();
                lineItems = LineItemDB.selectLineItems(invoiceId);
                Invoice invoice = new Invoice();
                invoice.setUser(user);
                invoice.setLineItems(lineItems);
                invoice.setInvoiceDate(rs.getDate("invoiceDate"));
                invoice.setInvoiceNumber(invoiceId);
                invoice.setIsProcessed(false);
                unprocessedInvoices.add(invoice);

            }
            return unprocessedInvoices;

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePrepareStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static void updateInvoice(Invoice invoice) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "UPDATE Invoice SET "
                + "IsProcessed = 'y' "
                + "WHERE InvoiceID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, invoice.getInvoiceNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePrepareStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Invoice> selectInvoice(Long userId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Invoice "
                + "WHERE userId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            ArrayList<Invoice> invoices = new ArrayList<>();
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceNumber(rs.getLong("invoiceId"));
                invoice.setInvoiceDate(rs.getDate("invoiceDate"));
                invoice.setIsProcessed(rs.getBoolean("isProcessed"));
                User user = new User();
                user = UserDB.selectUser(userId);
                invoice.setUser(user);
                //LineItem lineItem = new LineItem();
                long invoiceId = rs.getLong("invoiceId");
                List<LineItem> lineItems = LineItemDB.selectLineItems(invoiceId);
                invoice.setLineItems(lineItems);
                invoices.add(invoice);
                

            }
            return invoices;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }

    }
    public static Invoice selectInvoiceByInvoiceNumber(Long invoiceNumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Invoice "
                + "WHERE InvoiceId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1,invoiceNumber);
            rs = ps.executeQuery();
            Invoice invoice = new Invoice();
            if (rs.next()) {
                
                invoice.setInvoiceNumber(rs.getLong("invoiceId"));
                invoice.setInvoiceDate(rs.getDate("invoiceDate"));
                invoice.setIsProcessed(rs.getBoolean("isProcessed"));
                Long userId = rs.getLong("userId");
                
                User user = new User();
                user = UserDB.selectUser(userId);
                invoice.setUser(user);
                LineItem lineItem = new LineItem();
                long invoiceId = rs.getLong("invoiceId");
                List<LineItem> lineItems = LineItemDB.selectLineItems(invoiceId);
                invoice.setLineItems(lineItems);
                
            }
            return invoice;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closePrepareStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }

    }
}
