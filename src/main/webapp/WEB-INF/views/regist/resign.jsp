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
//변경 비밀번호 유효성 확인 
function check_pw(){
  
		var password = ${authInfo.password};					//비밀번호 
		var passwordchk = document.getElementById('passwordchk').value;	//비밀번호 확인 값
		
		if(password != null && passwordchk != null){
      if(password == passwordchk){
              document.getElementById('pwchk').innerHTML='비밀번호가 일치합니다.'
              document.getElementById('pwchk').style.color='blue';
            
          }
          else if(password != passwordchk){
  
              document.getElementById('pwchk').innerHTML='비밀번호가 일치하지 않습니다.';
              document.getElementById('pwchk').style.color='red';
   
          }
		

  }
}


</script>





<body>
	<jsp:include page="../common/header.jsp" flush="false" />
	<form class="center" action = "/member/resign" method="post">
	<div class="container">
		<h2>회원탈퇴</h2>
		<div>
		<br>
	<h3>회원 탈퇴를 진행하기에 앞서, 하단부 내용을 확인 해주세요.</h3>
	<br>
	<br>
	
	<h4>1. 현재 사용중인 아이디 ${authInfo.id }는, 탈퇴 이후 재사용 및 복구가 불가능합니다.</h4>
	<h5>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.</h5>
	<h4>2. 탈퇴 후, 작성한 게시글은 모두 삭제 처리 됩니다.</h4>
	<h4>3. 탈퇴 후 7일 이내에 철회가 가능하며, 철회는 마이페이지에서 가능합니다.</h4>

	탈퇴 후에는 아이디 ${authInfo.id }로 재가입이 불가하며, 삭제된 데이터 역시 복구가 불가합니다.
	작성한 게시글과 회원에 대한 모든 데이터는 삭제됩니다.
	회원 탈퇴는 신청일로부터 7일 이내에 철회가 가능합니다.
	
	<div>
	<br>
	<br>
	<br>
	<label><input type = "checkbox" name = "resignchk" id = "resignchk" value = "true">안내 사항을 모두 확인하였으며, 이에 동의합니다.</label>
	</div>

	<div>
	비밀번호 확인 : <input type = "text" name = "passwordchk" id = "passwordchk" onchange = "check_pw();">
	<div class="pwchk" id = "pwchk">비밀번호를 입력하세요.</div>
	</div>
	<button type = "submit" class="btn btn-outline-info">회원탈퇴 신청</button>
	</div>
	</div>
	</form>
</body>
</html>