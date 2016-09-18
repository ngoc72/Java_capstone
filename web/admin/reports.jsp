<%-- 
    Document   : reports
    Created on : Aug 23, 2016, 11:36:56 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-9">
            <h1> REPORT LIST</h1>
            <p> List of available reports </p>

            <form action = "parameters.jsp">
                <input type="hidden" name ="reportName" value ="ordersReport">
                <input type ="hidden" name ="reportTitle" value = " The Orders report">
                <input type="submit" value ="Orders Report">
            </form>
            <form action = "<c:url value="/adminController/displayReport"/>" method="post">
                <input type="hidden" name ="reportName" value ="usersReport">
                <input type ="hidden" name ="reportTitle" value = " The Users report">
                <input type="submit"  value ="Users Report">

            </form>
         </div>
     </div>
</div>            

<c:import url="/includes/footer.jsp" />
