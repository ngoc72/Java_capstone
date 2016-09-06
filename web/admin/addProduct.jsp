<%-- 
    Document   : products
    Created on : Aug 23, 2016, 1:52:42 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

     <div class="row">
         <div class="col-md-3">  
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-9">
             
                <h1> Add Product Form</h1>
                <form class="form-horizontal" action = "<c:url value ='/adminController/addProduct' />" method="post">
                    <div class="form-group">                    
                            <label class="control-label col-sm-2">Product name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productName"value="${product.productName}" required>
                            </div>
                    </div>   
                     <div class="form-group"> 
                            <label class="control-label col-sm-2">Product Code</label>
                            <div class="col-sm-10">
                                <input type="text"class="form-control" name="productCode"value="${product.code}" required>
                             </div>   
                      </div>   
                     <div class="form-group">    
                            <label class="control-label col-sm-2">Description: </label>
                            <div class="col-sm-10">
                                <input type="text"class="form-control" name="description"value="${product.description}">
                           </div>
                     </div>  
                       <div class="form-group">  
                            <label class="control-label col-sm-2">Brand: </label>
                            <div class="col-sm-10">
                                <input type="text"class="form-control" name="brand"value="${product.brand}" required>
                            </div>
                      </div>   
                      <div class="form-group">   
                            <label class="control-label col-sm-2">Category: </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="category"value="${product.category}" required>
                            </div>
                       </div>  
                       <div class="form-group">  
                            <label class="control-label col-sm-2">Price: </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="price"value="${product.price}" required>
                            </div>
                       </div>
                       <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Apply</button>
                                </div>
                        </div>
                   
                    
                           
                       
                        
                        
                    
                </form>
             
         </div>
     </div>
                   
 <c:import url="/includes/footer.jsp" />