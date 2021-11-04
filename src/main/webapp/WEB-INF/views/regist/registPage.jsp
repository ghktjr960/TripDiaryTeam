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


<!-- 해당 스크립트는 간편회원가입으로 회원가입페이지에 접속하였을 때 발생하는것 -->
<script type="text/javascript" charset="UTF-8">

<c:if test="${type eq 'api' }"> 

window.onload = function(){
	
	fn_emailChkKakao();
	fn_nickChkKakao();
}


</c:if> 

</script>




<script type="text/javascript" charset="UTF-8">

$(document).ready(function(){
			
			// 취소
			$(".cancel").on("click", function(){
				location.href = "/";
			})
			
			//등록버튼 눌렀을 시, 공란으로 된 칸에 대해 alert + 공란으로 화면 focus하기 
			$("#submit").on("click", function(){
				if($("#id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#id").focus();
					return false;
				}
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				if($("#nickname").val()==""){
					alert("닉네임을 입력해주세요.");
					$("#nickname").focus();
					return false;
				}
				if($("nickChk").val() == "N"){
					alert("닉네임 중복확인 작업을 진행해주세요. ");
				}
				
				if($("#email").val()==""){
					alert("이메일을 입력해주세요.");
					$("#email").focus();
					return false;
				}
				//var idChkVal = $("#idChk").val();
				if($("#idChk").val() == "N"){
					alert("아이디 중복확인 버튼을 눌러주세요.");
					$("#idChk").focus();
					return false;
				}
				
				if($("#emailsendChk").val() == "N"){
					alert("이메일 인증을 진행해주세요.");
				}//else if($("#emailsendChk").val() == "Y"){
				
				//}
				$("#registPage").submit();
			});
		})
		
		//중복 아이디 확인 
		function fn_idChk(){
			$.ajax({
				url : "../regist/idChk",
				type : "post",
				dataType : "json",
				data : {"id" : $("#id").val()},
				success : function(data){
					if(data == 1){
				
						document.getElementById('idvalid').innerHTML='아이디를 다시 입력해주세요. (영문 소문자, 숫자만 입력 가능)'
			            document.getElementById('idvalid').style.color='red';
						alert("중복된 아이디입니다.");
						
					}else if(data == 0){
						
						$("#idChk").attr("value", "Y");
						document.getElementById('idvalid').innerHTML='사용 가능한 아이디 입니다.'
			            document.getElementById('idvalid').style.color='blue';
						alert("사용가능한 아이디입니다.");
						
					}
				}
			})
		}
		
		
		
		//중복 닉네임 확인 
		function fn_nickChk(){
			$.ajax({
				url : "../regist/nickChk",
				type : "post",
				dataType : "json",
				data : {"nickname" : $("#nickname").val()},
				success : function(data){
					if(data == 1){
				
						document.getElementById('nickvalid').innerHTML='닉네임을 다시 입력해주세요. (영문 소문자, 숫자만 입력 가능)'
			            document.getElementById('nickvalid').style.color='red';
						alert("중복된 닉네임입니다.");
						
					}else if(data == 0){
						
						$("#nickChk").attr("value", "Y");
						document.getElementById('nickvalid').innerHTML='사용 가능한 닉네임 입니다.'
			            document.getElementById('nickvalid').style.color='blue';
						alert("사용가능한 닉네임 입니다.");
						
					}
				}
			})
		}
		
		

			//패스워드 유효성 확인 
		  function check_pw(){
	        
				var password = document.getElementById('password');					//비밀번호 
				var passwordchk = document.getElementById('passwordchk');	//비밀번호 확인 값
				
				
				
				
				if(document.getElementById('password').value !='' && document.getElementById('passwordchk').value!=''){
	            if(document.getElementById('password').value==document.getElementById('passwordchk').value){
	                    document.getElementById('pwvalid').innerHTML='비밀번호가 일치합니다.'
	                    document.getElementById('pwvalid').style.color='blue';
	                }
	                else{
	                	
	                	
	        			
	                    document.getElementById('pwvalid').innerHTML='비밀번호가 일치하지 않습니다.';
	                    document.getElementById('pwvalid').style.color='red';
	               
	                    
	                }
				
	      
	        }
				
			
		  }
		

		function birthchk() {
			  // 선택된 데이터의 텍스트값 가져오기
			  var birth_mon =  document.getElementById('birth_month').value;
			  var birth_day =  document.getElementById('birth_day').value;
			  
			  
			  if(birth_mon < 10){
				  birth_mon = 0 + birth_mon;
			  }else{
				  birth_mon = birth_mon;
			  }
			 
			  if(birth_day < 10){
				  birth_day = 0 + birth_day;
			  }else{
				  birth_day = birth_day;
			  }
			  			
			 	var birth = birth_mon + birth_day;
			
			  // 선택한 텍스트 출력
			  $("#birth").attr("value", birth);
			  
			}
		
		
		//이메일 인증 번호 보내기 
		function fn_emailSend(){
			
			
			
			if($("#emailChk").val() == "N"){
				alert("입력하신 이메일 중복 확인이 필요합니다. ");
			}else{
			
			$.ajax({
				url : "../mail/mailsend",
				type : "post",
				dataType : "text",
				data : {"email" : $("#email").val()},
				
				 success: function(data) {
				      alert("인증번호가 발송되었습니다." +  "인증번호는 "+ data + "입니다." ); // 확인
				      chktimer();   // 인증 메일 발송 시, 3분의 타이머가 작동;
				      
				    }, 
				    error: function(data) { 
				    	alert("발송실패!"); 
				    	
				    } 
			
			})
			}
		}
		
		
		//이메일 인증번호 확인 0값이 반환되면 일치, 1값이 반환되면 불일치 
		function fn_emailSendChk(){
			$.ajax({
				url : "../mail/mailsendChk",
				type : "post",
				dataType : "text",
				data : {"emailchk" : $("#emailchk").val()},
				
				 success: function(data) {
					 
					 if(data == 1){
							
							alert("인증번호가 일치하지 않아요;");
							
						}else if(data == 0){
							$("#emailsendChk").attr("value", "Y");
							alert("인증번호가 일치합니다 :) ");
							
						}
					 
				    }, 
				    error: function(data) { 
				    	alert("인증 실패!"); 
				    } 
			
			})
		}
	
	
		//중복 이메일 확인 
		function fn_emailChk(){
			$.ajax({
				url : "../regist/emailChk",
				type : "post",
				dataType : "json",
				data : {"email" : $("#email").val()},
				success : function(data){
					if(data == 1){
					
						$("#emailChk").attr("value", "N");
						document.getElementById('emailvalid').innerHTML='이메일을 다시 입력해주세요.'
			            document.getElementById('emailvalid').style.color='red';
						alert("이미 가입된 이메일 입니다.");
						
					}else if(data == 0){
						
						$("#emailChk").attr("value", "Y");
						document.getElementById('emailvalid').innerHTML='사용 가능한 이메일 입니다.'
			            document.getElementById('emailvalid').style.color='blue';
						alert("사용가능한 이메일 입니다.");
						
					}
				}
			})
		}
			
		
		
		
		
		
		
		
		
		
