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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>
<c:if test="${empty darkmode}">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" 
	rel="stylesheet"/>
</c:if>
<c:if test="${not empty darkmode}">
	<link href="${pageContext.request.contextPath}/resources/css/darkstyle.css" 
	rel="stylesheet"/>
</c:if>

<!-- 보드 이미지 슬라이드 -->
<!-- 제이쿼리 -->
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

	
<title>Trip Diary</title>
<link href="${pageContext.request.contextPath}/resources/css/slide.css" rel="stylesheet"/>

 	
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />
	<jsp:include page="common/sidebar.jsp" flush="false" />
    
	<div class="container">
		<a href="/list">목록으로</a>
		<hr />
		
		<!-- profile사진, member닉네임, 게시글 내용, 작성일, 여행일  -->
		<form role="form"  name="readForm" method="get">
			<div>
				<img alt="" src="<spring:url value='/image/profile_64.png'/>" style="width: 40px; height: 40px; ">  
				<c:out value="${read.nickname}" />
				
				<div> 보드 이미지 : 
					<c:forEach items="${boardImgList }" var="boardImgList" varStatus="loop">
					<c:out value="${boardImgList.storeFileName}.${boardImgList.fileType}" />
					</c:forEach>
				</div>
			</div>
			
			<!-- 찜하기 -->
			<div id="pick" >
				<!-- 없음, pickCheck테이블 검사해서 해당 보드넘버와 멤버넘버가 없으면 눌렀을 때 정보 받아서 insert -->
				<c:if test="${pickCheck eq null}">
				<!--  pickNum=${selectPick.pickNum }&-->
					<a href="/pickClick?boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >
						<img alt="" src="resources/img/pick_basic_white.png" class=""
										style="width: 40px; height: 40px; object-fit: cover;">
					</a>
				</c:if>
				
				<!-- 있음, pickCheck테이블 검사해서 해당 보드넘버와 멤버넘버가 있으면 눌렀을 때 정보 받아서 delete -->
				<c:if test="${pickCheck ne null}">
					<a href="/pickClick?pickNum=${pickCheck.pickNum }&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >
						<img alt="" src="resources/img/pick_basic_dark.png" class=""
											style="width: 40px; height: 40px; object-fit: cover;">
					</a>
				</c:if>
			</div>
			
			<!-- 게시글 사진 (슬라이드(script는 아래, CSS는 resources에 ) -->
			<div id="wrapper">
		      <div id="slider-wrap">
		          <ul id="slider"  style="padding-left: 0;">
		          	 <c:forEach items="${boardImgList }" var="boardImgList" varStatus="loop">
		             	<li>
		             		<img alt="" src="<spring:url value='/thumbnail/${boardImgList.storeFileName}'/>" style="object-fit : cover">
		             	</li>
					</c:forEach>
		             <li>           
						<img alt="" src="<spring:url value='/image/test1.png'/>" style="object-fit : cover">
		             </li>
		             <li>
						<img alt="" src="<spring:url value='/image/test2.png'/>" style="object-fit : cover">
				     </li>
		             
		             <li>
						<img alt="" src="<spring:url value='/image/test3.jpg'/>" style="object-fit : cover">
		             </li>
		             
		             <li>
						<img alt="" src="<spring:url value='/image/test4.jpg'/>" style="object-fit : cover">
		             </li>
		          </ul>
		          
		           <!--controls-->
		          <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
		          <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
		          
		          <div id="pagination-wrap">
		            <ul>
		            </ul>
		          </div>
		          <!--controls-->  
		      </div>
		   </div>
			
			<!-- 좋아요 -->
			<div id="like" >
				<!-- 없음, tdLikeCheck 검사해서 해당 보드넘버와 멤버넘버가 없으면 눌렀을 때 정보 받아서 insert -->
				<c:if test="${tdLikeCheck eq null}">
				<!--  pickNum=${selectPick.pickNum }&-->
					<a href="/likeClick?boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >
						<img alt="" src="resources/img/heart_empty.png" class=""
										style="width: 40px; height: 40px; object-fit: cover;">
					</a>
				</c:if>
				
				<!-- 있음, tdLikeCheck 검사해서 해당 보드넘버와 멤버넘버가 있으면 눌렀을 때 정보 받아서 delete -->
				<c:if test="${tdLikeCheck ne null}">
					<a href="/likeClick?tdLikeNum=${tdLikeCheck.tdLikeNum }&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >
						<img alt="" src="resources/img/heart.png" class=""
											style="width: 40px; height: 40px; object-fit: cover;">
					</a>
				</c:if>
				+ ${read.tdLikeCnt}
			</div>
			
			
			<div>
				<c:if test="${tagList ne null}">
					<c:forEach items="${tagList}" var="tagList" varStatus="loop">
						#${tagList.tag} &nbsp;
					</c:forEach>
				</c:if>	
			</div>
			
			<div>
				좋아요
			</div>
			
			<div>
				작성일 : <fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/><br>
				여행일 : <fmt:formatDate value="${read.tripdate}" pattern="yyyy-MM-dd"/><br>
				게시글 내용 : ${read.content}<br><br>
			</div>
			<hr />
			<br><br>
		</form>
		
		
		
			<div>

				
				
			</div>
			
			<!-- 댓글 작성 -->
			<div>
				<form action="/replyWrite" method="post">
					<input type="hidden" name="boardNum" value="${read.boardNum }">
					<input type="hidden" name="memberNum" value="${memberVo.memberNum }">
					
					<input type="text" id="content" name="content">  
					<button type="submit">작성</button>
				</form>
			</div>
			
			<!-- 댓글 목록 -->
			<div >
			<ol class="replyList">
				<c:forEach items="${replyList}" var="replyList" varStatus="loop">
				
				${replyList.nickname}  
				<fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd HH:mm" />   
				<a href="/replyUpdate?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" >수정</a>  
               
				<!-- c:choose 예시 esle if 너낌? -->
				<c:choose>
					<c:when test="${memberVo.memberNum eq replyList.memberNum }">
						<a href="/replyDelete?replyNum=${replyList.replyNum}&boardNum=${read.boardNum }&memberNum=${memberVo.memberNum }" onclick="alert('삭제 완료')">삭제</a><br>
					</c:when>
					<c:otherwise>
						<a href="#" onclick="alert('회원 아님')">삭제</a><br>
					</c:otherwise>
				</c:choose>
				
				<p>작성 내용 : ${replyList.content}</p>
				</c:forEach>   
				</ol>
			</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/resources/js/slideShow.js"></script>
</body>
</html>