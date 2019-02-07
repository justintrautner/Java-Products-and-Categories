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
<title>Insert title here</title>
</head>
<body class="mt-3 ml-3">

	<h1>New Category</h1>

	<form:form action="/categories" method="post" modelAttribute="newcategory">

		<p>
			<form:label path="name">Name: </form:label>
			<form:input path="name" />
		</p>
		<p>
			<form:errors class="text-danger" path="name" />
		</p>

		<input type="submit" value="Create Category" />
	</form:form>

</body>
</html>