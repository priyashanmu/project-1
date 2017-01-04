<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
      <li class="active"><a href="#">Home</a></li>
      <li class="active"><a href="aboutas">About us</a></li>
      
      
        <li class="active"><a href="images">Contact</a></li>
        
   
        
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
</li>
    <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="memberShip"><span class="glyphicon glyphicon-user"></span> Signup </a></li>
       <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    <li><a href="AdminLogin"><span class="glyphicon glyphicon-log-in"></span> AdminLogin</a></li>
     -->
    <li>      
<form action="logout" id="logout" method=post>
 
 <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
 </form> 
  <c:if test="${pageContext.request.userPrincipal.name != null}">
              <h5 style=color:white>Welcome ${pageContext.request.userPrincipal.name} 
                              &nbsp: <a href="javascript:document.getElementById('logout').submit()">Logout</a></h5> 
                 </c:if> 
        
        </li>
    </ul>
    
  </div>

</div>
</nav>
  </div>
<div class="section" id="women">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section">
              <div class="container">
                <div class="row">
                  <div class="col-md-12 text-center">
                    <h1 class="text-center">
                      <b>Women Accessories</b>
                    </h1>
                    <p class="lead text-center">Shop our rings, earrings, bangles,bracelets.</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-2">
                    <br>
                    <br>
                    <h4>Awesome Design</h4>
                    <p>
 make a great decorative item for personal adornment and come in different forms like  rings, bangles</p>
                   <br> <img src="<c:url value='/resources/image/s1.png'/>" class="img-responsive">
                  </div>
                  <div class="col-md-8">
                    <img src="<c:url value='/resources/image/let8.jpg'/>" width="764" height="506" >
                  </div>
                  <div class="col-md-2">
                    <br><br><br><br>
                  
                    <img src="<c:url value='/resources/image/s2.png'/>" class="img-responsive">
                    <h4>Awesome Collections</h4>
                    <p>Peora Silver/White Sterling Silver Ring. ... Women’s jewellery.adorning feminine grace... 
</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="section" id="descr">
  <h1><b> About us</b></h1> 
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section">
              <div class="container">
                <div class="row">
                  <div class="col-md-12 text-center">
                       
                  </div>
                </div>
                <br>
                <br>
                <div class="container-fluid">
  
    

    <p class="lead"style="color:black"> Buy trendy fashion Jewelry & accessories online for Girls & women . shop Designer Fashion ... 
    the product looks really cool, and like what it shown in the picture...</p>
<p class="lead"style="color:black">Buy Designer Fashion Jewellery, Fancy Jewellery Online in India. Huge range of Women Fashion Jewellery
Buy Fashion Jewelry and Accessories Online at Best Prices - Choose from a wide designer collection..</p>
</p>
 </div>
                
                <div class="row">
                  <div class="col-md-4">
                    <center>
                      <img src="<c:url value='/resources/image/b.jpg'/>" class="img-responsive">
                    </center>
                    <h2 class="text-center">Bangles</h2>
                    <p class="lead text-center">Bangles are rigid bracelets, usually from metal, wood, or plastic. 
They are traditional ornaments worn mostly by South Asianwomen in India,</p>
                  </div>
                  <div class="col-md-4">
                    <center>
                      <img src="<c:url value='/resources/image/lo.jpg'/>" class="img-responsive">
                    </center>
                    <h2 class="text-center">Bracelet</h2>
                    <p class="lead text-center">A bracelet is an article of jewellery that is worn around the wrist.
 It may have a supportive function, such as holding awristwatch </p>
                  </div>
                  <div class="col-md-4 text-center">
                    <center>
                      <img src="<c:url value='/resources/image/r1.jpg'/>" class="img-responsive">
                    </center>
                    <h2>Ring</h2>
                    <p class="lead">A ring is a round band, usually in metal, worn as an ornamental Jewellery around the finger, or sometimes the toe; 
it is the most common current meaning of the word "ring".</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
      
   
  </div> 
    
    
    
            <div class="container">
  <div class="row">
  <hr>
    <div class="col-lg-12">
      <div class="col-md-8">
        <a href="#">Terms of Service</a> | <a href="#">Privacy</a>    
      </div>
      <div class="col-md-4">
        <p class="muted pull-right">© 2016 Web site Name. Women Accessories</p>
      </div>
    </div>
  </div>
</div>
</div>
        
        

</body>
</html>