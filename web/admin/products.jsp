<%-- 
    Document   : products
    Created on : Aug 24, 2016, 11:23:59 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

     <div class="row">
         <div class="col-md-2"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-10">
             <div class="container">
                <h1> Products</h1>
                <table class="table table-condensed">
                    <thead>
                        <tr>
                            <th> Id</th>
                            <th> Code</th>
                            <th> Name</th>
                            <th>Description</th>
                            <th>Brand</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Remove</th>
                            <th>Updated</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items ="${products}">
                         <tr>   
                            <form action ="delete_updateProduct?productId=${product.productId}" method="post">
                               <td>${product.productId}</td>
                               <td>${product.code}</td>
                               <td>${product.productName}</td>
                               <td>${product.description}</td>
                               <td>${product.brand}</td>
                               <td>${product.category}</td>
                               <td>${product.price}</td>
                               <td> <input type="submit" name ="action" value="Delete"> </td> 
                               <td> <input type="submit" name="action" value="Update"> </td> 
                            </form>
                         </tr>    


                        </c:forEach>
                    </tbody>

                </table>
                <p>${message}</p>
                <form action ="<c:url value='/admin/addProduct.jsp'/>">
                    <input type ="submit" value="ADD PRODUCT">
                </form>
                
            </div>
         </div>            
     </div>
                 
  <c:import url="/includes/footer.jsp" />
