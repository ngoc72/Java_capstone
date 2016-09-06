<%-- 
    Document   : login_error
    Created on : Aug 22, 2016, 9:25:26 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

     <div class="row">
         <div class="col-md-3">
         </div>
        <div class="col-md-9">
                <h3>Login Form - Error</h3>
               <p>You did not log in successfully.</p>
               <p>Please check your username and password and try again.</p>

               <form action="j_security_check" method="get">
                   <div class="form-group">
                       <label>Username</label>
                       <input type="text" name="j_username" class="form-control">
                   </div>
                   <div class="form-group">
                       <label>Password</label>
                       <input type="password" name="j_password" class="form-control">
                   </div>
                   <button type="submit" class="btn btn-default">Login</button>
               </form>
        </div>
    </div>
<c:import url="/includes/header.jsp" />