</script>




 		<!-- 인증메일 발송 후, 타이머 실행 -->
		<script type="text/javascript" charset="UTF-8">
		
		 var count = 0;
		    var time = 0;
		    var choice = 0;
		    
		    
		    function chktimer() {

		        clearInterval(time); // 타이머 우선 초기화 시켜주기(time initialize)
		      

		        // 찾은 index로 value찾기
		        count = parseInt(180);

		        // 타이머 함수 1초씩 호출하는 함수 만들기
		        time = setInterval("myTimer()", 1000);

		      }

		      function myTimer() {
		        count = count - 1; // 타이머 선택 숫자에서 -1씩 감산함(갱신되기 때문)

		        document.getElementById("countdown").innerHTML = count + "</b>초 남았습니다.";
		        if (count == 0) {
		          clearInterval(time); // 시간 초기화
		          document.getElementById("countdown").innerHTML = "인증 번호 유효시간이 초과되었습니다."; 
		        }
		      }
		
	</script>


<script type="text/javascript" charset="UTF-8">
//카카오 API로 가입을 진행할 때, 중복 이메일값과 닉네임 값을 조회해주기 위함
		function fn_emailChkKakao() {
			$.ajax({
				url : "../regist/emailChk",
				type : "post",
				dataType : "json",
				data : {"email" : $("#email").val()},
				success : function(data){
					//카카오 api로 가입 진행했을 때, 이메일 중복 여부 판단
					if(data == 1){
					
						$("#emailChk").attr("value", "N");
				        $("#email").removeAttr('readonly'); 
				        $("#emailChk").removeAttr('disabled'); 
				        $("#emailChk").show();
				        
				        alert('test1');
						document.getElementById('emailvalid').innerHTML='이미 사용중인 이메일입니다. '
			            document.getElementById('emailvalid').style.color='red';
						
						
					}else if(data == 0){
						
						alert('test2');
						$("#emailChk").attr("value", "Y");
						document.getElementById('emailvalid').innerHTML='사용 가능한 이메일 입니다.'
			            document.getElementById('emailvalid').style.color='blue';
						$("#emailChk").hide();
						
						
					}else{
						
						alert('test3');
						$("#emailChk").attr("value", "N");
						document.getElementById('emailvalid').innerHTML='이미 사용중인 이메일입니다.'
				            document.getElementById('emailvalid').style.color='red';
						 $("#email").removeAttr('readonly'); 
				        $("#emailChk").removeAttr('disabled'); 
				        $("#emailChk").show();
				        
					}
				}
			})
	    }
		
		//중복 닉네임 확인 
		function fn_nickChkKakao() {
		
			$.ajax({
				url : "../regist/nickChk",
				type : "post",
				dataType : "json",
				data : {"nickname" : $("#nickname").val()},
				success : function(data2){
					if(data2 == 1){
				
						
						$("#nickChk").attr("value", "N");
				        $("#nickname").removeAttr("readonly"); 
				      
				        $("#nickChk").removeAttr("disabled"); 
				        $("#nickChk").show();
						document.getElementById('nickvalid').innerHTML='닉네임을 다시 입력해주세요. (영문 소문자, 숫자만 입력 가능)'
			            document.getElementById('nickvalid').style.color='red';
						
						
					}else if(data2 == 0){
						
						$("#nickChk").attr("value", "Y");
						document.getElementById('nickvalid').innerHTML='사용 가능한 닉네임 입니다.'
			            document.getElementById('nickvalid').style.color='blue';
						$("#nickChk").attr("value", "N");
				        $("#nickname").attr("readonly"); 
				        $("#nickChk").attr("disabled"); 
				      	
						
					}
				}
			})
		}  //여기까지 api 조


