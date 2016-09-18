<%-- 
    Document   : column_left_login
    Created on : Sep 6, 2016, 10:48:39 PM
    Author     : Ngoc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
<div class="container">
<br>
    <li><a href="updateAccount?email=${user.email}"> Update your account </a></li>
    <li><a href="changePassword"> Change password </a></li>
    <li><a href="viewOrders?email=${user.email}">View your orders</a></li>
    <!--<li class="active"><a href="<c:url value='/catalog/product/'/>"> Sign out </a></li> -->
    <li class="active"><a href="<c:url value='/LoginController/sign_out'/>"> Sign out </a></li>
</div>
</aside>