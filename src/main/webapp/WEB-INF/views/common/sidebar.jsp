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


<!-- 카카오톡 채널 스크립트 -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>
    Kakao.init('d21da3744ebeea9a10c9a6f6aa2244c4'); // 사용할 앱의 JavaScript키를 입력해 주세요.
    function kakaoChatStart() {
        Kakao.Channel.chat({
            channelPublicId: '_JxcWhb' // 카카오톡 채널 홈 URL에 명시된 ID를 입력합니다.
        });
    }
</script>



	<div id="fixedicon2" class="mb-5">
		<a href="/writeUpdate?boardNum=213"><img class="icon" alt="" src="../${pageContext.request.contextPath}/resources/img/icon/write.png" style="width: 70px; margin-bottom: 12%;"></a>
		<c:if test="${not empty sessionScope.darkmode}">
			<a href="/darkmode"><img class="icon" alt="" src="../${pageContext.request.contextPath}/resources/img/icon/darkmode.png" style="width: 70px; margin-bottom: 12%;"></a>
		</c:if>
		<c:if test="${empty sessionScope.darkmode}">
			<a href="/darkmode"><img class="icon" alt="" src="../${pageContext.request.contextPath}/resources/img/icon/darkmode2.png" style="width: 70px; margin-bottom: 12%;"></a>
		</c:if>
		<a href="/write"><img class="icon" alt="" src="../${pageContext.request.contextPath}/resources/img/icon/write.png" style="width: 70px; margin-bottom: 12%;"></a>
		<a href="javascript:void kakaoChatStart()" hidden-md hidden-sm hidden-xs">
		<img class="icon" alt="" src="../${pageContext.request.contextPath}/resources/img/icon/chat.png" style="width: 70px;">
		</a>
	</div>
	
	<button id="fixedbtn" type="button" onclick="window.scrollTo(0,0);" class="btn btn-dark mb-5">▲ TOP</button>
</body>
</html>