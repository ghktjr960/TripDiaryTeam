<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />

	<div class="container">
		<h2>로그인 페이지</h2>
		
		<form name='homeForm' method="post" action="/signIn">
			<div>
				<label for="userId"></label> <input type="text" id="userId"
					name="userId">
			</div>
			<div>
				<label for="userPass"></label> <input type="password" id="userPass"
					name="userPass">
			</div>
			<br>
			<div>
				<input type="submit" value="Sing In">
			</div>
		</form>
	</div>




</body>
</html>