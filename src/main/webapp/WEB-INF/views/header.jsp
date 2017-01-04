<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>" ></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>" ></script>
</head>
<style>
#women
      {
        background-color: white;
        color:black;
      }
/* footer {
      background-color: #555;
      color: white;
      padding: 15px;
    } */
</style>
</head>
<body data-target=".navbar">
<div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <div class="navbar-header">
     <div class="navbar-brand">Women Accessories World</div>
    </div>
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     </button>
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="pro">Home</a></li>
      <li class="active"><a href="aboutas">About us</a></li>
      
      
        
   <li class="active"><a href="productpage">Product</a></li>
        
        
        <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categorys <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="earring">Earrings</a></li>
          <li><a href="bangle">Bangles</a></li>
          <li><a href="bracelet">Bracelet</a></li>
        
        <li><a href="rings">Rings</a></li>
      </ul>   --> 
<!-- </ul>
</li> 
    -->
     
    
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <c:forEach items="${priy}" var="category"> 
          <li><a commandName="cat" href="categorypage?id=${category.fid}">${category.name}</a></li>
          </c:forEach>
      </ul> 
      </li>    
</ul>
</li><ul class="nav navbar-nav navbar-right">
    
     <c:if test="${pageContext.request.userPrincipal.name == null}">
   
      <li><a href="memberShip"><span class="glyphicon glyphicon-user"></span> Signup </a></li>
       <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    
    <li><security:authorize access="hasRole('ROLE_ADMIN')">
    
    <li><a href="admin"><span class="glyphicon glyphicon-log-in"></span> AdminLogin</a></li>
    </security:authorize></li>
          
</c:if>
<li>
<form action="logout" id="logout" method=post>
 
 <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
 </form> 
  <c:if test="${pageContext.request.userPrincipal.name != null}">
              <h5 style=color:white>Welcome ${pageContext.request.userPrincipal.name} 
                                <a href="javascript:document.getElementById('logout').submit()">Logout</a></h5> 
                 </c:if> 
        
        </li>
    </ul>
    
  </div>

</div>
</nav>
  </div>
