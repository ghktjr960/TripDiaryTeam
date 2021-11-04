<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />
	
	<div class="container">
		<h2>관리자 페이지</h2>
		<br>
		<button onclick='location.href="/admin/member"'>회원관리</button>
		<button onclick='location.href="/admin/delmember"'>탈퇴회원관리</button>
		<button onclick='location.href="/admin/board"'>게시글관리</button>
		<button onclick='location.href="/admin/reply"'>댓글관리</button>
	</div>
	
	<div class="container">
		<form name="search" method="get">
			회원검색
			<input type="text" name="id" id="id" placeholder="ID검색">
			<input type="submit" value="검색" id="search">
		</form>
		<form action="/admin/member" method="post" name="memberManage" onsubmit="return confirm('삭제하시겠습니까?');">
			<table>
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
			<input type="submit" value="삭제하기">
		</form>
	</div>
	
</body>
</html>