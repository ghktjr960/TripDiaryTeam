<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<input type="text" name="memberId" id="memberId" placeholder="ID검색" value="${memberId}">
			<input type="submit" value="검색" id="search">
		</form>
		
		<c:choose>
			<c:when test="${delMember eq null }">
				<div class="container">
					<div class="container">
						<img alt="" src="${pageContext.request.contextPath}/resources/img/error.png" style="width: 30%;">
					</div>
					<div class="container">
						<h1>검색 결과가 없습니다.</h1>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<form action="/admin/delmember" method="post" name="delMember" onsubmit="return confirm('탈퇴 처리를 하시겠습니까?');">
					<table>
						<tr>
							<th>확인</th>
							<th>회원 번호</th>
							<th>ID</th>
							<th>탈퇴 신청</th>
							<th>탈퇴 신청 날짜</th>
							<th>탈퇴 처리 날짜</th>
						</tr>
						<c:forEach items="${delMember}" var="delMember">
						<tr>
							<td>
								<input type="checkbox" name="memberNumList" value="${delMember.memberNum }">
							</td>
							<td>${delMember.memberNum }</td>
							<td>${delMember.memberId }</td>
							<td>${delMember.timeover }</td>
							<td><fmt:formatDate value="${delMember.delDate }" pattern="yyyy-MM-dd" /></td>
							<td>하 하 하</td>
						</tr>
						</c:forEach>
					</table>
					<input type="submit" value="삭제하기">
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>