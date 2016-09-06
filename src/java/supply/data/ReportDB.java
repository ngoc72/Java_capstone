/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supply.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Ngoc
 */
public class ReportDB {

    public static Workbook selectUsers() {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet(" Users Report ");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("USERS REPORT");
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("First Name");
        row.createCell(1).setCellValue("Last Name");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("Company");
        row.createCell(4).setCellValue("Address 1");
        row.createCell(5).setCellValue("City");
        row.createCell(6).setCellValue("State");
        row.createCell(7).setCellValue("Zip");
        row.createCell(8).setCellValue("Country");
        row.createCell(9).setCellValue("ID");
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM User ORDER BY FirstName";
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int i = 3;
            while (rs.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rs.getString("LastName"));
                row.createCell(1).setCellValue(rs.getString("FirstName"));
                row.createCell(2).setCellValue(rs.getString("Email"));
                row.createCell(3).setCellValue(rs.getString("Company"));
                row.createCell(4).setCellValue(rs.getString("Address1"));
                row.createCell(5).setCellValue(rs.getString("City"));
                row.createCell(6).setCellValue(rs.getString("State"));
                row.createCell(7).setCellValue(rs.getString("Zip"));
                row.createCell(8).setCellValue(rs.getString("Country"));
                row.createCell(9).setCellValue(rs.getString("UserId"));

                i++;

            }
            return workbook;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }

    }

    public static Workbook sellectOrders(String startDate, String endDate) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet(" Orders Report ");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("ORDERS REPORT");
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("Start date");
        row.createCell(1).setCellValue(startDate);
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("End date");
        row.createCell(1).setCellValue(endDate);
        row = sheet.createRow(3);
        row.createCell(0).setCellValue("Invoice Id");
        row.createCell(1).setCellValue("Total amount");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("First Name");
        row.createCell(4).setCellValue("Last Name");
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String query = "SELECT InvoiceId, TotalAmount, Email, FirstName, LastName "
                + "FROM Invoice INNER JOIN User ON Invoice.UserId = User.UserId "
                + "WHERE InvoiceDate >= '" + startDate + "' "
                + "   AND InvoiceDate <= '" + endDate + "' " 
                + "ORDER BY InvoiceDate DESC";

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int i = 4;
            while (rs.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rs.getInt("InvoiceId"));
                row.createCell(1).setCellValue(rs.getFloat("TotalAmount"));
                row.createCell(2).setCellValue(rs.getString("Email"));
                row.createCell(3).setCellValue(rs.getString("FirstName"));
                row.createCell(4).setCellValue(rs.getString("LastName"));
                i++;
            }
            return workbook;
        }catch (SQLException e) {
            System.err.println(e);
            return null;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
     
}
        
