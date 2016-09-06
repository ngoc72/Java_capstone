<%-- 
    Document   : time_parameters
    Created on : Aug 25, 2016, 9:56:21 AM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

     <div class="row">
         <div class="col-md-3"> 
             <c:import url="/includes/column_left_admin.jsp" />
         </div>
         <div class="col-md-9">
                <h1>${param.reportTitle}</h1>
                <p>${currentYear}</p>
                <p>Please enter dates using this format yyyy-mm-dd</p>
                <form action="<c:url value="/adminController/displayReport"/>" method="post">
                    <input type="hidden" name ="reportName" value="${param.reportName}"
                    <input type="hidden" name ="reportTitle" value="${param.reportTitle}"
                    <label> Start Date</label>
                    <input type="text" name="startDate" value="${currentYear}-01-01"><br>
                    <label> End Date</label>
                    <input type="text" name="endDate" value="${currentYear}-12-31"><br>
                    <input type="submit" value="CONTINUE"
                </form>
         </div>
     </div>
               
<c:import url="/includes/footer.jsp" />
