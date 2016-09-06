/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import supply.business.Invoice;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import supply.business.Product;
import supply.business.User;
import supply.data.InvoiceDB;
import supply.data.ProductDB;
import supply.data.ReportDB;
import supply.data.UserDB;

/**
 *
 * @author Ngoc
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin";//???
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/adminController/displayInvoice")){
            url = displayInvoice(request,response);
        }
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/admin";
        String requestURI = request.getRequestURI();
        if(requestURI.endsWith("/displayInvoices")){
            url = displayInvoices(request, response);
            
        }else if(requestURI.endsWith("/displayInvoice")){
            url = displayInvoice(request, response);
            
        }else if(requestURI.endsWith("/processInvoice")){
            url = processInvoice(request, response);
        }
        else if(requestURI.endsWith("/addProduct")){
             url = addProduct(request, response);
        }else if(requestURI.endsWith("/showProducts")){
             url = showProducts(request, response);
        }else if(requestURI.endsWith("/delete_updateProduct")){
             url = delete_updateProduct(request, response);
        }else if(requestURI.endsWith("/updateProduct")){
             url = updateProduct(request, response);
        }else if(requestURI.endsWith("/displayReport")){
              displayReport(request, response);
        }
        
        
        
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    private String displayInvoices(HttpServletRequest request, HttpServletResponse response){
        String url;
        
        List<Invoice> unprocessedInvoices = new ArrayList<>();
        unprocessedInvoices = InvoiceDB.selectUnprocessedInvoices();
        if (unprocessedInvoices != null) {
            if (unprocessedInvoices.size() <= 0) {
                unprocessedInvoices = null;
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("unprocessedInvoices",unprocessedInvoices);
        
        url = "/admin/invoices.jsp";
        return url;
    }
    private String displayInvoice(HttpServletRequest request, HttpServletResponse response){
        String url;
        String strInvoiceNumber = request.getParameter("invoiceNumber");
        int invoiceNumber = Integer.parseInt(strInvoiceNumber);
        HttpSession session = request.getSession();
        List<Invoice> unprocessedInvoices = (List<Invoice>)session.getAttribute("unprocessedInvoices");
        Invoice invoice = null;
        for(Invoice unprocessedInvoice:unprocessedInvoices){
            invoice = unprocessedInvoice;
            if(unprocessedInvoice.getInvoiceNumber()==invoiceNumber){
                
                break;
            }
            
        }
        session.setAttribute("invoice",invoice);
        url ="/admin/invoice.jsp";
        return url;
    }
    private String processInvoice(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Invoice invoice = (Invoice)session.getAttribute("invoice");
        
        InvoiceDB.updateInvoice(invoice);
        
                
        return "/adminController/displayInvoices";
        
    }
    
    private String addProduct(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String message ="";
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        Product product = new Product();
        product.setCode(productCode);
        product.setProductName(productName);
        product.setDescription(description);
        product.setBrand(brand);
        product.setCategory(category);
        product.setPrice(Double.parseDouble(price));
        ProductDB.insertProduct(product);
        if(product!=null){
             message =" This product has been added successfully";
              ArrayList<Product> products = new ArrayList<>();
            products = ProductDB.selectAllProducts();
             session.setAttribute("products", products);
            
        }else{
            message =" This product has not been added successfully ";
        }
       
        session.setAttribute("message",message);
        return "/admin/products.jsp";
               
    }
    private String showProducts(HttpServletRequest request, HttpServletResponse response){
       HttpSession session = request.getSession();
       ArrayList<Product> products = new ArrayList<>();
       products = ProductDB.selectAllProducts();
       session.setAttribute("products", products);
       
       return "/admin/products.jsp";
    }
     private String delete_updateProduct(HttpServletRequest request, HttpServletResponse response){
       String message ="";
         String productId = request.getParameter("productId");
       int intProductId =Integer.parseInt(productId);
       String action = request.getParameter("action");
       HttpSession session = request.getSession();
       if(action.equals("Delete")){
            
            ProductDB.deleteProduct(intProductId);
            message =" The product has been deleted successfully ";    
            ArrayList<Product> products = new ArrayList<>();
            products = ProductDB.selectAllProducts();
            session.setAttribute("products", products);
            session.setAttribute("message",message);
            return "/admin/products.jsp";
       }
       //action = update
       else{
           Product product = new Product();
           product = ProductDB.selectProduct(intProductId);
           session.setAttribute("product",product);
           return "/admin/update_product.jsp";
       }
    }
     private String updateProduct(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String message ="";
        String strProductId = request.getParameter("productId");
        Long productId = Long.parseLong(strProductId);
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        
        String strPrice = request.getParameter("price");
        Double price = Double.parseDouble(strPrice);
        Product product = new Product();
        product.setProductId(productId);
        
        product.setCode(productCode);
        product.setProductName(productName);
        product.setDescription(description);
        product.setBrand(brand);
        product.setCategory(category);
        product.setPrice(price);
        ProductDB.updateProduct(product);
        message =" The product has been updated successfully ";
        
        session.setAttribute("message",message);
        ArrayList<Product> products = new ArrayList<>();
        products = ProductDB.selectAllProducts();
        session.setAttribute("products", products);

        return "/admin/products.jsp";               
    }
    private void displayReport(HttpServletRequest request, HttpServletResponse response)throws IOException {
        
        
        String reportName = request.getParameter("reportName");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        Workbook workbook;
        if(reportName.equalsIgnoreCase("usersReport")){
            workbook = ReportDB.selectUsers();
            
        }else if(reportName.equalsIgnoreCase("ordersReport")){
            workbook = ReportDB.sellectOrders(startDate,endDate);
            
        }else {
            workbook = new HSSFWorkbook();
        }
        response.setHeader("content-disposition", 
                "attachment;filename=" +reportName+".xls");
        try (OutputStream out = response.getOutputStream()) {
            workbook.write(out);
        }
        
        
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
