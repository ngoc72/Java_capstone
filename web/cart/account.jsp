<%-- 
    Document   : account
    Created on : Sep 17, 2016, 7:16:06 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-2">
             
         </div>
         <div class =" col-md-8">
             <h4> To continue, you either login if you have an account or register for an account </h4>
             <form action="<c:url value='/login/login_index.jsp' />" method="post">                
                        <button type="submit" class="btn btn-default"> LOGIN</button>
             </form> <br>
             <form action="<c:url value='/login/register.jsp' />" method="post">                
                        <button type="submit" class="btn btn-default"> REGISTER </button>
            </form>
         </div>
     </div>
</div>   
        
<c:import url="/includes/footer.jsp" />