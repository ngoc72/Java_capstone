<%-- 
    Document   : complete
    Created on : Aug 16, 2016, 12:23:41 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row">
         <div class="col-md-2">
             
         </div>
         <div class="col-md-10">
         
                <h1>Thank you, ${user.firstName}</h1>
                 <p>Your order has been submitted. We'll begin processing your 
                 order right away. If you have any questions about your order, 
                 please feel free to contact us  
                 <a href = "<c:url value = '/contact.jsp'/>"> Contact us </a>
        </div>
    </div>
</div>
        
   <c:import url="/includes/footer.jsp" />
