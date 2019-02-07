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
<title>Create new Product</title>
</head>
<body class="ml-3 mt-3">

	<h1>New Product</h1>

	<form:form action="/products" method="post" modelAttribute="newproduct">

		<p>
			<form:label path="name">Name: </form:label>
			<form:input path="name" />
		</p>
		<p>
			<form:errors class="text-danger" path="name" />
		</p>

		<p>
			<form:label path="description">Description: </form:label>
			<form:input path="description" />
		</p>
		<p>
			<form:errors class="text-danger" path="description" />
		</p>
				<p>
			<form:label path="price">Price: </form:label>
			<form:input path="price" />
		</p>
		<p>
			<form:errors class="text-danger" path="price" />
		</p>

		<input type="submit" value="Create Product" />
	</form:form>

</body>
</html>