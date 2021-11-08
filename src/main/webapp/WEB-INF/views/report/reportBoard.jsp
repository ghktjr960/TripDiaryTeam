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
		<input type="hidden" name="boardNum" id="boardNum" value="${reportBoardVo.boardNum}">
		<input type="hidden" name="reportReceive" id="reportReceive" value="${reportBoardVo.reportReceive}">
		<input type="hidden" name="memberNumReceive" id="memberNumReceive" value="${reportBoardVo.memberNumReceive}">
		<input type="hidden" name="reportSend" id="reportSend" value="${authInfo.memberNum}">
		<input type="hidden" name="memberNumSend" id="memberNumSend" value="${authInfo.id}">
		
		<select id="reportType" name="reportType"  class="form-select mb-3">
			<option selected disabled hidden>신고사유 선택</option>
			<option value="부적절한 홍보 게시글">부적절한 홍보 게시글</option>
			<option value="음란성 또는 청소년에게 부적합한 내용">음란성 또는 청소년에게 부적합한 내용</option>
			<option value="저작권 침해">저작권 침해</option>
			<option value="명예훼손 또는 사생활 침해">명예훼손 또는 사생활 침해</option>
			<option value="불법 촬영물 등 신고">불법 촬영물 등 신고</option>
			<option value="기타">기타</option>
		</select>
		
		<textarea name="reportContent" id="reportContent" ></textarea>
					
	</form>
	
	<button type="submit" onclick="alert('신고가 완료되었습니다.')">신고하기</button>
	<button type="button" onclick='location.href="/readView?boardNum=${reportBoardVo.boardNum}&memberNum=${reportBoardVo.memberNumReceive}"'>돌아가기</button>
	
</body>
</html>