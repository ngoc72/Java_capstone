<%-- 
    Document   : cart
    Created on : Aug 12, 2016, 10:22:34 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row">
         <div class="col-md-2">
             
         </div>
         <div class="col-md-10">
                <h1>Your cart</h1>
                <c:choose>
                    <c:when test = "${emtyCart != null}">
                        <p>Your cart is empty.</p>
                    </c:when>
                    <c:otherwise>
                        <table class="table">
                            <tr>
                                <th>Qty</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Amount</th>
                                <th>&nbsp;</th>
                            </tr>
                            <c:forEach var="item" items="${cart.items}">
                                <tr >
                                    <td>
                                        <form action="<c:url value='/order/updateItem'/>" method="post">
                                            <input type="hidden" name="productCode" 
                                                   value="<c:out value='${item.product.code}'/>">
                                            <input type=text name="quantity" 
                                                   value="<c:out value='${item.quantity}'/>" id="quantity">
                                            <input type="submit" value="Update">
                                        </form>                  
                                    </td>
                                    <td>${item.product.description}</td>
                                    <td>${item.product.priceCurrencyFormat}</td>
                                    <td>${item.totalCurrencyFormat}</td>
                                    <td>
                                        <form action="<c:url value='/order/removeItem'/>" method="post">
                                            <input type="hidden" name="productCode" 
                                                   value="<c:out value='${item.product.code}'/>">
                                            <input type="submit" value="Remove">
                                        </form>                  
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="2">
                                    <p><b>To change the quantity for an item</b>, enter the new quantity 
                                        and click on the Update button.</p>
                                    <p><b>To remove an item</b>, click on the Remove button.</p>
                                </td>
                                <td colspan="3">&nbsp;</td>
                            </tr>
                        </table>
                    </c:otherwise>
                </c:choose>
                <form  action="<c:url value='/catalog/product/'/>" method="get" >
                    <button type="submit" class="btn btn-default"> Continue Shopping</button>
                    <!--<input type="submit" value="Continue Shopping">-->
                </form>
                <c:if test="${emptyCart == null}">

                    <form action="<c:url value='/order/checkUser'/>" method="post">
                        <button type="submit" class="btn btn-default">Checkout</button>
                        <!--<input type="submit" value="Checkout">-->
                    </form>
                </c:if>
            </div>
    </div>
</div>                 
    <c:import url="/includes/footer.jsp" />
