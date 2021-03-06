/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supply.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import supply.business.Catalog;
import supply.business.Product;
import supply.data.ProductDB;

/**
 *
 * @author Ngoc
 */
public class CatalogController extends HttpServlet {

    private Catalog catalog;

    /**
     *
     * @throws ServletException
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
            out.println("<title>Servlet CatalogController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CatalogController at " + request.getContextPath() + "</h1>");
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
        String requestURI = request.getRequestURI();
        String url;
        HttpSession session = request.getSession();
        if (requestURI.endsWith("/"))
            {
            ArrayList<Product> products =  ProductDB.selectAllProducts();

            session.setAttribute("products", products);
            url = "/catalog.jsp";
            
            }
        else 
            {
            url = showProduct(request,response);
            
            }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    private String showProduct(HttpServletRequest request,HttpServletResponse response){
        String url;
        String productCode = request.getPathInfo();
        HttpSession session = request.getSession();
        ArrayList<Product> products = new ArrayList<>();
        products = (ArrayList<Product>)session.getAttribute("products");
        session.setAttribute("products", products);
        if (productCode != "") {
            productCode = productCode.substring(1);
            Product product = ProductDB.selectProduct(productCode);
            
            session.setAttribute("product", product);
            

            
        }        
        return "/displayProduct.jsp";
        
    
    }
    

}
