<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Mvc WebFlow Demo</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
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
</style>
</head>
<body>
	<center>
		<h1>Confirm Order Detail</h1>
		<form method="post" action="./sendEmail">
			<table border="0" width="20%">
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">To:</td> -->
					<td><input type="hidden" value="${email}" name="recipient" size="35" /></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Subject:</td> -->
					<td><input type="hidden" name="subject" size="35" value="ORDER CONFORMATION..."/></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Message:</td> -->
					<h1><td><textarea cols="80" rows="22" name="message" >ORDER LISTS:					
					<c:set var="totalPrice" value="0"></c:set>
<c:forEach var="pd" items="${cart}">
<c:set var="totalPrice" value="${totalPrice+(pd.product.price*pd.quantity)}"></c:set>
Product Name: ${pd.product.name}
Quantity: ${pd.quantity}
Price: Rs.${pd.product.price}
</c:forEach>
Total Price:Rs.${totalPrice}

					</textarea></td>
				</tr> 
				
				<tr>
					<td colspan="3" align="center">
						<br/><br/>
						<button type="submit" class="btn  btn-success">Confirm</button>
      
						</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>