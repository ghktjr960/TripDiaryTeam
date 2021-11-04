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
<title>Trip Diary</title>
</head>
<body>
	<jsp:include page="../${pageContext.request.contextPath}/common/header.jsp" flush="false" />
	
	<div class="container">
		<h2>로그인 페이지</h2>
	<c:if test="${empty authInfo}">
	 <form class="center" method="post">
        <h2>회원가입 </h2>
        <div class="form-group">
    
              <label>ID</label>
            <input type="text" class="form-control" name="id" id = "id" value = "${cookie.myCookieId.value }" placeholder="아이디 입력 ">
            <label>PASSWORD</label>
            <input type="text" class="form-control" name="password" id = "password" placeholder="암호 입력 ">
        	<div class="form-group">                                                                                                                                                          
                       <div class="custom-control custom-checkbox small">
                       <c:if test = "${not empty test}">                                                                                                             
                           <input type="checkbox" class="custom-control-input" id="idRemember" name="idRemember" checked = "checked"/>                                           
                           <label class="custom-control-label" for="idRemember">아이디 기억</label>   
                           </c:if>                                                                               
                <c:if test = "${ empty test}">                                                                                                             
                           <input type="checkbox" class="custom-control-input" id="idRemember" name="idRemember" />                                           
                           <label class="custom-control-label" for="idRemember">아이디 기억</label>   
                           </c:if>  
                       </div>                                                                                                                                                         
                   </div>


        	<button name = "login" id = "login">로그인</button>
        	<div>
        	<br>
        	    <a href="<c:url value="../member/findId"/>">아이디/비밀번호 찾기</a>
        	</div>
        </div>
        </form>
      
	<br>

	<p><a href="https://kauth.kakao.com/oauth/authorize?client_id=bcda581619b4414831010bbe8b47dff7&redirect_uri=http://localhost:8080/regist/registKakao&response_type=code"><img src="/resources/img/kakao_login_medium_narrow.png"></a></p>
	<br>

	<p><a href="<c:url value="/regist/termsN"/>">일반 회원가입</a></p>
	<br>
	<br>
</c:if>
<c:if test="${not empty authInfo}">
	<p>" ${authInfo.nickname} "님으로 로그인</p>
	<p><a href="<c:url value="/edit/changePassword"/>">비밀번호 변경</a></p>
	<p><a href="<c:url value="../login/logout"/>">로그아웃</a></p>

</c:if>
  <c:if test = "${msg == false}">
        	<p style = "color : red;">로그인 실패!</p>
        	</c:if>
</div>
</body>

</html>