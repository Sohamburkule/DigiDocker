<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewDocument</title>
<%@include file="/WEB-INF/resources/component/All_Link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/Navbar.jsp"%>
	<div class="container py-5">
		<h2 class="text-center">Safe Document Locker</h2>
		<c:if test="${not empty msg }">
			<p class="mb-3 text-success">${msg }</p>
			<c:remove var="msg" />
		</c:if>
		<div class="row row-cols-1 row-cols-md-3 g-4 py-5">
			<c:forEach items="${list}" var="n">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<%-- Encode byte array to Base64 using Java code --%>
								<img src="data:image/jpeg;base64,${n.fileData}" width="50px"
									height="50px" alt="">
							</div>

							<h5 class="text-center">${n.title }</h5>
							<p class="text-center">${n.description }</p>


							<div class="text-center justify-content-around">
								<a href="" class="btn btn-primary btn-sm">Download</a> <a
									href="deleteDocuments?id=${n.id }"
									class="btn btn-danger btn-sm">Delete</a> <a
									href="editDocuments?id=${n.id }"
									class="btn btn-secondary btn-sm">Update</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>