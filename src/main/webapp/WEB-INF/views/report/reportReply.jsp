<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	
		<input type="hidden" name="boardNum" id="boardNum" value="${reportReplyVo.boardNum}">
		<input type="hidden" name="replyNum" id="replyNum" value="${reportReplyVo.replyNum}">
		<input type="hidden" name="replyContent" id="replyContent" value="${reportReplyVo.replyContent}">
		<input type="hidden" name="reportReceive" id="reportReceive" value="${reportReplyVo.reportReceive}">
		<input type="hidden" name="memberNumReceive" id="memberNumReceive" value="${reportReplyVo.memberNumReceive}">
		<input type="hidden" name="reportSend" id="reportSend" value="${authInfo.id}">
		<input type="hidden" name="memberNumSend" id="memberNumSend" value="${authInfo.memberNum}">
		
		<select id="reportType" name="reportType"  class="form-select mb-3">
			<option selected disabled hidden>신고사유 선택</option>
			<option value="부적절한 홍보 게시글">부적절한 홍보 게시글</option>
			<option value="음란성 또는 청소년에게 부적합한 내용">음란성 또는 청소년에게 부적합한 내용</option>
			<option value="저작권 침해">저작권 침해</option>
			<option value="명예훼손 또는 사생활 침해">명예훼손 또는 사생활 침해</option>
			<option value="불법 촬영물 등 신고">불법 촬영물 등 신고</option>
			<option value="기타">기타</option>
		</select>
		<br>
		
		<textarea name="reportContent" id="reportContent" ></textarea>
		<br>
	
	<button type="submit" onclick="alert('신고가 완료되었습니다.')">신고하기</button>
	<button type="button" onclick='location.href="/readView?boardNum=${reportReplyVo.boardNum}&memberNum=${reportReplyVo.memberNumReceive}"'>돌아가기</button>
				
	</form>
	
	
</body>
</html>