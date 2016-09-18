<%-- 
    Document   : displayProduct
    Created on : Aug 4, 2016, 1:27:38 PM
    Author     : Ngoc
--%>


<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">  
     <div class="row content">
         <div class="col-md-3">
             <c:import url="/includes/column_left_catalog.jsp" />
         </div>
         <div class="col-md-6">
                <img src= "${product.getURLImage()}" width="175" height="175" alt="Product Image">
               <h4>Product name: ${product.productName}</h4>
               <h4> Type: ${product.category}</h4>
               <h4>Brand: ${product.brand}</h4>  
               <h4>Price: ${product.getPriceCurrencyFormat()}</h4>
               <h4>Description: ${product.description} </h4>

               <form method="post" action="<c:url value='/order/addItem'/>">
                  <input type ="hidden"name ="productCode" value="${product.code}"/>
                   <input type = "submit" value = "Add to Cart"/>
               </form>
         </div>
          <div class="col-md-3">
        <c:import url="/includes/column_right_catalog.jsp" />    
        </div>         
                   
     </div>
</div>
        
  <c:import url="/includes/footer.jsp" />
