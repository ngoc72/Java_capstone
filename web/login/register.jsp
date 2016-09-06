<%-- 
    Document   : register
    Created on : Aug 9, 2016, 8:27:36 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
     <div class="row">
         <div class="col-md-3">
             
         </div>
         <div class="col-md-9">            
                <h1>Your account registration</h1>
                <form action = "<c:url value='/Registration'/>"  method = "post"/>
                <div class="form-group">
                    <label> First name: </label>
                    <input type="text" class="form-control"name ="fname" required/>
                </div>
                <div class="form-group">
                    <label> Last name: </label>
                    <input type="text" class="form-control"name ="lname" required/>
                </div>
                <div class="form-group">
                    <label> Email </label>
                    <input type="text" class="form-control"name ="email" required/>
                </div>
                <div class="form-group">
                    <label> Password </label>

                    <input type="password" class="form-control" name ="password" required/>
                </div>
                <button type ="submit" class="btn btn-default"> REGISTER </button>
            </form>
            <h3> ${message}</h3>
          
         </div>
     </div>

          
            
            
<c:import url="/includes/footer.jsp" />
