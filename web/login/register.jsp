<%-- 
    Document   : register
    Created on : Aug 9, 2016, 8:27:36 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3">
             
         </div>
         <div class="col-md-9">  
             <p><h3 style="color: blue"> ${message}</h3></p>
                <h1>Your account registration</h1>
                <br>
                <form class="form-horizontal" action = "<c:url value='/LoginController/register'/>"  method = "post">
                    <div class="form-group">
                        <label class="control-label col-sm-2"> First name: </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"name ="fname" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"> Last name: </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"name ="lname" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"> Email </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"name ="email" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2"> Password </label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name ="password" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">  Confirm password </label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name ="confirmPassword" required/>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        
                    </div>
                    <div class="col-sm-10">
                         <button type ="submit" class="btn btn-default"> REGISTER </button>
                    </div>
            </form>
            
          
         </div>
     </div>
</div>
          
            
            
<c:import url="/includes/footer.jsp" />
