<%-- 
    Document   : index
    Created on : Aug 5, 2016, 4:41:57 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3">
             <c:import url="/includes/column_left_login.jsp" /> 
         </div>
         <div class="col-md-9">
                <p><h4 color="red">${message}</h4></p>
                                 
                
                <form action="<c:url value='/LoginController/processChangePassword?email=${user.email}'/>" method="post">
                    <div class="form-group">
                        <label for="email"> Old password </label>
                        <input type ="password" class="form-control"  name ="oldPassword" placeholder="old password" required ><br>
                    </div>
                    <div class="form-group">
                        <label for="email"> Your New password </label>
                        <input type ="password" class="form-control"  name ="newPassword" placeholder="new password" required ><br>
                    </div>
                    <div class="form-group">
                        <label for="password"> Confirm new password: </label>
                        <input type = "password" class="form-control" placeholder="new password" name ="confirmPassword"  required><br>
                    </div>
                    
                    <button type="submit" class="btn btn-default"> CHANGE</button>
                </form> 
                    
                    
         </div>
     </div>
</div>                 
                
<c:import url="/includes/footer.jsp" />
