<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
							<p class="fs-3 fw-bold text-success">${msg }</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="saveNotes" method="post">
							<div class="mb-3">
								<label>Enter Title</label> <input type="text" name="title"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label" for="customFile">Default file
									input example</label> <input type="file" class="form-control"
									id="customFile" />
							</div>

							<div class="mb-3">
								<label>Enter Description</label>
								<textarea rows="6" cols="" class="form-control"
									name="descrption"></textarea>
							</div>

							<button class="btn btn-primary mt-4">Save</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>