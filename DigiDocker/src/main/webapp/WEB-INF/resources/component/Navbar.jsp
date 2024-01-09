<!-- Start NavBar -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i
			class="fa-solid fa-file-import me-2"></i>DigiDocker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${pageContext.request.contextPath}/home"><i class="fa-solid fa-house"></i>
						Home</a></li>

				<c:if test="${not empty userObj }">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/AddDocument">Add
							Document</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/ViewDocument">View
							Document</a></li>
				</c:if>
			</ul>
			
			<form class="d-flex">
				<c:if test="${empty userObj }">
					<a href="${pageContext.request.contextPath}/login"
						class="btn btn-outline-info btn-lg px-3 me-sm-3 fw-bold"
						type="submit">Login</a>
					<a href="${pageContext.request.contextPath}/register" class="btn btn-outline-light btn-lg px-3"
						type="submit">Register</a>
				</c:if>

				<c:if test="${not empty userObj }">
					<a href="#"
						class="btn btn-outline-info btn-lg px-3 me-sm-3 fw-bold"
						type="submit"> <i class="fa-solid fa-user me-2"></i>${userObj.fullname }</a>
					<a href="${pageContext.request.contextPath}/user/logout" class="btn btn-outline-light btn-lg px-3"
						type="submit">logout</a>
				</c:if>

			</form>
		</div>
	</div>
</nav>
<!-- End NavBar -->
