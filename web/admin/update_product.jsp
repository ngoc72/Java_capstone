<%-- 
    Document   : updateProduct
    Created on : Aug 24, 2016, 2:46:09 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-9">
                <h1> Update Product Form</h1>
                <form class="form-horizontal" action = "<c:url value ='/adminController/updateProduct?productId=${product.productId}' />" method="post">
                    
                   <div class="form-group">
                        <label class="control-label col-sm-2">Product name:</label>
                        <div class="col-sm-2">
                            <input type="text" name="productName"value="${product.productName}" required>
                        </div>
                   </div>
                   <div class="form-group">
                       <label class="control-label col-sm-2">Product Code</label>
                        <div class="col-sm-2">
                            <input type="text" name="productCode"value="${product.code}" required>
                        </div>
                   </div>
                   <div class="form-group">
                        <label class="control-label col-sm-2">Description: </label>
                        <div class="col-sm-2">
                            <input type="text" name="description"value="${product.description}">
                        </div>
                   </div>
                    <div class="form-group">                       
                        <label class="control-label col-sm-2">Brand: </label>
                        <div class="col-sm-2">
                            <input type="text" name="brand"value="${product.brand}" required>
                        </div>
                    </div>
                      <div class="form-group">                       
                        <label class="control-label col-sm-2"> Category: </label>
                        <div class="col-sm-2">
                            <input type="text" name="category"value="${product.category}" required>
                        </div>
                    </div>   
                    <div class="form-group"> 
                        <label class="control-label col-sm-2">Price: </label>
                        <div class="col-sm-2">
                             <input type="text" name="price"value="${product.price}" required>
                        </div>
                    </div>

                    <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">UPDATE</button>
                                </div>
                    </div>
                </form>
         </div>
     </div>
</div>           
   <c:import url="/includes/footer.jsp" />
