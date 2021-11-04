<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	

	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	
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
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />


<script type="text/javascript" charset="UTF-8">

//기존 비밀번호 유효성 확인
function check_oldpw(){
	
	var oldpw = document.getElementById('oldpassword').value ;
	var oldpwchk = ${authInfo.password}; //세션에 저장된 로그인값을 활용한것
	
	
	if(oldpw != oldpwchk){
		
		document.getElementById('validOldPw').innerHTML='비밀번호가 일치하지 않습니다. 확인 후 다시 입력해주세요.'
			document.getElementById('validOldPw').style.color='red';
	
		 
	}else if(oldpw == oldpwchk){
		document.getElementById('validOldPw').innerHTML='비밀번호가 일치합니다.'
			document.getElementById('validOldPw').style.color='blue';
		
}
}

//변경 비밀번호 유효성 확인 
function check_newpw(){
  
		var password = document.getElementById('password').value;					//비밀번호 
		var passwordchk = document.getElementById('passwordchk').value;	//비밀번호 확인 값
		
		if(password != null && passwordchk != null){
      if(password == passwordchk){
              document.getElementById('validNewPw').innerHTML='비밀번호가 일치합니다.'
              document.getElementById('validNewPw').style.color='blue';
            
          }
          else if(password != passwordchk){
  
              document.getElementById('validNewPw').innerHTML='비밀번호가 일치하지 않습니다.';
              document.getElementById('validNewPw').style.color='red';
   
          }
		

  }
}









			</script>





 <form class="center" method="post" id = "pwupdate" name = "pwupdate" action = "/member/pwUpdate">
        <h2>비밀번호 변경 </h2>
   <input type = "text" id = "id"  name = "id" value = ${authInfo.id } readonly hidden>
  
  	 <div class="form-group">
            <div class="form-group">
            <label>기존 비밀번호</label>
            <input type="text" class="form-control" name="oldpassword" id = "oldpassword" placeholder="암호 입력 " onchange="check_oldpw()">
        	<div class="validOldPw" id = "validOldPw">비밀번호를 입력하세요. (영문 대/소문자, 숫자를 모두 포함)</div>
        </div>
       
           
            <label>변경할 비밀번호</label>
            <input type="text" class="form-control" name="password" id = "password" placeholder="암호 입력 ">
        	<div class="validNewPw">비밀번호를 입력하세요. (영문 대/소문자, 숫자를 모두 포함)</div>
        </div>
         <div class="form-group">
            <label>변경할 비밀번호 확인</label>
            <input type="text" class="form-control" name="passwordchk" id ="passwordchk" placeholder="암호 재입력 " onchange="check_newpw()">
        	<div class="validNewPw" id ="validNewPw">비밀번호를 다시 한번 입력하세요. </div>
        </div>
      
 
    <input type="submit"  class="btn btn-outline-info">
 

    </form>



</body>
</html>