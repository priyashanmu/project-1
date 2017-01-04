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
      <li class="active"><a href="Product">Product</a></li>
   
       <li class="active"><a href="images">Contact</a></li>
      
         
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
     <h1>Add Category</h1>
	<form:form action="./saveCategory" method="POST" commandName="cat">
		 <tr><br><br>
			<td>Category Name</td>
			<td><form:input path="name" class="form-control" /></td>
		</tr>
		<br><br>
		<tr>
			<td>Category Description</td>
			<td><form:input path="desc" class="form-control" /></td>
		</tr>
		<br><br>
		
		<tr>
			<td colspan="2">
			<input type="submit" name="action" value="Add" />
		  <input type="reset" name="reset" value="Reset" />
		  
		    <!-- <input type="submit" name="action" value="delete" /> 
	  	     --> </td>
		</tr> 
		</form:form>
		 </table><br>
		 <!-- <div ng-app="myApp" ng-controller="Category">
		 -->
		<a href="listcategory">View the category list </a><br><br>
	
	<h1>Category Details</h1><br>
		<table class="table" border="2">
			<th>ID</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			
		
			<th>EDIT</th>
			<th>DELETE</th>
			
		
			<c:forEach items="${CategoryList}" var="category">
				   <%-- <c:set var="m" value="${requestScope.img}"/>
			    --%>
				<tr>
					<td>${category.fid}</td>
					<td>${category.name}</td>
					<td>${category.desc}</td>
				<%-- 
				   <td><img src="<c:url value="${category.imgs}"/>" height="100px" width ="100px" ></td>
				 	 --%> 
					<td><a href="editcategory?id=${category.fid}">Edit</a></td>
					<td><a href="deleteCategory?id=${category.fid}">Delete</a></td>
					
				</tr>


			</c:forEach>
		
	
	 </table>

	</div></div></div>
</body>
</html>
