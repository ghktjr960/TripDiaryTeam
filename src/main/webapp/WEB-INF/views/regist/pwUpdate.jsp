<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
.valid {
	color: green;
}

.invalid {
	color: red;
}

.pwvalid {
	color: green;
}

.idvalid {
	color: green;
}

.yearvalid {
	color: green;
}

.birthvalid {
	color: red;
}
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
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="false" />


	<script type="text/javascript" charset="UTF-8">
		//기존 비밀번호 유효성 확인
		function check_oldpw() {

			var oldpw = document.getElementById('oldpassword').value;
			var oldpwchk = $
			{
				authInfo.password
			}
			; //세션에 저장된 로그인값을 활용한것

			if (oldpw != oldpwchk) {

				document.getElementById('validOldPw').innerHTML = '비밀번호가 일치하지 않습니다. 확인 후 다시 입력해주세요.'
				document.getElementById('validOldPw').style.color = 'red';

			} else if (oldpw == oldpwchk) {
				document.getElementById('validOldPw').innerHTML = '비밀번호가 일치합니다.'
				document.getElementById('validOldPw').style.color = 'blue';

			}
		}

		//변경 비밀번호 유효성 확인 
		function check_newpw() {

			var password = document.getElementById('password').value; //비밀번호 
			var passwordchk = document.getElementById('passwordchk').value; //비밀번호 확인 값

			if (password != null && passwordchk != null) {
				if (password == passwordchk) {
					document.getElementById('validNewPw').innerHTML = '비밀번호가 일치합니다.'
					document.getElementById('validNewPw').style.color = 'blue';

				} else if (password != passwordchk) {

					document.getElementById('validNewPw').innerHTML = '비밀번호가 일치하지 않습니다.';
					document.getElementById('validNewPw').style.color = 'red';

				}

			}
		}
	</script>





	<form class="container" method="post" id="pwupdate" name="pwupdate"
		action="/member/pwUpdate" style="width: 350px; text-align: left;">
		<h2>비밀번호 변경</h2>
		<input type="text" id="id" name="id" value=${authInfo.id } readonly
			hidden>

		<div class="form-group mt-3">
			<div class="form-group">
				<input type="text" class="form-control" name="oldpassword"
					id="oldpassword" placeholder="기존 암호 입력 " onchange="check_oldpw()">
				<div class="validOldPw" id="validOldPw">(영문 대/소문자, 숫자를 모두 포함)</div>
				<br>
			</div>


			<input type="text" class="form-control" name="password" id="password"
				placeholder="새로운 암호 입력 ">
			<div class="validNewPw">(영문 대/소문자, 숫자를 모두 포함)</div>
			<br>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="passwordchk"
				id="passwordchk" placeholder="새로운 암호 재입력 " onchange="check_newpw()">
			<div class="validNewPw" id="validNewPw">비밀번호를 다시 한번 입력하세요.</div>
		</div>


		<input type="submit" class="btn btn-primary mt-5" style="width: 100%;">


	</form>



</body>
</html>