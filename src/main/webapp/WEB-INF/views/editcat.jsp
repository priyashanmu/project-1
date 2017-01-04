
<%@include file="header.jsp"%>
  <div class="container" id="wrap">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
  
	<form:form action="./updateCategory" method="POST" commandName="cat">
	 <tr> 
			<td>Category ID</td> 
			<td><form:input path="fid" value="${CategoryObject.fid}" readonly="true"/></td>
			</tr>
			
		<br>
		
		<tr> 
			<td>Category Name</td>
			<td><form:input path="name" value="${CategoryObject.name}"/></td>
		</tr>
		<br>
		<tr>
			<td>Category Description</td>
			<td><form:input path="desc" value="${CategoryObject.desc}" /></td>
		</tr>
		<br>
		<%-- <tr>
			<td>Category Price</td>
			<td><form:input path="price" value="${CategoryObject.price}" /></td>
		</tr> --%>
		<br>
		<tr>
			<td colspan="2">
			<input type="submit" name="action" value="update" />
		     <input type="reset" name="action" value="reset" onclick="Category" />
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

			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.fid}</td>
					<td>${category.name}</td>
					<td>${category.desc}</td>
					<%-- <td>${category.price}</td>
					 --%><td><a href="editcategory?id=${category.fid}">edit</a></td>
					<td><a href="deleteCategory?id=${category.fid}">delete</a></td>




				</tr>

			</c:forEach>		</table> 
</div></div></div>
	
</body>
</html>