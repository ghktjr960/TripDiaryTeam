<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>게시글 신고</h1>
	<form action="/report/board" method="post" class="mt-5 mb-5">
		<input type="hidden" name="boardNum" id="boardNum" value="${reportBoardVo.boardNum}">
		<input type="hidden" name="reportReceive" id="reportReceive" value="${reportBoardVo.reportReceive}">
		<input type="hidden" name="memberNumReceive" id="memberNumReceive" value="${reportBoardVo.memberNumReceive}">
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
		<textarea class="form-control mt-10" rows="10" name="reportContent" id="reportContent" ></textarea>
		<br>		
		<button type="submit" class="btn btn-primary" onclick="alert('신고가 완료되었습니다.')">신고하기</button>
		<button type="button" class="btn btn-outline-primary" onclick='location.href="/readView?boardNum=${reportBoardVo.boardNum}&memberNum=${reportBoardVo.memberNumReceive}"'>돌아가기</button>
	</form>
</div>
	
	
</body>
</html>