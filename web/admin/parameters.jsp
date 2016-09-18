<%-- 
    Document   : time_parameters
    Created on : Aug 25, 2016, 9:56:21 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row content">
         <div class="col-md-3"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-6">
                <h1>${param.reportTitle}</h1>
                <p>${currentYear}</p>
                <p>Please enter dates using this format yyyy-mm-dd</p>
                <form action="<c:url value="/adminController/displayReport"/>" method="post">
                    <input type="hidden" name ="reportName" value="${param.reportName}">
                    <input type="hidden" name ="reportTitle" value="${param.reportTitle}">
                    <table class="table">
                        <tr>
                            <td><label>Start date: </label></td>
                            <td><input type="text" name="startDate" value="${currentYear}-01-01"></td>
                        </tr>
                        <tr>
                            <td><label>End date: </label></td>
                            <td><input type="text" name="endDate" value="${currentYear}-12-31"></td>
                         </tr>
                    </table>
                    <input type="submit" value="CONTINUE">
                </form>
         </div>
         <div class="col-md-3">
                             
         </div>              
     </div>
</div>            
<c:import url="/includes/footer.jsp" />
