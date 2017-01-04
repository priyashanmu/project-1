
 <%@include file="header.jsp"%>
   
  <body>

<h4>In Cart</h4>
<table class="table">
<h5>${modi}</h5>
<thead>
<tr class="info">
<th>Image</th>
<th>Name</th>
<th>Quantity</th>
<th>Price per unit</th>
<th>Price</th>
<th></th>
</tr>
</thead>
<c:set var="totalPrice" value="0"></c:set>
<c:forEach var="pd" items="${cart}">
<c:set var="totalPrice" value="${totalPrice+(pd.product.price*pd.quantity)}"></c:set>
<tbody>
<tr>
<form:form action="./updateItem?id=${pd.product.fid}" commandName="item" method="post">
<td><form:hidden path="itemId" value="${pd.itemId}"/>  <img src="<c:url value="${pd.product.imgs}"/>" height="80px" width="50px"></td>
<td>${pd.product.name} <%-- <form:hidden path="product" value="${pd.product}"/> --%> </td>
<td> ${pd.quantity}</td>
<td>Rs.${pd.product.price}</td>
<td>Rs.${pd.product.price*pd.quantity}</td>
<!-- <td><input type="submit" class="btn link" value="update"/>
</td> -->
<td><a commandName="item" href="deleteItem?id=${pd.itemId}">Delete</a></td>
<td></td>
</form:form>
</tr>
</tbody>
</c:forEach>
<tr class="info">
<td colspan="4" align=right><strong>Total Price</strong></td>
<td>Rs.${totalPrice}</td>
<td></td>
<tr>
</table>
<div align="center">
<button class="btn btn-success"><a href="productpage" style="color:white">Continue Shopping</a></button>
<button class="btn btn-success"><a href="ShippingForm" style="color:white">Order Now</a></button>
</div>
<div align="right">
</div>
</body>
</html>