/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import supply.business.User;
import supply.data.UserDB;
import supply.util.MailUtilLocal;
import supply.util.PasswordUtil;

/**
 *
 * @author Ngoc
 */
public class RegistrationController extends HttpServlet {

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
            out.println("<title>Servlet RegistrationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String url;
        String message = "";
        HttpSession session = request.getSession();
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
       
        if (!password.equals(confirmPassword)){
            message ="Your password is not correct, try again.";
            request.setAttribute("message", message);
             url = "/login/register.jsp";
        }else{
            String hashPassword = "";
            try{
                hashPassword = PasswordUtil.hashPassword(password);
            }catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
            }
            User user = new User();
            if (UserDB.emailExists(email,hashPassword)) {            
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
                
               /* String to = email;
                String from = "hoangthithanhngoc@yahoo.com";
                String subject = "Welcome to Starlight Nail & beauty Suply";
                String body = "Dear" + firstName + ",\n\n"
                        + "Thanks for your registration, we'll make sure to send you "
                        + "announcements about new products and promotions. \n"
                        + "Have a great day and thanks again! \n\n"
                        + " Ngoc Hoang \n"
                        + "Starlight Nail & Beauty supply";
                boolean isBodyHTML = false;
                try{
                  // MailUtilYahoo.sendMail(to, from, subject, body, isBodyHTML);
                   MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                }catch(MessagingException e){
                    String errorMessage = "ERROR: Unnable to send email. ";
                    request.setAttribute("errorMessage", errorMessage);
                    this.log(
                            "Unable to send email. \n"
                            + "Here is the email you tried to send: \n"
                            + "=====================================\n"
                            + "TO: " + email + "\n"
                            + "FROM: " + from + "\n"
                            + "SUBJECT: " + subject + "\n"
                            + "\n"
                            + body + "\n\n");
                }*/
            
            url ="/login/user_info.jsp";
        }
        
       // request.setAttribute("message", message);
        session.setAttribute("user", user);

        Cookie emailCookie = new Cookie("emailCookie", email);
        emailCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
        }
        
        
       
       
       request.getServletContext()
               .getRequestDispatcher(url)
               .forward(request, response);
       
       
    
   
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
