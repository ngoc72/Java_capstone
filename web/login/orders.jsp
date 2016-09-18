<%-- 
    Document   : orders
    Created on : Sep 7, 2016, 10:36:12 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3">
                
                 <c:import url="/includes/column_left_login.jsp" />
             
         </div>
         <div class="col-md-6">
             <c:if test = "${invoices == null}">
                 <p style="color:blue;"> <h4>You have no order </h4></p>

                </c:if>
             
             <c:if test="${invoices != null}">       
             <h4> Your orders </h4>
                    <table class="table">
                        <tr>
                            <td> <b>Invoice number</b></td>
                            <td> <b> Invoice date </b></td>
                            <td></td>
                        </tr>

                       <c:forEach var = "invoice" items = "${invoices}">
                           <tr>
                               <td> ${invoice.invoiceNumber}</td>
                               <td>${invoice.getInvoiceDateFormat()}</td>
                               <td><a href ="viewOrder?invoiceNumber=${invoice.invoiceNumber}"> Click to view </a></td>
                           </tr> 

                       </c:forEach>
                     </table>
            </c:if>
         </div>
                 
         <div class="col-md-3">
        </div>
     </div>
 
</div>
   
    <c:import url="/includes/footer.jsp" />
