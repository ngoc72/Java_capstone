<%-- 
    Document   : index
    Created on : Aug 5, 2016, 4:41:57 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

     <div class="row">
         <div class="col-md-3">
             
         </div>
         <div class="col-md-9">
                <p><h3 color="red">${message}</h3></p>
                <h1> User Login Form </h1><br>                    
                <b> Enter your email and your password </b>
                <form action="<c:url value='/LoginController'/>" method="post">
                    <div class="form-group">
                        <label for="email"> Email: </label>
                        <input type ="email" class="form-control"  name ="email" placeholder="Enter email" required ><br>
                    </div>
                    <div class="form-group">
                        <label for="password"> Password: </label>
                        <input type = "password" class="form-control" placeholder="Enter password" name ="password"  required><br>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox"> Remember me</label>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                  
                  <form action="<c:url value='/login/register.jsp' />" method="post">                
                        <button type="submit" class="btn btn-default"> Create Account</button>
                   </form>
                    <!--<a href = "/beauty_supply/login/register.jsp">CREATE ACCOUNT </a>-->
                    
         </div>
     </div>
                   
                
<c:import url="/includes/footer.jsp" />
