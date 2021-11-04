<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath2" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Trip Dairy</title>

	<style>
 .col {
    border-style:solid;
    border-width: thin;
    
 　}
</style>


</head>


<script type="text/javascript">

function fn_infoUpdate(){
	location='../member/infoUpdate'
}



function fn_pwUpdate(){
	location='../member/pwUpdate'
}





</script>





<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />

	
	

	<div class="container">
		<h2>마이페이지</h2>
		<div class ="row">
		<p>컨테이너 내부 중간 틀</p>
		<div class = "col">
		<h3>회원정보 수정</h3>
		<p>아이디 : ${authInfo.id }</p>
		<p>닉네임 : ${authInfo.nickname }</p>
		<p>생년월일 : ${authInfo.birthyear }.${authInfo.birth/100 }.${authoInfo.birth$100 }</p>
		<p>가입일 : ${authInfo.regdate }</p>
		<p>
		<input type = button name = "info" id = "info" value ="회원 정보 수정" onclick = "fn_infoUpdate();">
		</p>
		</div>
		<div class = "col">
		<h3>비밀번호 변경</h3>
		
		
		<p>현재 사용중인 비밀번호를 변경합니다.</p>
		
		<input type = button name = "pwchange" id = "pwchange" value ="변경" onclick = "fn_pwUpdate();">
		
		</div>
		
		</div>
	
	
</div>
<center>
<p>TripDiary를 이용하지 않는다면 <a href = "/member/resign">회원탈퇴 바로가기</a></p>
<p>TripDiary 탈퇴를 철회하고 싶다면 <a href = "/member/resigncancel">탈퇴철회 바로가기</a></p>

</center>


</body>
</html>