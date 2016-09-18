<%-- 
    Document   : change_password_notice
    Created on : Sep 14, 2016, 9:56:38 AM
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
                <p style="color:blue;"><h4> ${message}</h4><p>
            </div>
        </div>
            
</div>
  <c:import url="/includes/footer.jsp" />
