<%-- 
    Document   : invoice
    Created on : Aug 23, 2016, 11:36:29 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-2"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-10">
                <h1> Customer invoice</h1>

                <table class="table">
                  <tr>
                    <td><b>Date</b></td>
                    <td>${invoice.invoiceDate}</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td><b>Ship To</b></td>
                    <td>${invoice.user.getAddressFormat()}</td>
                    <td></td>
                  </tr>
                  <tr><td colspan="3"><hr></td></tr>
                  <tr>
                    <td><b>Qty</b></td>
                    <td><b>Description</b></td>
                    <td><b>Price</b></td>
                  </tr>

                  <c:forEach var="item" items="${invoice.lineItems}">
                  <tr>
                    <td>${item.quantity}</td>
                    <td>${item.product.description}</td>
                    <td>${item.totalCurrencyFormat}</td>
                  </tr>
                  </c:forEach>

                  <tr><td colspan="3"></td></tr>
                  <tr>
                    <td><b>Total</b></td>
                    <td></td>
                    <td><${invoice.invoiceTotalCurrencyFormat}</td>
                  </tr>      
                </table>

                <label>Payment information: </label>
                <span>${invoice.user.creditCardType}: ${invoice.user.creditCardNumber} 
                    (${invoice.user.creditCardExpirationDate})</span><br>
                <label>Email Address: </label>
                <span>${invoice.user.email}</span><br>
                
                    <div class="form-group">
                        <form action="<c:url value='/adminController/processInvoice'/>" method="post">


                            <input  type="submit" class="btn btn-default" value="Process Invoice">
                        </form>
                        <br>
                        <form action="displayInvoices" method="post">


                            <input type="submit" class="btn btn-default" value="View Unprocessed Invoices">
                        </form>
                    </div>
         </div>
     </div>
</div>           
<c:import url="/includes/footer.jsp" />
