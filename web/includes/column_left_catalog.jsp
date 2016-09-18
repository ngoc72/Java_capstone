<%-- 
    Document   : column_left_catalog
    Created on : Aug 30, 2016, 9:33:01 PM
    Author     : Ngoc
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class=" container" >
                <p> <h1> Products </h1> </p>
                <c:forEach var = "item" items = "${products}">
                <a href ="${item.code}"> ${item.productName}<a> </br> 
                 </c:forEach>                   
 </div>