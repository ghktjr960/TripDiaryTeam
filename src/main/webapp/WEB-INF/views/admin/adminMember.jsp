<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<c:if test="${empty darkmode}">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" 
	rel="stylesheet"/>
</c:if>
<c:if test="${not empty darkmode}">
	<link href="${pageContext.request.contextPath}/resources/css/darkstyle.css" 
	rel="stylesheet"/>
</c:if>
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />
	
	<div class="container">
		<h2>관리자 페이지</h2>
		<br>
		<button class="btn btn-secondary" onclick='location.href="/admin/member"'>회원관리</button>
		<button class="btn btn-outline-secondary" onclick='location.href="/admin/delmember"'>탈퇴회원관리</button>
		<button class="btn btn-outline-secondary" onclick='location.href="/admin/board"'>게시글관리</button>
		<button class="btn btn-outline-secondary" onclick='location.href="/admin/reply"'>댓글관리</button>
	</div>
	
	<div class="container" style="margin-top: 30px;">
		<form name="search" method="get" class="row" style="justify-content: end;">
			<div class="col-auto">
				<input class="form-control col-auto " type="text" name="memberId" id="memberId" placeholder="회원 ID검색" value="${memberId}">
			</div>
			<div class="col-auto">
				<input class="btn btn-primary" type="submit" value="검색" id="search">
			</div>
		</form>
		<form action="/admin/member" method="post" name="memberManage" onsubmit="return confirm('삭제하시겠습니까?');">
			<table class="table mb-5">
				<tr>
					<th>확인</th>
					<th>ID</th>
					<th>신고 처리 횟수</th>
					<th>신고한 횟수</th>
					<th>경고 횟수</th>
				</tr>
				<c:forEach items="${reportCnt}" var="reportCnt">
				<tr>
					<td>
						<input type="checkbox" name="memberNumList" value="${reportCnt.memberNum }">
					</td>
					<td>${reportCnt.id }</td>
					<td>${reportCnt.reportComCnt }</td>
					<td>${reportCnt.reportCnt }</td>
					<td>${reportCnt.warningCnt }</td>
				</tr>
				</c:forEach>
			</table>
			<input class="btn btn-outline-danger mb-5" type="submit" value="삭제하기">
		</form>
	</div>
	
</body>
</html>