<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>category</title>
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
     
      <li><a href="admin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</div>
</nav>
  </div>
  <div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
  
	<form:form action="./updateProduct" method="POST" commandName="prod">
	 <tr> 
			<td>Product ID</td> 
			<td><form:input path="fid" value="${ProductObject.fid}" readonly="true"/></td>
			</tr>
			
		<br>
		
		<tr> 
			<td>Product Name</td>
			<td><form:input path="name" value="${ProductObject.name}"/></td>
		</tr>
		<br>
		<tr>
			<td>Product Description</td>
			<td><form:input path="desc" value="${ProductObject.desc}" /></td>
		</tr>
		<br>
		<tr>
			<td>Product Price</td>
			<td><form:input path="price" value="${ProductObject.price}" /></td>
		</tr>
		<br>
		<tr>
			<td colspan="2">
			<input type="submit" name="action" value="update" />
		     <input type="reset" name="action" value="reset" onclick="Product" />
		    <input type="submit" name="action" value="delete" />  
	   	    </td>
		</tr>
		</form:form>
		<br>
		<table border="2">
			<th>ID</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>EDIT</th>
			<th>DELETE</th>

			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.fid}</td>
					<td>${product.name}</td>
					<td>${product.desc}</td>
					<td>${product.price}</td>
					<td><a href="editproduct?id=${product.fid}">edit</a></td>
					<td><a href="deleteProduct?id=${product.fid}">delete</a></td>




				</tr>

			</c:forEach>		</table>

	</div></div></div>
</body>
</html>