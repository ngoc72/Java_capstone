<%-- 
    Document   : displayInvoices
    Created on : Aug 22, 2016, 2:07:21 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-2"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-8">
                <c:if test = "${unprocessedInvoices == null}">
                    <p> There are no invoice to process</p>

                </c:if>
                <c:if test ="${unprocessedInvoices != null}">
                    <h1> Invoices to be processed</h1>
                    <table class="table">
                        <tr>
                            <td><b>Customer Name</b></td>
                            <td><b>Invoice Date</b></td>
                            <td></td>
                            
                        </tr>

                        <c:forEach var="invoice" items="${unprocessedInvoices}">
                            <tr>
                               <td>${invoice.user.firstName} ${invoice.user.lastName}</td>
                              <td>${invoice.getInvoiceDateFormat()}</td>
                                
                              <td>
                                <a href="displayInvoice?invoiceNumber=${invoice.invoiceNumber}">Click to View</a>
                              </td>
                              
                            <tr>
                         </c:forEach>
                    </table>

                </c:if>
                    
         </div>
         <div class="col-md-2">
             
         </div>
     </div>
                     
</div>
        
    <c:import url="/includes/footer.jsp" />