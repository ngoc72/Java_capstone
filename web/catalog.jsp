<%-- 
    Document   : index
    Created on : Jul 29, 2016, 12:54:35 PM
    Author     : Ngoc
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<session>
    <div class="row">
        <div class="col-md-3">
            <div class="container">
                <p> <h1> Products </h1> </p>
                <c:forEach var = "item" items = "${products}">
                <a href ="${item.code}"><b> ${item.productName} </b><a> </br> 
                        </c:forEach>                   
            </div>
            
        </div>
        <div class="col-md-6">
            <div class="container">
              <br>
              <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                  <li data-target="#myCarousel" data-slide-to="3"></li>
                  <li data-target="#myCarousel" data-slide-to="4"></li>
                  <li data-target="#myCarousel" data-slide-to="5"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                    <img src="/beauty_supply/images/nail_model.jpeg" alt="Chania" width="460" height="345">
                  </div>

                  <div class="item">
                    <img src="/beauty_supply/images/nail_product.jpeg" alt="Chania" width="460" height="345">
                  </div>

                  <div class="item"><
                    <img src="/beauty_supply/images/hair_model.jpeg" alt="Flower" width="460" height="345">
                  </div>

                  <div class="item">
                    <img src="/beauty_supply/images/hair_product.jpeg" alt="Flower" width="460" height="345">
                  </div>
                  <div class="item">
                    <img src="/beauty_supply/images/makeup_model.jpg" alt="Flower" width="460" height="345">
                  </div>
                  <div class="item">
                    <img src="/beauty_supply/images/makeup_product.jpeg" alt="Flower" width="460" height="345">
                  </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>   

        </div>
        <div class="col-md-3">
            <div class="container">
                <div>
                <img src="/beauty_supply/images/best_deal.jpg" alt="Best Deal" width="150" height="150">
                </div>
                <div>
                <img src="/beauty_supply/images/new_arrival.jpeg" alt=" New Arival" width="150" height="150">
                </div>
            </div>
            <div class="container">
                <h4> Useful links </h4>
                <ul>
                    <li><a href ="https://www.tdlr.texas.gov"> TDLR </a></li>
                    <li> <a href ="http://www.thebeautymagazine.com"> Beauty Magazine </a></li>                    
                    
                </ul>
                
            </div>
        </div>
                        
        
    </div>
</session>
<c:import url="/includes/footer.jsp" />
