
 <%@include file="header.jsp"%>
       <div class="section" id="show">
      <div class="container">
    
    <div id="products" class="item">
              
          <div class="row">
                
<c:forEach items="${prodLt}" var="p">
 
<div class="col-sm-4">
<div class="box">
<img src="<c:url value="${p.imgs}"/>" width="200px" height="150px"/>

                   
                        
                           <h3>${p.name}</h3>
                              <p>${p.desc}</p>

                                <p>Rs.${p.price}</p>
                            
                     <button class="btn btn-danger"><a href="addToCart?id=${p.fid}" style="color:white" >Add to
						Cart</a></button>
				<button class="btn btn-success"><a href="ShippingForm" style="color:white">BUY NOW</a> </button>
				
                           <%-- <button class="btn btn-success"><a commandName="prod" href="<c:url value="/user/addtocart/{p.fid}"/>"Add To Cart</a> </button>
 --%></div></div></c:forEach></div>
                   
            
</body>
</html>