/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import supply.business.Cart;
import supply.data.ProductDB;
import supply.business.Product;
import supply.business.LineItem;
import supply.business.User;
import supply.business.Invoice;
import supply.data.UserDB;
import supply.util.CookieUtil;
import supply.data.InvoiceDB;

/**
 *
 * @author Ngoc
 */
public class OrderController extends HttpServlet {
    private static final String defaultURL = "/cart/cart.jsp";
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
            out.println("<title>Servlet OrderController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
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
        String url = "";
        
        if (requestURI.endsWith("/showCart")){
            url= showCart(request,response);
            
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }
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
            String url = defaultURL;
            String requestURI = request.getRequestURI();
            if(requestURI.endsWith("/addItem")){
                addItem(request,response);
            }
            else if (requestURI.endsWith("/updateItem")){
                updateItem(request,response);
            }
            else if (requestURI.endsWith("/removeItem")){
                removeItem(request,response);
            }
            else if (requestURI.endsWith("/checkUser")){
                url = checkUser(request,response);
            }
            else if (requestURI.endsWith("/processUser")){
                url = processUser(request, response);
            } else if (requestURI.endsWith("/displayInvoice")) {
            url = displayInvoice(request, response);
            } else if (requestURI.endsWith("/displayUser")) {
            url = "/cart/user.jsp";
            } else if (requestURI.endsWith("/displayCreditCart")) {
                    url = "/cart/credit_cart.jsp";
            }else if (requestURI.endsWith("/completeOrder")){
                url = completeOrder(request,response);                    
            }
        
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request,response);
            
            
        
          
    }
    public String showCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");  
        String url = defaultURL;
        if(cart == null || cart.getCount() == 0){
            request.setAttribute("emtyCart","Your cart is empty");
            
        }else{
            session.setAttribute("cart",cart);
        }
        return url;
    }
    public String addItem(HttpServletRequest request, HttpServletResponse response ){
        
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        String productCode = request.getParameter("productCode");
        Product product = ProductDB.selectProduct(productCode);
        if (product != null){
            LineItem lineItem =  new LineItem();
            lineItem.setProduct(product);
            cart.addItem(lineItem);
        }
        session.setAttribute("cart", cart);
        return defaultURL;
        
        
    }
    public String updateItem(HttpServletRequest request, HttpServletResponse response){
       
        String productCode;
        String strQuantity = request.getParameter("quantity");
        productCode = request.getParameter("productCode");
        LineItem lineItem = new LineItem();
        int quantity;
        try{
            quantity = Integer.parseInt(strQuantity);
            if(quantity < 1){
                quantity = 1;
            }
            
        }catch(NumberFormatException e){
             quantity = 1;
                }
        lineItem.setQuantity(quantity);
        Product product = ProductDB.selectProduct(productCode);
        lineItem.setProduct(product);
        
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        cart.addItem(lineItem);
       session.setAttribute("cart", cart);
        
                
        
        return defaultURL;
        
    }
    public String removeItem(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        String productCode = request.getParameter("productCode");
        
        Product product = ProductDB.selectProduct(productCode);
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        
        cart.removeItem(lineItem);
        
        return defaultURL;
    }
    public String checkUser(HttpServletRequest request, HttpServletResponse response){
       
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String url = "/cart/user.jsp";
       
        if (user != null && !user.getAddress1().equals("")) {
            url = "/order/displayInvoice";
        } else {  // otherwise, check the email cookie
            Cookie[] cookies = request.getCookies();
            String email
                    = CookieUtil.getCookieValue(cookies, "emailCookie");
            if (email.equals("")) {
                user = new User();
                url = "/cart/user.jsp";
            } else {
                user = UserDB.selectUser(email);
                if (user != null && !user.getAddress1().equals("")) {
                    url = "/order/displayInvoice";
                }
            }
        }
        session.setAttribute("user", user);
        return url;
            
       
    }
    public String processUser(HttpServletRequest request, HttpServletResponse response){
         String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String companyName = request.getParameter("company");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
        }

        if (UserDB.emailExists(email,password)) {
            user = UserDB.selectUser(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setCompanyName(companyName);
            user.setAddress1(address1);
            user.setAddress2(address2);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            user.setCountry(country);            
            UserDB.updateUser(user);
        } else {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setCompanyName(companyName);
            user.setAddress1(address1);
            user.setAddress2(address2);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            user.setCountry(country);
            UserDB.insertUser(user);
        }

        session.setAttribute("user", user);

        return "/order/displayInvoice";
    }
    public String displayInvoice(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");
        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setLineItems(cart.getItems());
        java.util.Date today = new java.util.Date();
        invoice.setInvoiceDate(today);
        
        session.setAttribute("invoice",invoice);
        return "/cart/invoice.jsp";
        
    }
   
    
    public String completeOrder(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Invoice invoice = (Invoice)session.getAttribute("invoice");
        String creditCartType = request.getParameter("creditCartType");
        String creditCartNumber = request.getParameter("creditCartNumber");
        String creditCartExpirationMonth = request.getParameter("creditCartExpirationMonth");
        String creditCartExpirationyear = request.getParameter("creditCartExpirationYear");
        String creditCartExpitationDate = creditCartExpirationMonth +"/" + creditCartExpirationyear;
        User user = invoice.getUser();
        user.setCreditCardType(creditCartType);
        user.setCreditCardNumber(creditCartNumber);
        user.setCreditCardExpirationDate(creditCartExpitationDate);
        
        if (UserDB.emailExists(user.getEmail(),user.getPassword())) {
            UserDB.updateUser(user);
        } else { // otherwise, write a new record for the user            
            UserDB.insertUser(user);
        }        
        invoice.setUser(user);
        
        // write a new invoice record
        InvoiceDB.insert(invoice);
        
        // set the emailCookie in the user's browser.
        Cookie emailCookie = new Cookie("emailCookie",
                user.getEmail());
        emailCookie.setMaxAge(60*24*365*2*60);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);

        // remove all items from the user's cart
        session.setAttribute("cart", null);
        
      return "/cart/complete.jsp" ; 
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
