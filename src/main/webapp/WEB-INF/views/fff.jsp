<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>form</title>
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

/* form
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
 */ </style> 
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
      <li class="active"><a href="index">Home</a></li>
      <li class="active"><a href="aboutas">Abouts</a></li>
      <li class="active"><a href="Product">Product</a></li>
   
      <li class="active"><a href="images">Contact</a></li>
      
  
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="earring">Earrings</a></li>
          <li><a href="bangle">Bangles</a></li>
          <li><a href="bracelet">Bracelet</a></li>
      
        <li><a href="rings">Rings</a></li>
      </ul>  
</ul>
</li>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="fff"><span class="glyphicon glyphicon-user"></span> Signup</a></li>
      <li><a href="index"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</div>
</nav>
  </div>
 <div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="r" method="post" accept-charset="utf-8" class="form" role="form">   <legend>Sign Up</legend>
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
                            <input type="text" name="firstname" value="" class="form-control input-lg" placeholder="First Name"  />                        </div>
                        <div class="col-xs-6 col-md-6">
                            <input type="text" name="lastname" value="" class="form-control input-lg" placeholder="Last Name"  />                        </div>
                    </div>
                    <input type="text" name="email" value="" class="form-control input-lg" placeholder="Your Email"  />                    
                    <input type="username" name="username" value="" class="form-control input-lg" placeholder="Username"  />
                    <input type="password" name="password" value="" class="form-control input-lg" placeholder="Password"  />
                    <input type="password" name="confirm_password" value="" class="form-control input-lg" placeholder="Confirm Password"  /> 
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Create my account</button>
            </form>          
          </div>
</div>            
</div>
</div>
 </body>
</html>

  