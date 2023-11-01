<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="/WEB-INF/resources/component/All_Link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/Navbar.jsp"%>
	<div class="card bg-dark text-white">
		<div class="py-5">
			<h1 class="display-5 fw-bold text-white text-center">Welcome to
				DigiDocker</h1>
			<div class="col-lg-6 mx-auto">
				<p class="fs-6 mb-4 text-center">Effortlessly Manage, Organize,
					and Secure Your Documents Online</p>
				<p class="fs-5 mb-4">"Thank you for choosing DigiDocker,your
					ultimate destination for seamless document management and
					organization. Say goodbye to the hassle of paper clutter and
					welcome the convenience of a digital document paradise!
				<p class="fs-5 mb-4">With DigiDocker, you can effortlessly
					upload, organize, and access your documents from anywhere, at any
					time. We've designed this platform to simplify your life and boost
					your productivity, all while keeping your precious documents safe
					and secure.</p>

				<c:if test="${empty userObj }">
					<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
						<a href="${pageContext.request.contextPath}/login">
							<button type="button"
								class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">Create</button>
						</a>
						<button type="button" class="btn btn-outline-light btn-lg px-4">Explore</button>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>