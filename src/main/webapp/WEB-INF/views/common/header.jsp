<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

	<nav class="navbar navbar-expand-lg navbar-light bg-light header shadow">
	<c:if test="${empty sessionScope.darkmode }">
		<a class="logo" href="/main"><img alt="" src="resources/img/icon/logo.png"></a>
	</c:if>
	<c:if test="${not empty sessionScope.darkmode }">
		<a class="logo" href="/main"><img alt="" src="resources/img/icon/darklogo.png"></a>
	</c:if>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/main">Main</a>
				</li>
				<c:if test="${not empty sessionScope.id }">
					<li class="nav-item active">
						<a class="nav-link" href="/diary?memberNum=${sessionScope.memberNum }">MyDiary</a>
					</li>
				</c:if>
				<c:if test="${not empty sessionScope.id }">
					<li class="nav-item active">
						<a class="nav-link" href="/pick">Pick!</a>
					</li>
				</c:if>
				<li class="nav-item active">
					<a class="nav-link" href="/about">About</a>
				</li>
				<c:if test="${not empty sessionScope.admin }">
					<li class="nav-item active">
						<a class="nav-link" href="/admin">Adimin</a>
					</li>
				</c:if>
			</ul>
			
			<ul class="navbar-nav ms-auto">
				<c:if test="${empty sessionScope.id }">
					<li class="nav-item active">
						<a class="nav-link" href="/signIn">Sign in</a>
					</li>
				</c:if>
				<c:if test="${not empty sessionScope.id }">
					<div>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle " id="dropdown" data-toggle="dropdown">
								<img alt="" src="<spring:url value='/profile/${profile.storeFileName }'/>" class="border rounded-circle" style="width: 50px; height: 50px; object-fit: cover;">
							</a>
							<div class="dropdown-menu" aria-labelledby="dropdown">
								<a class="dropdown-item" href="myPage">MyPage</a>
								<a class="dropdown-item" href="signOut">Sign Out</a>
							</div>
						</li>
					</div>
				</c:if>
			</ul>
					
		</div>	
	</nav>
	
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/popper.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>	
