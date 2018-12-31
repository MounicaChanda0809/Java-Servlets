<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 align = "center" > Search Product </h2>
	 <div align = "center">
		 <form  action = "SearchProduct" method = "GET">
 
			 productID : <input type = "text" name = "pid">
 	
 			<input type = "submit" value = "Search">
 
		 </form>
		 </div>
		 
		 <c:if test = "${product ne null }" >
		 <h2 align = "center">Product Record</h2>
		 <div>
		 
		 <table align ="center" border = "2">
		 
		 <tr>
		  <th>ID</th><th>Name</th><th>Price</th><th>Description</th><th>Quantity</th>
		 </tr>
		 
		 <tr>
		  <td>${product.id} </td><td>${product.name} </td><td>${product.price} </td><td>${product.description} </td><td>${product.quantity} </td>
		 </tr>
		 
		 
		 </table>
		 </div>
		 </c:if>
		 
		

</body>
</html>