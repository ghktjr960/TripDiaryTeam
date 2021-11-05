<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		
	 	
<style>

.valid { color: green; }

.invalid { color: red; }

.pwvalid {color : green; }

.idvalid {color : green; }

.yearvalid {color : green; }

.birthvalid {color : red; }


</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<!-- meta charset="UTF-8" -->
<title>Trip Dairy</title>
</head>

<script type="text/javascript" charset="UTF-8">


//입력 이메일 확인 
function fn_emailChk(){
	$.ajax({
		url : "../member/findId",
		type : "post",
		dataType : "text",
		data : {"email" : document.getElementById('emailchk').value},
		success : function(data){
			
		
		
			
			if(data != "none"){
				
				$("#chkid").attr("value", "Y");
				document.getElementById('searchresult').innerHTML= "해당 이메일로 가입한 아이디는 " + data + " 입니다.";
	            document.getElementById('searchresult').style.color='blue';
				
				
				
			}else if(data == "none"){

				$("#chkid").attr("value", "N");
				document.getElementById('searchresult').innerHTML='입력하신 이메일과 일치하는 아이디가 없습니다.'
	            document.getElementById('searchresult').style.color='red';
			
			}
			

			

		}
	})
}





//입력 ID/EMAIL 확인 
function fn_pwChk(){
	$.ajax({
		url : "../mail/tmpPwsend",
		type : "post",
		dataType : "text",
		data : {
			"email" : document.getElementById('mailEchk').value ,
			"id" : document.getElementById('idchk').value},
		success : function(data){
			
		
		
		
		if(data != "none"){
			
			alert(data);
			
			document.getElementById('pwsearchresult').innerHTML= "등록된 이메일로 임시 비밀번호가 발송되었습니다.";
            document.getElementById('pwsearchresult').style.color='blue';
			
			
			
		}else if(data == "none"){

			document.getElementById('pwsearchresult').innerHTML='입력하신 이메일 또는 아이디가 잘못 되었습니다. 다시 확인해주세요.'
            document.getElementById('pwsearchresult').style.color='red';
		
		}
		
			

			

		}
	})
}










</script>





<body>
	<jsp:include page="../common/header.jsp" flush="false" />
	
	
	<div class="container">
		<div class="row">
		<div class="col-lg-1"></div>
		<form method="post" class="col-lg-4 shadow mt-5 mb-5">
		
			<h2 class="mt-5">아이디 찾기</h2>
			<div>
			<br>
			<div>
			이메일
			 <br>
			 <input type = "text" name = "emailchk" id = "emailchk" onchange = "check_email();" class="form-control" style="width: 300px; margin: auto;">
			<div class="emailchked" id = "emailchked">이메일을 입력하세요.</div>
			</div>
		<button type ="button" name ="chkid" id = "chkid" class="btn btn-primary" onclick = "fn_emailChk();" value = "N">아이디 찾기</button>
		</div>
		<div><br><h4>아이디 조회 결과</h4><br></div>
		<div class="searchresult" id = "searchresult" name = "searchresult"></div>
		
		
		</form>
		<div class="col-lg-1"></div>
		<div class="col-lg-1"></div>
		
		<form method="post" class="col-lg-4 shadow mt-5 mb-5">
			<h2 class="mt-5">비밀번호 찾기</h2>
			<div>
			<br>
	
		<div>
		아이디
		 <br>
		 <input type = "text" name = "idchk" id = "idchk" class="form-control" style="width: 300px; margin: auto;">
		<div class="idchked" id = "idchked">아이디를 입력하세요.</div>
		</div>
		 <input type = "text" name = "mailEchk" id = "mailEchk" class="form-control" style="width: 300px; margin: auto;">
		<div class="idchked" id = "idchked">이메일을 입력하세요.</div>
		</div>
		<button type ="button" name ="chkpw" id = "chkpw" class="btn btn-primary" onclick = "fn_pwChk();" value = "N">비밀번호 찾기</button>
		
		<div><br><h4>비밀번호 찾기 결과</h4><br></div>
		<div class="pwsearchresult" id = "pwsearchresult" name = "pwsearchresult"></div>
		
		</form>
		<div class="col-lg-1"></div>
		</div>
	</div>
	
	
	
</body>
</html>