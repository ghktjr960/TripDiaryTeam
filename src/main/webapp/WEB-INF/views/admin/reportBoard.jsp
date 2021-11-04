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
		<c:choose>
			<c:when test="${reportBoardList eq null}">
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
				<form action="/admin/board" method="post" name="reportBoard">
					<table>
						<tr>
							<th>확인</th>
							<th>게시글 번호</th>
							<th>신고날짜</th>
							<th>신고자 아이디</th>
							<th>피신고자 아이디</th>
							<th>신고 사유</th>
							<th>신고 상세 사유</th>
						</tr>
						<c:forEach items="${reportBoardList}" var="reportBoardList">
						<tr>
							<td>
								<input type="checkbox" name="reportBoardNumList" value="${reportBoardList.reportBoardNum}">
							</td>
							<td>
								<a href="/board?boardNum=${reportBoardList.boardNum}&memberNum=${reportBoardList.memberNumReceive}">
									${reportBoardList.boardNum }
								</a>
							</td>
							<td><fmt:formatDate value="${reportBoardList.reportDate}" pattern="yyyy-MM-dd" /></td>
							<td>${reportBoardList.reportSend }</td>
							<td>${reportBoardList.reportReceive }</td>
							<td>${reportBoardList.reportType }</td>
							<td>${reportBoardList.reportContent }</td>
						</tr>						
						</c:forEach>
					</table>
					<button type="submit" name="prom" value="Y">게시글삭제</button>
					<button type="submit" name="prom" value="N">문제없음</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	

</body>
</html>