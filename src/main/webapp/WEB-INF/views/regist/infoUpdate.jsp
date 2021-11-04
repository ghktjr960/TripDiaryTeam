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
				  $("#birth").attr("readonly", true);
				  
				}
			

			
			//중복 닉네임 확인 
			$(document).ready(function birthchk() {
			
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
				  
			});
			


			</script>





 <form class="center" method="post">
        <h2>회원가입 페이지 </h2>
        <div class="form-group">
              <label>ID</label>
            <input type="text" class="form-control" name="id" id = "id" value = ${authInfo.id } readonly>
           </div>

             <div class="form-group">
            <label>NICKNAME</label>
            <input class="form-control" name="nickname" id = "nickname" value= ${authInfo.nickname }>
            <div class="nickvalid" id = "nickvalid" >닉네임을 입력하세요. (영문 소문자, 숫자만 입력 가능)</div>
            <button class="nickChk" type="button" id="nickChk" onclick="fn_nickChk();" value="N">중복확인</button>
      	 </div>
        
      
  
         <div class="form-group">
            <label>BIRTH</label>
            <div>
         	  <h5>기존 생년월일 : ${authInfo.birthyear }.${authInfo.birth/100}</h5>
            </div>
            
             <c:set var="year" value="2021"/>
            <select name="birthyear" class="form-select" >
               <option selected disabled hidden>년</option>
               <c:forEach var="i" begin="0" end="70">
                  <option value="<c:out value="${year-i}" />"><c:out value="${year-i}" /> </option>
               </c:forEach>
               </select>
                   <select name="birth_month" id = "birth_month" class="form-select" onchange="birthchk()" >
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
            <div class="yearvalid">출생년도를 입력하세요.</div>
        </div>
       
         <div class="form-group">
            
  
             <input name="birth" id = "birth" placeholder="생일을 기재 ex) 0423 " value = "0" readonly hidden >
   
        </div>
       
        
        
    
       
       
    <button type="submit" id = "submit" class="btn btn-outline-info">등록</button>

    </form>










  

</body>
</html>