<%-- 
    Document   : index
    Created on : Aug 3, 2016, 8:13:37 AM
    Author     : Ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String redirectURL = "catalog/product/"; 
            response.sendRedirect(redirectURL);
        %> 
    </body>
</html>
