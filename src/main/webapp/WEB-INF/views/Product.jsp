<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
  <!-- <style>
body
{
background-image: url("<c:url value='/resources/image/m3.jpg'/>");
  background-repeat: no-repeat; 
background-size:cover; 
} 
</style> -->
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
      <li class="active"><a href="aboutas">Abouts</a></li>
     <li class="active"><a href="productpage">Product</a></li>
        
    
   
       
      <!--  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="earring">Earrings</a></li>
          <li><a href="bangle">Bangles</a></li>
          <li><a href="bracelet">Bracelet</a></li>
     
        <li><a href="rings">Rings</a></li>
      </ul>   -->
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
      
      <li><a href="admin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</div>
</nav>
  </div>

<body>
<div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
     <div class="row">
     
  <!-- <table border="1"> 
 -->	<form:form action="./saveProduct" method="POST" commandName="prod" enctype="multipart/form-data">
	<!-- <a href="listproduct">View the Product list </a><br><br>
	 -->  
	<h1>Add Product</h1>
			<td>Product Name</td>
			<td><form:input path="name" class="form-control" required="true"/></td>
		</tr>
		<br><br>
		<tr>
			<td> Product Description</td>
			<td><form:input path="desc" class="form-control" required="true" /></td>
		</tr>
		<br><br>
		<tr>
			<td>Product Price</td>
			<td><form:input path="price" class="form-control" pattern="[0-9].{2,}" title="not allowed character" required="true"/></td>
		 </tr><br><br>
		
		<tr>
			<td>Product Quantity</td>
			<td><form:input path="quantity" class="form-control" pattern="[0-9].{0,}" title="not allowed character" required="true"/></td>
		 </tr><br><br>
		 <tr>
			<td>Product Supplier</td>
			<td><form:select path="sid" class="form-control" >
			<c:forEach items="${pri}" var="s">
			<option value="${s.fid}">${s.name}</option>
			</c:forEach>
			</form:select></td>
		 </tr>
		  <tr><br><br>
			<td>Product Category</td>
			<td><form:select path="cid" class="form-control">
			<c:forEach items="${priy}" var="c">
			<option value="${c.fid}">${c.name}</option>
			</c:forEach>
			</form:select></td>
		 </tr>
		  <tr><br><br>
			<td> Product Image</td><br>
			<td><form:input type="file" path="file" name="file"/>${message}</td>
		</tr>  
		<br>
		<td><form:hidden path="imgs" value="${img}"/>
		</td> 
			<td colspan="2">
		  <input type="submit" name="action" value="Add" />
		  <input type="reset" name="reset" value="Reset" />
		  
		   
	  	     </td>
		</tr> 
		</form:form>
		 </table><br>
		 <!-- <div ng-app="myApp" ng-controller="Product">
		 -->
		
	
	<a href="listproduct">View the Product list </a><br><br>
	
		<h1>Product Details</h1>
		<table class="table" border="2">
			<th>ID</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			 <th>IMAGE</th> 
			<th>EDIT</th>
			<th>DELETE</th>
			
		
			<c:forEach items="${ProductList}" var="product">
				   <%-- <c:set var="m" value="${requestScope.img}"/>
			    --%>
				<tr>
					<td>${product.fid}</td>
					<td>${product.name}</td>
					<td>${product.desc}</td>
					<td>${product.price}</td>
				   <td><img src="<c:url value="${product.imgs}"/>" height="100px" width ="100px" ></td>
				 	 
					<td><a href="editprod?id=${product.fid}">Edit</a></td>
					<td><a href="deleteProduct?id=${product.fid}">Delete</a></td>




				</tr>

			</c:forEach>
		
	
	 </table>

	</div></div></div>
</body>
</html>