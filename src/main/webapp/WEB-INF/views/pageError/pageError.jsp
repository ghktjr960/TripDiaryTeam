<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Trip Diary</title>

</head>
<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />
	
	<div class="container">
			<div class="container">
				<img alt="" src="${pageContext.request.contextPath}/resources/img/pageError.png" style="width: 40%;">
			</div>	
			<div class="container">
				<h1>
					홈페이지 이용에<br>
					불편을 드려서 죄송합니다.<br>
				</h1><br>
				<h3>
					현재 발생한 오류는 관리자가 확인중에 있으니<br>
					잠시후에 이용해 주시기 바랍니다.
				</h3><br>
				<button onclick='location.href="/main"'>메인페이지</button>
			</div>
	</div>
</body>
</html>