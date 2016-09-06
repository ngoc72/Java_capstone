<%-- 
    Document   : header
    Created on : Jul 29, 2016, 4:52:32 PM
    Author     : Ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Beauty supply store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


        `
    </head>
    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        .first-con {
            background: lavender url('/beauty_supply/images/roses02.jpg')repeat fixed;         

        } 
        .first-col{

            font-family: 'AR BLANCA', cursive;
            color: white;
            font-size: 1.5cm;
            text-align: right;
        }
        .second-col{

            font-family: 'AR BLANCA', cursive;
            color: white;
            margin-top: 40px;
            text-align: left;

        }
        .navbar-brand{
            background: url('/beauty_supply/images/star1.png') no-repeat; 
            width: 200px;

        }
        .row{
            padding-top: 0.5cm;
        }
        .col-md-3,.col-sm-9{
            padding-left: 1cm;
        }
        carousel-inner > .item > img,
        .carousel-inner > .item > a > img {
            width: 90%;
            margin: auto;
        }        
        .form-control {
            width:400px;
        }   
  
    </style>
    <body data-spy="scroll" data-target=".navbar" data-offset="50">

        <div class="first-con container-fluid">         
            <div class="page-header">
                <div class="row">
                    <div class="first-col col-sm-9">
                        Starlight
                    </div>
                    <div class="second-col col-sm-3">
                        <h3>BEAUTY SUPPLY INC</h3>
                    </div>
                </div>
            </div>
        </div>




        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">

                    <a class="navbar-brand" href ="<c:url value='/catalog/product/'/>"> </a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">              

                    <ul class="nav navbar-nav">

                        <li class="active"><a href="<c:url value='/catalog/product/'/>"> SHOP</a></li>
                        <li><a href="<c:url value='/about.jsp'/>">ABOUT</a></li> 
                        <li><a href="<c:url value='/contact.jsp'/>">CONTACT</a></li>                        

                        <!--<li><a href="<c:url value='/user/deleteCookies'/>">DELETE COOKIES</a></li>-->

                        <li><a href="<c:url value='/admin'/>"> ADMIN</a></li>  

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li ><a href="<c:url value='/login/login_index.jsp'/>">
                                <span class="glyphicon glyphicon-log-in"></span>LOGIN </a></li>
                        <li ><a href="<c:url value='/login/register.jsp'/>">
                                <span class="glyphicon glyphicon-user"></span>SIGN UP</a></li>

                        <li><a href="<c:url value='/order/showCart'/>">
                                <span class="glyphicon glyphicon-shopping-cart"></span>SHOW CART</a></li>

                    </ul>
                </div>
            </div>
        </nav>





