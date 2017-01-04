<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>B</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
  
<style>
 body
{
background-image: url("<c:url value='/resources/image/m3.jpg'/>"); 
  background-repeat: no-repeat; 
background-size:cover; 
}
 
form
{

width:600px;
background-color:white;
padding:40px;
margin:40px;
}
fieldset
{

width:500px;
background-color:pink;
padding:40px;
margin:40px;
}
</style>
</head>

<body>
<div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
   
<div id="a">
  <h2>Login Page</h2>/
  <form action="./login" method="post">
    <c:if test="${not empty error}">
           
           
                <h2><left>Enter Details</left></h2>
                <div class="error" style="color: red;">${error}</div>
                </c:if>


          <c:if test="${not empty msg }">
          <div class="msg">${msg}</div>
          </c:if>
    
    <div class="form">
      <label for="UserName">UserName:</label>
      <input type="text" class="form-control" name="username" placeholder="Enter user name" required="true"/>
    </div>
    <div class="form2">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="password" placeholder="Enter password" required="true"/>
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
      <button type="submit" class="btn  btn-success ribbon">Login</button>
      <a class="btn btn-primary" href="memberShip">Signup</a></button>
      
      <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
      </form>
</div></div>
</div></div>
</body>
</html>
