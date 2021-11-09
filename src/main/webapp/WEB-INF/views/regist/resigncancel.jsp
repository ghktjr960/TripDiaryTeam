<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<style>
.center {
	margin: 5px 25px;
	padding: 20px
}

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

<script type="text/javascript" charset="UTF-8">
	//변경 비밀번호 유효성 확인 
	function check_pw() {

		var password = $
		{
			authInfo.password
		}
		; //비밀번호 
		var passwordchk = document.getElementById('passwordchk').value; //비밀번호 확인 값

		if (password != null && passwordchk != null) {
			if (password == passwordchk) {
				document.getElementById('pwchk').innerHTML = '비밀번호가 일치합니다.'
				document.getElementById('pwchk').style.color = 'blue';

			} else if (password != passwordchk) {

				document.getElementById('pwchk').innerHTML = '비밀번호가 일치하지 않습니다.';
				document.getElementById('pwchk').style.color = 'red';

			}

		}
	}
</script>


<!--  잔여시간 표기 함수 만들기 -->
<script type="text/javascript" charset="UTF-8">
	window.onload = function() {

		tid = setInterval('msg_time()', 1000);

	}

	var test = new Date("${resignTime }");
	var stDate = new Date().getTime();// 시작날짜 (현재일자)
	var edDate = new Date(test).getTime(); // 종료날짜
	var RemainDate =  edDate - stDate ; //시간차
	var day = Math.ceil(gap / (1000 * 60 * 60 * 24));
	var hour = Math.ceil((gap % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var min = Math.ceil((gap % (1000 * 60 * 60)) / (1000 * 60));
	var sec = Math.ceil((gap % (1000 * 60)) / 1000);
	
	function msg_time() {
		var day = Math.ceil(RemainDate / (1000 * 60 * 60 * 24));
		var hour = Math.ceil((RemainDate % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var min = Math.ceil((RemainDate % (1000 * 60 * 60)) / (1000 * 60));
		var sec = Math.ceil((RemainDate % (1000 * 60)) / 1000);
		
		m = day + "일" + hour + "시" +  min + "분" + sec + "초"; // 남은 시간 text형태로 변경

		document.all.timer.innerHTML = m; // div 영역에 보여줌 
		document.all.timer.style.color = 'red';
		if (RemainDate < 0) {
			// 시간이 종료 되었으면..
			clearInterval(tid); // 타이머 해제
		} else {
			RemainDate = RemainDate - 1000; // 남은시간 -1초
		}
	}
</script>




<body>
	<jsp:include page="../common/header.jsp" flush="false" />
	<form class="center" action="/member/resigncancel" method="post">
		<div class="container">
			<h2>회원탈퇴 철회</h2>
			<div>
				<br> ${authInfo.id }의 탈퇴신청을 철회 하시겠습니까? <br> <br> 탈퇴까지
				남은 시간은
				<h2>
					<span id="timer"></span>
				</h2>
				입니다. <br> <br>

				<div>
					비밀번호 확인 : <input type="password" name="passwordchk" id="passwordchk"
						onchange="check_pw();">
					<div class="pwchk" id="pwchk">비밀번호를 입력하세요.</div>
				</div>
				<button type="submit" class="btn btn-primary mt-5">회원철회 신청</button>
			</div>
		</div>
	</form>
</body>
</html>