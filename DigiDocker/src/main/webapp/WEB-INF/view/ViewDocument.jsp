<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewDocument</title>
<%@include file="/WEB-INF/resources/component/All_Link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/Navbar.jsp"%>
<body>
	<div class="container py-5">
		<h2 class="text-center">Safe Document Locker</h2>
		<c:forEach items="${list}" var="list">
			<div class="row row-cols-1 row-cols-md-3 g-4 py-5">
				<div class="col">
					<div class="card">
						<div class="card-body">
							
							<h5>${list.FileTitle }</h5>
							<p class="card-text">${list.FileDescription }</p>
						</div>
						<div class="mb-5 d-flex justify-content-around">
							<button class="btn btn-primary">View</button>
							<button class="btn btn-danger">Delete</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="col">
			<div class="card">
				<img src="" class="card-img-top" alt="...">
				<div class="card-body">
					<h5>Default Card</h5>
					<p class="card-text">Default Card</p>
				</div>
				<div class="mb-5 d-flex justify-content-around">
					<button class="btn btn-primary">View</button>
					<button class="btn btn-danger">Delete</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>