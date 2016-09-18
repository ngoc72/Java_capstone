<%-- 
    Document   : login
    Created on : Aug 22, 2016, 8:08:10 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
    <div class="row content">
         <div class="col-md-3">
         </div>
        <div class="col-md-9">
            <h1>Admin Login Form</h1>
            <p>Please enter a username and password to continue.</p>
            <form action="j_security_check" method="post">
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
</div>      

    
</div>
<c:import url="/includes/footer.jsp" />
