<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Document</title>
<%@include file="/WEB-INF/resources/component/All_Link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/Navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-header text-center">
						<h3>Update Documents</h3>
						<c:if test="${not empty msg }">
							<p class="mb-3 text-success">${msg }</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="updateDocuments" method="post"
							enctype="multipart/form-data">

							<div class="mb-3">
								<label>Enter Title</label> <input type="text" name="Title"
									class="form-control" value="${documents.title }" required>
							</div>

							<div class="mb-3">
								<label for="formFile" class="form-label">Insert File
									Here</label> <input class="form-control" type="file" name="File"
									id="formFile" value="data:image/jpeg;base64,${documents.fileData}">
							</div>

							<div class="mb-3">
								<label>Enter Description</label>
								<textarea rows="5" cols="" class="form-control"
									name="Description" required>${documents.description }</textarea>
							</div>
							<input type="hidden" name="id" value="${documents.id}">
							<button class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>