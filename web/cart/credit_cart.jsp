<%-- 
    Document   : creditCart
    Created on : Aug 15, 2016, 2:13:18 PM
    Author     : Ngoc
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />
<div class="container">
     <div class="row">
         <div class="col-md-2">
             
         </div>
         <div class="col-md-10">
                <h1> Enter your credit cart information </h1>
                <form action ="<c:url value ='/order/completeOrder'/>" method ='post' >
                    <table class="table">
                        <tr>
                            <td> <b> Credit cart type</b></td>
                            <td>
                                <select name ="creditCartType" size = "1">
                                    <option value = "Visa"> Visa</option>
                                    <option value = "Mastercart"> Matercart</option>
                                    <option value = "AmericanExpress"> American Express</option>

                                </select>

                            </td>
                        </tr>
                        <tr>
                            <td> <b>Credit cart number</b></td>
                            <td>
                                <input type =" text" size ="20" name ="creditCartNumber"
                                        maxlength="25" required/>
                            </td>
                        </tr>
                        <tr>
                            <td> Credit cart expiration date (mm/yyyy)</td>
                            <td>
                                <select name = creditCartExpirationMonth>
                                    <option value ="01" >01</option>
                                    <option value ="02" >02</option>
                                    <option value ="03" >03</option>
                                    <option value ="04" >04</option>
                                    <option value ="05" >05</option>
                                    <option value ="06" >06</option>
                                    <option value ="07" >07</option>
                                    <option value ="08" >07</option>
                                    <option value ="09" >09</option>
                                    <option value ="10" >10</option>
                                    <option value ="11" >11</option>
                                    <option value ="12" >12</option>

                                </select>
                                /
                                <select name ="creditCartExpirationYear">
                                    <option value ="2016" >2016</option>
                                    <option value ="2017" >2017</option>
                                    <option value ="2018" >2018</option>
                                    <option value ="2019" >2019</option>
                                    <option value ="2020" >2020</option>
                                    <option value ="2021" >2021</option>

                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Submit Order"></td>
                        </tr>
                    </table>
                </form>
            </div>
    </div>
</div>
    <c:import url="/includes/footer.jsp" />
