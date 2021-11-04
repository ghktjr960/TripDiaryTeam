<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="fixedicon2" class="mb-5">
		<a href="/writeUpdate?boardNum=213"><img class="icon" alt="" src="resources/img/icon/write.png" style="width: 70px; margin-bottom: 12%;"></a>
		<c:if test="${not empty sessionScope.darkmode}">
			<a href="/darkmode"><img class="icon" alt="" src="resources/img/icon/darkmode.png" style="width: 70px; margin-bottom: 12%;"></a>
		</c:if>
		<c:if test="${empty sessionScope.darkmode}">
			<a href="/darkmode"><img class="icon" alt="" src="resources/img/icon/darkmode2.png" style="width: 70px; margin-bottom: 12%;"></a>
		</c:if>
		<a href="/write"><img class="icon" alt="" src="resources/img/icon/write.png" style="width: 70px; margin-bottom: 12%;"></a>
		<img class="icon" alt="" src="resources/img/icon/chat.png" style="width: 70px;">
	</div>
	
	<button id="fixedbtn" type="button" onclick="window.scrollTo(0,0);" class="btn btn-dark mb-5">▲ TOP</button>
</body>
</html>