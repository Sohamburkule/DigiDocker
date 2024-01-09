<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Document</title>
<%@include file="/WEB-INF/resources/component/All_Link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/Navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-header text-center">
						<h3>Add your Documents here</h3>
						<c:if test="${not empty msg }">
							<p class="mb-3 text-success">${msg }</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="saveDocuments" method="post"
							enctype="multipart/form-data">

							<div class="mb-3">
								<label>Enter Title</label> <input type="text" name="Title"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label for="formFile" class="form-label">Insert File
									Here</label> <input class="form-control" type="file" name="File"
									id="formFile">
							</div>

							<div class="mb-3">
								<label>Enter Description</label>
								<textarea rows="5" cols="" class="form-control"
									name="Description" required></textarea>
							</div>

							<button class="btn btn-primary">Save</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>