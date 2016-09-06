<%-- 
    Document   : column_left_catalog
    Created on : Aug 30, 2016, 9:33:01 PM
    Author     : Ngoc
--%>
<div class="container"
<p> <h1> Products </h1> </p>
<c:forEach var = "item" items = "${products}">
    <a href ="${item.code}"> ${item.productName} <a> </br> 
</c:forEach> 
<div>
    <img src="/beauty_supply/images/best_deal2.jpg" alt="Chania" width="100" height="100">
 </div> 
<div>
    <img src="/beauty_supply/images/new_product.jpeg" alt="Chania" width="100" height="100">
</div>
</div>