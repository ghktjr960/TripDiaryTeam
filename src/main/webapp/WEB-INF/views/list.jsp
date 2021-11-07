<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="${pageContext.request.contextPath}/resources/css/style.css" 
	rel="stylesheet"/>

<title>메인</title>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
    <jsp:include page="common/sidebar.jsp" flush="false" />
	<div class="container">
			<div>
				<form action="" method="get">
					<table>
						<tr>
							<th>게시글 번호</th> <th>닉네임</th> <th>작성일자</th> <th>여행일자</th>
						</tr>
						
						<c:if test="${list ne null }">
							<c:forEach items="${list}" var="list" varStatus="loop">
								<tr>
									<td><a href="/readView?boardNum=${list.boardNum }">${list.boardNum}</a></td>
									<td>${list.nickname }</td>
									<td>${list.regdate }</td>
									<td>${list.tripdate }</td>
								</tr>
							</c:forEach>
						</c:if>
					
					</table>
				</form>
			</div>
			
		<hr />
	</div>
</body>
</html>