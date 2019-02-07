<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title><c:out value="${category.name}" /></title>
</head>
<body class="ml-3 mt-3">

	<h1>
		<c:out value="${category.name}" />
	</h1>

	<div class="row pt-5">

		<div class="col-md-6">

			<h3>Products:</h3>
			<c:forEach items="${category.products}" var="pro">
				<p>
					<c:out value="${pro.name}" />
				</p>
			</c:forEach>

		</div>

		<div class="col-md-6">
			<form method="post" action="/categories/${category.id }/add">
				<h3>Add Product:</h3>
				<select name="newProduct">
					<c:forEach items="${ otherProducts }" var="other">
						<option value="${other.id}"><c:out value="${other.name}" /></option>
					</c:forEach>
				</select> <input type="hidden" name="category" value=${category.id }>
				<input type="submit" value="Add Product">
			</form>
		</div>


	</div>

</body>
</html>