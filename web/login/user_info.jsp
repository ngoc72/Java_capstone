<%-- 
    Document   : login_info
    Created on : Aug 6, 2016, 2:26:34 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row">
         <div class="col-md-3">
             
         </div>
         <div class="col-md-9">
                <h3> Welcome to this site, here is your information</h3>
                <p><b>Your last name: </b> ${user.lastName} 
                    ${user.firstName}<br>
                <p><b>Your email: </b> ${user.email}</p>
         </div>
     </div>
</div>
     
   
    <c:import url="/includes/footer.jsp" />