</script>





<body>

<jsp:include page="../common/header.jsp" flush="false" />
	
    <form class="center" action = "/regist/registPage" method="post">
        <h2>회원가입 페이지 </h2>
        
 
        <div class="form-group">
              <label>ID</label>
            <input type="text" class="form-control" name="id" id = "id" placeholder="ID 작성해주세요.">
            <div class="idvalid" id = "idvalid">아이디를 입력하세요. (영문 소문자, 숫자만 입력 가능)</div>
            <button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>
           
        </div>
        <div class="form-group">
            <label>PASSWORD</label>
            <input type="text" class="form-control" name="password" id = "password" placeholder="암호 입력 " onchange="check_pw()">
        	<div class="valid">비밀번호를 입력하세요.(최소 8글자에서 13글자 사이)</div>
        </div>
         <div class="form-group">
            <label>PASSWORD CONFIRM</label>
            <input type="text" class="form-control" name="passwordchk" id ="passwordchk" placeholder="암호 재입력 " onchange="check_pw()">
        	<div class="pwvalid" id ="pwvalid">비밀번호를 다시 한번 입력하세요. </div>
        	
        </div>
        
        
        <c:if test="${type == 'api'}">
         <div class="form-group">
          <label>NICKNMAE</label>
              <div>
               <input class="form-control" name="nickname" id = "nickname" value = "${nickname}" readonly>
           		<button class="nickChk" type="button" id="nickChk" onclick="fn_nickChk();" value="N" disabled>중복확인</button>
               <div class="nickvalid" id = "nickvalid" >닉네임을 입력하세요. (영문 소문자, 숫자만 입력 가능)</div>
         
             </div>
             </div>
             </c:if>
             <c:if test="${type == 'normal'}">
             <div class="form-group">
            <label>NICKNAME</label>
            <input class="form-control" name="nickname" id = "nickname" placeholder="닉네임 입력  ">
            <div class="nickvalid" id = "nickvalid" >닉네임을 입력하세요. (영문 소문자, 숫자만 입력 가능)</div>
            <button class="nickChk" type="button" id="nickChk" onclick="fn_nickChk();" value="N">중복확인</button>
     
      	 </div>
        	</c:if>
        	<div id="ViewTimer"></div>
        	
         <c:if test="${type == 'api'}">
         <div class="form-group">
          <label>EMAIL</label>
          <input  type = "text" name="email" id = "email" value = "${email}" readonly>
          <button class="emailChk" type="button" id="emailChk" onclick="fn_emailChk();" value="N" disabled>중복확인</button>
               <div class="emailvalid" id = "emailvalid" >이메일을 입력하세요 (ex abc@abc.abc)</div>
         
             </div>
              </c:if>
              
              <c:if test="${type == 'normal'}">
         <div class="form-group">
            <label>EMAIL</label>
            <input class="form-control" type = "email" name="email" id = "email" placeholder="이메일 입력  ">
             <button class="emailChk" type="button" id="emailChk" onclick="fn_emailChk();" value="N">중복확인</button>
           <div class="emailvalid" id = "emailvalid" >이메일을 입력하세요 (ex abc@abc.abc)</div>
            </div>
            <div>
            <button class = "emailsend" type="button" name="emailsend" onclick = "fn_emailSend();  chktimer();">이메일 인증받기</button>
           <div>
           <p>남은시간 : <div id="countdown"></div></p>
           <input name="emailchk" id="emailchk" placeholder="  인증번호를 입력하세요. " >
             <button class = "emailsendChk" type="button" name="emailsendChk" onclick = "fn_emailSendChk()" value="N">인증하기 </button>
        	</div>
        	<div id="ViewTimer"></div>
        </div>
        </c:if>
        
         <div class="form-group">
            <label>GENDER</label>
            <div>
            <label><input type="radio" name="gender" id ="gender" value="male" checked/>남</label>
			<label><input type="radio" name="gender" id ="gender" value="female" />여</label>
            </div>
            <!--  <input class="form-control" name="gender" id = "gender" placeholder="성별 기재 "> -->
        </div>
         <div class="form-group">
            <label>BIRTH</label>
            <div class="yearvalid">출생년도를 입력하세요.</div>
             <c:set var="year" value="2021"/>
            <select name="birthyear" class="form-select" >
               <option selected >년</option>
               <c:forEach var="i" begin="0" end="70">
                  <option value="<c:out value="${year-i}" />"><c:out value="${year-i}" /> </option>
               </c:forEach>
               </select>
                   <select name="birth_month" id = "birth_month" class="form-select" >
               <option selected disabled hidden>월</option>
               <c:forEach var="i" begin="1" end="12">
                  <option value="${i}">${i}</option>
               </c:forEach>
               
            </select> <select name="birth_day" id = "birth_day" class="form-select" onchange="birthchk()">
               <option selected disabled hidden>일</option>
               <c:forEach var="i" begin="1" end="31">
                  <option value="${i}">${i}</option>
               </c:forEach>
            </select>
           
        </div>
         <div class="form-group">
            
           
             
             <input name="birth" id = "birth" placeholder="생일을 기재 ex) 0423 " value = "0" readonly hidden>
            <!--  div class="birthvalid" id ="birthvalid" >월+일 포맷으로 출력하려고 </div-->
        	
       
        </div>
       
        
        
    
       
       
    <button type="submit" id = "submit" class="btn btn-outline-info">등록</button>

    </form>



</body>
</html>