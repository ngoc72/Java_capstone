<%-- 
    Document   : invoice
    Created on : Aug 15, 2016, 12:49:21 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row">
         <div class="col-md-2">
             
         </div>
         <div class="col-md-10">
                <h1>Your invoice</h1>
                <table class="table">
                    <tr>
                        <th> Date </th> <td>  ${invoice.getInvoiceDateFormat()}</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th> Ship to: </th> <td>${invoice.user.getAddressFormat()}</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th> Quantity </th>
                        <th> Description </th>
                        <th> <b> Price </th>
                    </tr>
                    <c:forEach var ="item" items = "${invoice.lineItems}">
                        <tr>
                            <td> ${item.quantity}</td>
                            <td> ${item.product.description}</td>
                            <td> ${item.getTotalCurrencyFormat()}</td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <th colspan="2"> Total:</th>
                        <td> ${invoice.getInvoiceTotalCurrencyFormat()}</td>
                    </tr>
                </table>

                 <form action ="<c:url value ='/order/displayUser'/>" method ="post" />
                     <input type = "submit" value ="Edit address"/>
                </form>  
                <form action ="<c:url value ='/order/displayCreditCart'/>" method ="post" />
                     <input type = "submit" value ="Continue"/>
                </form>
         </div>
    </div>
</div>
   <c:import url="/includes/footer.jsp" />
