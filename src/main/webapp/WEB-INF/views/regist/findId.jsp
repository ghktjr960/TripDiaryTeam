<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		
	 	
<style>
.center{
margin: 5px 25px; padding: 20px
}

.valid { color: green; }

.invalid { color: red; }

.pwvalid {color : green; }

.idvalid {color : green; }

.yearvalid {color : green; }

.birthvalid {color : red; }


</style>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	
	<div>
	<form class="center"  method="post">
	<div class="container">
		<h2>아이디 찾기</h2>
		<div>
		<br>

	<div>
	이메일
	 <br>
	 <input type = "text" name = "emailchk" id = "emailchk" onchange = "check_email();">
	<div class="emailchked" id = "emailchked">이메일을 입력하세요.</div>
	</div>
	<button type ="button" name ="chkid" id = "chkid" class="btn btn-outline-info" onclick = "fn_emailChk();" value = "N">아이디 찾기</button>
	</div>
	<div><br><h3>아이디 조회 결과</h3><br></div>
	<div class="searchresult" id = "searchresult" name = "searchresult"></div>
	</div>
	
	</form>
	
	
	<form class="center"  method="post">
	<div class="container">
		<h2>비밀번호 찾기</h2>
		<div>
		<br>

	<div>
	아이디
	 <br>
	 <input type = "text" name = "idchk" id = "idchk">
	<div class="idchked" id = "idchked">아이디를 입력하세요.</div>
	</div>
	 <input type = "text" name = "mailEchk" id = "mailEchk">
	<div class="idchked" id = "idchked">이메일을 입력하세요.</div>
	</div>
	<button type ="button" name ="chkpw" id = "chkpw" class="btn btn-outline-info" onclick = "fn_pwChk();" value = "N">비밀번호 찾기</button>
	</div>
	<div><br><h3>비밀번호 찾기 결과</h3><br></div>
	<div class="pwsearchresult" id = "pwsearchresult" name = "pwsearchresult"></div>
	
	
	</form>
	</div>
	
	
	
</body>
</html>