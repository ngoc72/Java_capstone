<%-- 
    Document   : order
    Created on : Sep 7, 2016, 10:49:24 AM
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
             
             <h4> Invoice info: </h4>
             <table class="table">
                 <tr>
                     <td><b> Invoice number: </b></td>
                     <td> ${invoice.invoiceNumber}</td>
                     <td></td>
                 </tr>
                  <tr>
                    <td><b>Date: </b></td>
                    <td>${invoice.invoiceDate}</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td><b>Ship To: </b></td>
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

                  <tr><td colspan="3"><hr></td></tr>
                  <tr>
                    <td><b>Total</b></td>
                    <td></td>
                    <td>${invoice.invoiceTotalCurrencyFormat}</td>
                  </tr>      
                </table>

                <label>Payment information: </label>
                <span>${invoice.user.creditCardType}: ${invoice.user.creditCardNumber} 
                    (${invoice.user.creditCardExpirationDate})</span><br>
                <label>Email Address: </label>
                <span>${invoice.user.email}</span><br>
                <label> Status: </label>
                <span style="color: blue">${status}</span><br>
                 
         </div>
         
     </div>
</div>
     
   
    <c:import url="/includes/footer.jsp" />
