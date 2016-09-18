<%-- 
    Document   : updateAccount
    Created on : Sep 6, 2016, 7:38:36 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
 <div class="container">   
        <div class="row content">
            <div class="col-md-3">
              <c:import url="/includes/column_left_login.jsp" />  
            </div>
            <div class="col-md-9">
                <div class="container">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10">
                        <h4> Your account info: </h4>
                    </div>
                    <form class="form-horizontal" action = "processUpdate?email=${user.email}" method = "post">
                        <div class="form-group">
                            <label class="control-label col-sm-2">First name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="fname" value ="${user.firstName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Last name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="lname" value ="${user.lastName}">

                            </div>
                        </div>                        
                        <div class="form-group">
                            <label class="control-label col-sm-2">Company:</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="company" value ="${user.companyName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2"> Address1:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="address1" value ="${user.address1}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2"> Address2:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="address2" value ="${user.address2}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2"> City:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="city" value ="${user.city}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2"> State:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="state" value ="${user.state}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Zip:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="zip"  value ="${user.zip}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2"> Country:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="country" value ="${user.country}">
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
</div>
        
<c:import url="/includes/footer.jsp" />
