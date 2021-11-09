<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Anton'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Neucha'
	rel='stylesheet' type='text/css'>
<c:if test="${empty darkmode}">
	<link href="${pageContext.request.contextPath}/resources/css/style.css"
		rel="stylesheet" />
</c:if>
<c:if test="${not empty darkmode}">
	<link
		href="${pageContext.request.contextPath}/resources/css/darkstyle.css"
		rel="stylesheet" />
</c:if>

<!-- 보드 이미지 슬라이드 -->
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>


<title>Trip Diary</title>
<link href="${pageContext.request.contextPath}/resources/css/slide.css"
	rel="stylesheet" />


</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
	<jsp:include page="common/sidebar.jsp" flush="false" />

	<div class="container">
		<div class="row shadow-lg">
			<div class="col-2"></div>
			<!-- profile사진, member닉네임, 게시글 내용, 작성일, 여행일  -->
			<form role="form" name="readForm" method="get"
				class="col-4 border border-secondary mt-5 mb-5">
				<div style="float: left;" class="mt-3">
					<img alt=""
						src="<spring:url value='/profile/${read.profileStoreFileName}'/>"
						class="border rounded-circle"
						style="width: 50px; height: 50px; object-fit: cover;">
					<c:out value="${read.nickname}" />
				</div>

				<!-- 찜하기 -->
				<div id="pick" style="float: right;" class="mb-3 mt-3">
					<!-- 없음, pickCheck테이블 검사해서 해당 보드넘버와 멤버넘버가 없으면 눌렀을 때 정보 받아서 insert -->
					<c:if test="${pickCheck eq null}">
						<!--  pickNum=${selectPick.pickNum }&-->
						<a
							href="/pickClick?boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }">
							<img alt="" src="resources/img/pick_basic_white.png" class=""
							style="width: 40px; height: 40px; object-fit: cover;">
						</a>
					</c:if>

					<!-- 있음, pickCheck테이블 검사해서 해당 보드넘버와 멤버넘버가 있으면 눌렀을 때 정보 받아서 delete -->
					<c:if test="${pickCheck ne null}">
						<a
							href="/pickClick?pickNum=${pickCheck.pickNum }&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }">
							<img alt="" src="resources/img/pick_basic_dark.png" class=""
							style="width: 40px; height: 40px; object-fit: cover;">
						</a>
					</c:if>
				</div>

				<!-- 게시글 사진 (슬라이드(script는 아래, CSS는 resources에 ) -->
				<div id="wrapper">
					<div id="slider-wrap">
						<ul id="slider" style="padding-left: 0;">
							<li><img alt=""
								src="<spring:url value='/thumbnail/${thumbnailImg.storeFileName}'/>"
								style="object-fit: cover"></li>
							<c:forEach items="${boardImgList }" var="boardImgList"
								varStatus="loop">
								<li><img alt=""
									src="<spring:url value='/boardImg/${boardImgList.storeFileName}'/>"
									style="object-fit: cover"></li>
							</c:forEach>
						</ul>

						<!--controls-->
						<div class="btns" id="next">
							<i class="fa fa-arrow-right"></i>
						</div>
						<div class="btns" id="previous">
							<i class="fa fa-arrow-left"></i>
						</div>

						<div id="pagination-wrap">
							<ul>
							</ul>
						</div>
						<!--controls-->
					</div>
				</div>

				<div>
					<c:if test="${tagList ne null}">
						<c:forEach items="${tagList}" var="tagList" varStatus="loop">
                  #${tagList.tag} &nbsp;
               </c:forEach>
					</c:if>
				</div>

				<!-- 좋아요 -->
				<div id="like">
					<!-- 없음, tdLikeCheck 검사해서 해당 보드넘버와 멤버넘버가 없으면 눌렀을 때 정보 받아서 insert -->
					<c:if test="${tdLikeCheck eq null}">
						<!--  pickNum=${selectPick.pickNum }&-->
						<a
							href="/likeClick?boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }&boardMemberNum=${read.boardMemberNum}">
							<img alt="" src="resources/img/heart_empty.png" class=""
							style="width: 40px; height: 40px; object-fit: cover;">
						</a>
					</c:if>

					<!-- 있음, tdLikeCheck 검사해서 해당 보드넘버와 멤버넘버가 있으면 눌렀을 때 정보 받아서 delete -->
					<c:if test="${tdLikeCheck ne null}">
						<a
							href="/likeClick?tdLikeNum=${tdLikeCheck.tdLikeNum }&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }&boardMemberNum=${read.boardMemberNum}">
							<img alt="" src="resources/img/heart.png" class=""
							style="width: 40px; height: 40px; object-fit: cover;">
						</a>
					</c:if>
					+ ${read.tdLikeCnt}
				</div>

				<br> <br>
			</form>
			<div class="col-1"></div>
			<div class="col-3" style="text-align: left">
				<div class="mt-5">
					작성일 :
					<fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd" />
					<br> 여행일 :
					<fmt:formatDate value="${read.tripdate}" pattern="yyyy-MM-dd" />
					<br>
					<div style="overflow: auto; height: 140px; padding-left: 3px;"
						class="border">게시글 내용 : ${read.content}</div>
					<br> <br>
				</div>

				<!-- 댓글 목록 -->
				<div style="overflow: auto; height: 320px;" class="mb-3 border">
					<ol class="replyList" style="padding-left: 3px;">
						<c:forEach items="${replyList}" var="replyList" varStatus="loop">
            
            ${replyList.nickname}  
            <fmt:formatDate value="${replyList.regdate}"
								pattern="yyyy-MM-dd HH:mm" />

							<!-- c:choose 예시 esle if 너낌? -->
							<c:choose>
								<c:when test="${memberVo.memberNum eq replyList.memberNum }">
									<a data-toggle="modal" href="#replyUpdate${replyList.replyNum}">
										수정 </a>
									<a
										href="/replyDelete?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }"
										onclick="alert('삭제 완료')"> 삭제 </a>
									<br>
								</c:when>
								<c:otherwise>
									<a href="#" onclick="alert('회원 아님')">삭제</a>
									<br>
								</c:otherwise>
							</c:choose>
							<a data-toggle="modal" href="#reportReply${replyList.replyNum}">
								신고 </a>

							<p>작성 내용 : ${replyList.content}</p>
						</c:forEach>
					</ol>
				</div>

				<!-- 댓글 작성 -->
				<div>
					<form action="/replyWrite" method="post" class="row">
						<input type="hidden" name="boardNum" value="${read.boardNum }">
						<input type="hidden" name="memberNum"
							value="${memberVo.memberNum }">
						<div class="col-9">
							<input type="text" id="content" name="content"
								class="form-control">
						</div>
						<div class="col-auto">
							<button class="btn btn-primary" type="submit">작성</button>
						</div>
					</form>
				</div>

			</div>
			<div class="col-2" style="text-align: right; padding-right: 0">
				<div>
					<button class="btn btn-outline-secondary" onclick="history.go(-1)">돌아가기</button>
				</div>
				<div>
					<button class="btn btn-outline-secondary mt-3"
						onclick="location.href='/writeUpdate?boardNum=${read.boardNum}'">수정하기</button>
				</div>
				<div>
					<button class="btn btn-outline-secondary mt-3"
						onclick="location.href='/delete?boardNum=${read.boardNum}'">삭제하기</button>
				</div>
				<div>
					<button type="button" class="btn btn-outline-secondary mt-3"
						data-toggle="modal" data-target="#reportBoard">신고하기</button>
				</div>
			</div>
		</div>
	</div>

	<c:forEach items="${replyList}" var="replyList" varStatus="loop">
		<div class="modal fade" id="replyUpdate${replyList.replyNum}"
			tabindex="-1" role="dialog" aria-labelledby="modal"
			aria-hidden="true">
			<div class="modal-dialog modal-sm mt-5">
				<div class="modal-content">
					<form action="/replyUpdate" method="POST">
						<div class="modal-header">
							<h5 class="modal-title" id="modal">댓글수정</h5>
							<button type="button" class="btn-close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true"></span>
							</button>
						</div>

						<div class="modal-body" style="text-align: center">
							<input type="hidden" id="replyNum" name="replyNum"
								value="${replyList.replyNum}" readonly="readonly" /> <input
								type="hidden" id="boardNum" name="boardNum"
								value="${read.boardNum}" readonly="readonly" /> <input
								type="hidden" id="memberNum" name="memberNum"
								value="${memberVo.memberNum }" readonly="readonly">
							<textarea class="form-control" name="content">${replyList.content}</textarea>
						</div>
						<div class="modal-footer">
							<div>
								<input type="submit" class="btn btn-primary" value="작성">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" style="margin: auto;">닫기</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>

	<div class="modal fade" id="reportBoard" tabindex="-1" role="dialog"
		aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog mt-5">
			<div class="modal-content">
				<form action="/report/board" method="POST">
					<div class="modal-header">
						<h5 class="modal-title" id="modal">게시글 신고</h5>

					</div>

					<div class="modal-body" style="text-align: center">
						<input type="hidden" name="boardNum" id="boardNum"
							value="${read.boardNum}"> <input type="hidden"
							name="reportReceive" id="reportReceive" value="${read.id}">
						<input type="hidden" name="memberNumReceive" id="memberNumReceive"
							value="${read.memberNum}"> <input type="hidden"
							name="reportSend" id="reportSend" value="${authInfo.id}">
						<input type="hidden" name="memberNumSend" id="memberNumSend"
							value="${authInfo.memberNum}"> <select id="reportType"
							name="reportType" class="form-select mb-3">
							<option selected disabled hidden>신고사유 선택</option>
							<option value="부적절한 홍보 게시글">부적절한 홍보 게시글</option>
							<option value="음란성 또는 청소년에게 부적합한 내용">음란성 또는 청소년에게 부적합한
								내용</option>
							<option value="저작권 침해">저작권 침해</option>
							<option value="명예훼손 또는 사생활 침해">명예훼손 또는 사생활 침해</option>
							<option value="불법 촬영물 등 신고">불법 촬영물 등 신고</option>
							<option value="기타">기타</option>
						</select><br> 신고 상세내용
						<textarea class="form-control" rows="" cols=""
							name="reportContent"></textarea>
					</div>
					<div class="modal-footer">
						<div>
							<input type="submit" class="btn btn-danger" value="신고">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" style="margin: auto;">닫기</button>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>

	<c:forEach items="${replyList}" var="replyList" varStatus="loop">
		<div class="modal fade" id="reportReply${replyList.replyNum}"
			tabindex="-1" role="dialog" aria-labelledby="modal"
			aria-hidden="true">
			<div class="modal-dialog mt-5">
				<div class="modal-content">
					<form action="/report/reply" method="POST">
						<div class="modal-header">
							<h5 class="modal-title" id="modal">댓글 신고</h5>

						</div>

						<div class="modal-body" style="text-align: center">
							<input type="hidden" name="boardNum" id="boardNum"
								value="${read.boardNum}"> 
							<input type="hidden"
								name="replyNum" id="replyNum" value="${replyList.replyNum}">
							<input type="hidden" name="replyContent" id="replyContent"
								value="${replyList.content}"> 
							<input type="hidden" name="reportReceive" id="reportReceive"
								value="${replyList.id}"> 
							<input type="hidden" name="memberNumReceive" id="memberNumReceive"
								value="${replyList.memberNum}"> 
							<input
								type="hidden" name="reportSend" id="reportSend"
								value="${authInfo.id}"> 
							<input type="hidden"
								name="memberNumSend" id="memberNumSend"
								value="${authInfo.memberNum}"> 
							<select id="reportType"
								name="reportType" class="form-select mb-3">
								<option selected disabled hidden>신고사유 선택</option>
								<option value="부적절한 홍보 게시글">부적절한 홍보 게시글</option>
								<option value="음란성 또는 청소년에게 부적합한 내용">음란성 또는 청소년에게 부적합한
									내용</option>
								<option value="저작권 침해">저작권 침해</option>
								<option value="명예훼손 또는 사생활 침해">명예훼손 또는 사생활 침해</option>
								<option value="불법 촬영물 등 신고">불법 촬영물 등 신고</option>
								<option value="기타">기타</option>
							</select><br> 신고 상세내용
							<textarea class="form-control" rows="" cols=""
								name="reportContent"></textarea>
						</div>
						<div class="modal-footer">
							<div>
								<input type="submit" class="btn btn-danger" value="신고">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" style="margin: auto;">닫기</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>

	<script
		src="${pageContext.request.contextPath}/resources/js/slideShow.js"></script>
</body>
</html>