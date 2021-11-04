<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 풀캘린더 오픈소스 -->
<link href='/resources/fullcalendar/main.min.css' rel='stylesheet' />
<script src='/resources/fullcalendar/main.min.js'></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<c:if test="${empty darkmode}">
	<link rel="stylesheet" href="/resources/css/style.css" />
</c:if>
<c:if test="${not empty darkmode}">
	<link rel="stylesheet" href="/resources/css/darkstyle.css" />
</c:if>
<title>TripDiary</title>
</head>
<body>
	<!-- 상단바 -->
	<jsp:include page="common/header.jsp" flush="false" />

	<div class="container">
		<div class="diary-top row">
			<div class="diary_profile_img col-sm-4">
				<div style="width: 240px; height: 240px; margin: auto;">
					<a data-toggle="modal" href="#profileUpdateModal"> <img
						src="<spring:url value='/profile/${profile.storeFileName}'/>"
						class="border border-secondary rounded-circle image-profile icon2"
						style="width: 100%;">
					</a>
				</div>
				<h2 class="mt-3"><c:out value="${profile.nickname}" /></h2>
				<h6 class="mb-5" style="width: 240px; margin: auto;"><c:out value="${profile.message}" /></h6>

			</div>
			<div class="col-sm-3 mt-5 mb-5">
				<div class="row">
					<div class="col-4">
					<c:if test="${empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#emblemModal"> <img class="icon"
							src='<c:url value="${pageContext.request.contextPath }/resources/img/icon/emblem_cnt.png"/>' style="width: 100%;">
						</a> <br>
					</c:if>
					<c:if test="${not empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#emblemModal"> <img class="icon"
							src='<c:url value="${pageContext.request.contextPath }/resources/img/icon/darkemblem_cnt.png"/>' style="width: 100%;">
						</a> <br>
					</c:if>
						<br>
						<b>${fn:length(haveEmblem) }</b>
					</div>
					<div class="col-4">
					<c:if test="${empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#boardModal" onclick="openModal();"> <img class="icon"
							src="<c:url value="${pageContext.request.contextPath }/resources/img/icon/board_cnt.png"/>" style="width: 100%;">
						</a> <br>
					</c:if>
					<c:if test="${not empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#boardModal" onclick="openModal();"> <img class="icon"
							src="<c:url value="${pageContext.request.contextPath }/resources/img/icon/darkboard_cnt.png"/>" style="width: 100%;">
						</a> <br>
					</c:if>
						<br>
						<b>${actCnt.boardWriteCnt }</b>
					</div>
					<div class="col-4">
					<c:if test="${empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#pickModal"> <img class="icon"
							src="<c:url value="${pageContext.request.contextPath }/resources/img/icon/pick_cnt.png"/>" style="width: 100%;">
						</a> <br>
					</c:if>
					<c:if test="${not empty sessionScope.darkmode}">
						<a data-toggle="modal" href="#pickModal"> <img class="icon"
							src="<c:url value="${pageContext.request.contextPath }/resources/img/icon/darkpick_cnt.png"/>" style="width: 100%;">
						</a> <br>
					</c:if>
						<br>
						<b>${actCnt.pickPressCnt }</b>
					</div>
				</div>
			</div>
			<div class="diary_calendar col-sm-5 mb-5">
				<div id='calendar' class="diaryCalendar"></div>
			</div>
		</div>

		<!-- 전체 게시물 부분  -->
		<div class="diary-mid row mt-5 mb-5">
		<c:forEach var="board" items="${diaryBoardList }" varStatus="loop">
			<div class="col-lg-4 diary-board-container">
				<div class="border border-secondary p-3 icon2 shadow">
					<div class="board-top">
						<div style="float: left;">
							<!-- 프로필 이미지와 닉네임 -->
							<img alt="" src="<spring:url value='/profile/${board.profileFileName}'/>"
								class="border rounded-circle"
								style="width: 50px; height: 50px; object-fit: cover;"> ${board.nickname }
						</div>
						<!-- pick 이미지 -->
						<div style="float: right; display: inline-block;" class="">
						<c:if test="${not empty darkmode}">
							<img alt="" src="resources/img/icon/pick_cnt2.png"
								class="pick-img"
								style="width: 40px; height: 40px; object-fit: cover;">
						</c:if>
						<c:if test="${empty darkmode}">
							<img alt="" src="resources/img/icon/pick_cnt.png"
								class="pick-img"
								style="width: 40px; height: 40px; object-fit: cover;">
						</c:if>
						</div>
					</div>
					<!-- 썸네일 이미지 -->
					<div class="board-mid">
						<img class="image-thumbnail border border-secondary mt-3"
							src="<spring:url value='/thumbnail/${board.boardFileName}'/>" style="width: 100%;">
					</div>

					<!-- 하단 정보부분 -->
					<div class="board-bottom mt-5 mb-3">
						<div>여행날짜 : ${fn:substring(board.tripdate,0,10) }</div>
						<div>좋아요 ${board.tdLikeCnt }개</div>
						<div>
							<c:forEach items="${board.tag }" var="tag" varStatus="loop">
								<a href="#" style="color: #2883f3">#${tag }&nbsp;</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<c:if test="${empty diaryBoardList}">
			<c:if test="${empty darkmode}">
				<img class="mb-5" alt=""src="resources/img/icon/nosearch.png">
			</c:if>
			<c:if test="${not empty darkmode}">
				<img class="mb-5" alt=""src="resources/img/icon/darknosearch.png">
			</c:if>
		</c:if>
		<c:if test="${not empty diaryBoardList}">
			<nav aria-label="Page navigation example">
				<ul class="pagination pagination-lg mb-5" style="justify-content: center;">
					<li class="page-item"><a class="page-link"
						href="diary?memberNum=${profile.memberNum }&pageNum=${page.startPage + 2 - page.countPage}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

					<c:forEach var="i" begin="${page.startPage }"
						end="${page.endPage }">
						<li class="page-item <c:if test="${ page.currentPage eq i}">active</c:if> "><a class="page-link"
							href="diary?memberNum=${profile.memberNum }&pageNum=${i}">${i}</a></li>
					</c:forEach>

					<c:if test="${page.block > page.endPage}">
						<li class="page-item"><a class="page-link"
							href="diary?memberNum=${profile.memberNum }&pageNum=${page.startPage + page.countPage}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</c:if>
	</div>
		
		



	<!-- 모달 jsp -->
	<jsp:include page="common/modal.jsp" flush="false" />
	
	<!-- 사이드 바 -->
	<jsp:include page="common/sidebar.jsp" flush="false" />

</body>
</html>