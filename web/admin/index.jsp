<%-- 
    Document   : index
    Created on : Aug 22, 2016, 9:40:39 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

    <div class="row">
         <div class="col-md-3">
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
        <div class='col-md-9'>
                <h1>Admin menu</h1>
                <form action="<c:url value='/adminController/displayInvoices'/>" method="post">
                    <button class="btn btn-default" type ="submit"> Process Invoices</button>
                </form>
                <form action="reports.jsp">
                    <button class="btn btn-default" type ="submit"> Display Reports</button>
                    
                </form>
                <form action="<c:url value='/adminController/showProducts'/>" method="post">
                    <button class="btn btn-default" type ="submit"> Products Management</button>
                    
                </form>
            </div>
             
    </div>
          
 

   <c:import url="/includes/footer.jsp" />
