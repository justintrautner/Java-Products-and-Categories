<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title><c:out value="${product.name}" /></title>
</head>
<body class="ml-3 mt-3">

	<h1>
		<c:out value="${product.name}" />
	</h1>
	<h5>
		Description :
		<c:out value="${product.description}" />
	</h5>
	<h5>
		Price: $
		<c:out value="${product.price}" />
	</h5>

	<div class="row pt-5">

		<div class="col-md-6">

			<h3>Categories:</h3>
			<c:forEach items="${product.categories}" var="cat">
				<p>
					<c:out value="${cat.name}" />
				</p>
			</c:forEach>
		</div>

		<div class="col-md-6">

			<form method="post" action="/products/${product.id }/add">
			<h3>Add Category:</h3>
				<select name="newCategory">
					<c:forEach items="${ otherCats }" var="other">
						<option value="${other.id}"><c:out value="${other.name}" /></option>
					</c:forEach>
				</select> 
				<input type="hidden" name="product" value=${product.id }>
				<input type="submit" value="Add Category">
			</form>

		</div>


	</div>

</body>
</html>