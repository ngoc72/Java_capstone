/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supply.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import supply.business.Invoice;
import supply.business.User;
import supply.data.InvoiceDB;
import supply.data.UserDB;
import supply.util.PasswordUtil;

/**
 *
 * @author Ngoc
 */
public class LoginController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        if (requestURI.endsWith("updateAccount")) {
            url = updateAccount(request, response);
        } else if (requestURI.endsWith("viewOrders")) {
            url = viewOrders(request, response);
        } else if (requestURI.endsWith("viewOrder")) {
            url = viewOrder(request, response);
        } else if (requestURI.endsWith("changePassword")) {
            url = "/login/changePassword.jsp";
        } else if (requestURI.endsWith("userAccount")) {
            url = "/login/user_info.jsp";
        } else if (requestURI.endsWith("sign_out")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", null);
            url = "/catalog/product/";

        }//else if (requestURI.endsWith("changePassword")) {
        //    url = changePassword(request, response);
        // }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
        String url = "";
        String message;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("register")) {
            url = register(request, response);
        } else if (requestURI.endsWith("userInfo")) {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String hashPassword = "";
            try {
                hashPassword = PasswordUtil.hashPassword(pass);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
            }
            Boolean result = UserDB.emailExists(email, hashPassword);

            if (result) {
                User user = UserDB.selectUser(email);
                session.setAttribute("user", user);
                url = "/login/user_info.jsp";

            } else {

                message = "You did not login successfully, please try a gain";
                request.setAttribute("message", message);
                url = "/login/login_index.jsp";
                //response.sendRedirect("/login/login_index.jsp");
            }
        } else if (requestURI.endsWith("processUpdate")) {
            url = processUpdate(request, response);
        } else if (requestURI.endsWith("processChangePassword")) {
            url = processChangePassword(request, response);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    private String register(HttpServletRequest request, HttpServletResponse response) {
        String url;
        String message = "";
        HttpSession session = request.getSession();
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            message = "Your password is not correct, try again.";
            request.setAttribute("message", message);
            url = "/login/register.jsp";
        } else {
            String hashPassword = "";
            try {
                hashPassword = PasswordUtil.hashPassword(password);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
            }
            User user = new User();
            if (UserDB.emailExists(email, hashPassword)) {
                message = "This email address already exists. <br>"
                        + "Please enter another email address.";
                request.setAttribute("message", message);
                url = "/login/register.jsp";
            } else {
                user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);

                user.setPassword(hashPassword);
                UserDB.insertUser(user);
                url = "/login/user_info.jsp";
            }
            session.setAttribute("user", user);
        }
        return url;
    }

    private String updateAccount(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        User user = new User();
        user = UserDB.selectUser(email);
        session.setAttribute("user", user);
        return "/login/updateAccount.jsp";

    }

    private String processUpdate(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String companyName = request.getParameter("company");

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

        user = UserDB.selectUser(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        user.setCompanyName(companyName);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setCountry(country);
        UserDB.updateUser(user);

        return "/login/updateNotice.jsp";
    }

    private String processChangePassword(HttpServletRequest request, HttpServletResponse response) {
        String url = "/login/changePassword.jsp";
        String oldPassword = request.getParameter("oldPassword");

        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        // User user = new User();
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String hashPassword = user.getPassword();
        String oldHashPassword = "";
        String newHashPassword = "";
        String message;
        try {
            oldHashPassword = PasswordUtil.hashPassword(oldPassword);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        if (!oldHashPassword.equals(hashPassword)) {
            message = " Your old password is not correct, try a gain.";
        } else {
            if (!newPassword.equals(confirmPassword)) {
                message = " Your new password and confirm password are not the same, try again.";
            } else {
                try {
                    newHashPassword = PasswordUtil.hashPassword(newPassword);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println(ex);
                }

                UserDB.updateUser(newHashPassword, email);
                message = " Your password has changed successfully.";
                url = "/login/change_password_notice.jsp";
            }
        }
        request.setAttribute("message", message);
        session.setAttribute("user", user);
        return url;
    }

    private String viewOrders(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        User user = new User();
        user = UserDB.selectUser(email);
        long userId = user.getUserId();
        ArrayList<Invoice> invoices = new ArrayList<>();

        invoices = InvoiceDB.selectInvoice(userId);
        if (invoices != null) {
            if (invoices.size() <= 0) {
                invoices = null;
            }
        }
        session.setAttribute("invoices", invoices);

        return "/login/orders.jsp";
    }

    private String viewOrder(HttpServletRequest request, HttpServletResponse response) {
        String strInvoiceNumber = request.getParameter("invoiceNumber");
        Long invoiceNumber = Long.parseLong(strInvoiceNumber);
        Invoice invoice = new Invoice();
        invoice = InvoiceDB.selectInvoiceByInvoiceNumber(invoiceNumber);
        String status;
        if (invoice.isIsProcessed() == true) {
            status = " Your order was completed";
        } else {
            status = "Your order is being processed";
        }
        HttpSession session = request.getSession();
        session.setAttribute("invoice", invoice);
        session.setAttribute("status", status);

        return "/login/order.jsp";
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
