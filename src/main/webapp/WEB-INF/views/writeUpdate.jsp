<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"crossorigin="anonymous">
<c:if test="${empty darkmode}">
	<link rel="stylesheet" href="/resources/css/style.css" />
</c:if>
<c:if test="${not empty darkmode}">
	<link rel="stylesheet" href="/resources/css/darkstyle.css" />
</c:if>
<link rel="stylesheet" href="/resources/css/writeStyle.css" />
<title>TripDiary</title>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />

	<div class="container">
		<h2>수정하기</h2>
		
		<form action="/writeUpdate" method="post" enctype="multipart/form-data" class="mt-5 mb-5">
			<div class="writeForm mt-5">
			<div class="writeSelect">
				<h4>여행 날짜</h4>
				<c:set var="year" value="2021" />
				<select name="year" class="form-select">
					<option selected value="<c:out value="${fn:substring(board.tripdate,0,4) }" />">${fn:substring(board.tripdate,0,4) }</option>
					<optgroup label=""></optgroup>
						<c:forEach var="i" begin="0" end="70">
							<option value="<c:out value="${year-i}" />">
								<c:out value="${year-i}" />
							</option>
						</c:forEach>

				</select> <select name="month" class="form-select">
					<option selected value="<c:out value="${fn:substring(board.tripdate,5,7) }" />">${fn:substring(board.tripdate,5,7) }</option>
					<optgroup label=""></optgroup>
					<c:forEach var="i" begin="1" end="12">
						<option value="${i}">${i}</option>
					</c:forEach>

				</select> <select name="day" class="form-select">
					<option selected value="<c:out value="${fn:substring(board.tripdate,8,10) }" />">${fn:substring(board.tripdate,8,10) }</option>
					<optgroup label=""></optgroup>
					<c:forEach var="i" begin="1" end="31">
						<option value="${i}">${i}</option>
					</c:forEach>
				</select>

				<h4 class="mt-5">여행 지역</h4>
				<div class="form-check form-check-inline mb-5">
					<input class="form-check-input" type="radio" name="placeCheck" value="abroad" onclick="disable_select()" <c:if test="${board.place eq 'abroad' }">checked </c:if> >
					<label class="form-check-label" >해외</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="placeCheck" onclick="disable_select2()" <c:if test="${board.place ne 'abroad' }">checked </c:if>>
					<label class="form-check-label" >국내</label>
				</div>
					
				 <select name="place" id="select_place" class="form-select">
					<option value="seoul" <c:if test="${board.place eq 'seoul' }">selected </c:if>>서울특별시</option>
					<option value="busan" <c:if test="${board.place eq 'busan' }">selected </c:if>>부산광역시</option>
					<option value="daegu" <c:if test="${board.place eq 'daegu' }">selected </c:if>>대구광역시</option>
					<option value="incheon" <c:if test="${board.place eq 'incheon' }">selected </c:if>>인천광역시</option>
					<option value="gwangju" <c:if test="${board.place eq 'gwangju' }">selected </c:if>>광주광역시</option>
					<option value="daejeon" <c:if test="${board.place eq 'daejeon' }">selected </c:if>>대전광역시</option>
					<option value="ulsan" <c:if test="${board.place eq 'ulsan' }">selected </c:if>>울산광역시</option>
					<option value="sejong" <c:if test="${board.place eq 'sejong' }">selected </c:if>>세종특별자치시</option>
					<option value="gyeonggi" <c:if test="${board.place eq 'gyeonggi' }">selected </c:if>>경기도</option>
					<option value="gangwon" <c:if test="${board.place eq 'gangwon' }">selected </c:if>>강원도</option>
					<option value="chungbuk" <c:if test="${board.place eq 'chungbuk' }">selected </c:if>>충청북도</option>
					<option value="chungnam" <c:if test="${board.place eq 'chungnam' }">selected </c:if>>충청남도</option>
					<option value="jeonbuk" <c:if test="${board.place eq 'jeonbuk' }">selected </c:if>>전라북도</option>
					<option value="jeonnam" <c:if test="${board.place eq 'jeonnam' }">selected </c:if>>전라남도</option>
					<option value="gyeongbuk" <c:if test="${board.place eq 'gyeongbuk' }">selected </c:if>>경상북도</option>
					<option value="gyeongnam" <c:if test="${board.place eq 'gyeongnam' }">selected </c:if>>경상남도</option>
					<option value="jeju" <c:if test="${board.place eq 'jeju' }">selected </c:if>>제주도특별자치도</option>
				</select>
				</div>
				 <h6 class="mt-5" style="color: red;">* 사진 재업로드시 기존 사진들은 삭제됩니다.<br>* 내용 변경만 원한다면 사진 재업로드 버튼을 클릭하지 마세요!</h6>
				<label for="thumbnail" class="btn btn-outline-secondary mt-3" id="image_container">
						<span class="imgText">대표사진 재업로드 (최대 1장)</span>
				</label>
				<input name="thumbnail" type="file" id="thumbnail" accept="image/*" onchange="checkImg(); thumbnailHide(); setThumbnail(event);" style="display:none"/>
				 <div class="mt-3" id="image_container">
				 	<img class="board-thumbnail border border-secondary" src="<spring:url value='/thumbnail/${mainImg }'/>">
				 </div>
				 
				<label for="input-file" class="btn btn-outline-secondary mt-3" id="image_container">
						<span class="imgText">추가사진 재업로드 (최대 10장)</span>
				</label>
				<input name="file" type="file" id="input-file" accept="image/*" onchange="checkImg2(); fileHide(); setFile(event);" style="display:none" multiple="multiple"/>
				 <div class="mt-5" id="image_container2">
				 	<c:if test="${not empty subImg }">
					 	<c:forEach var="subImg" items="${subImg}" varStatus="loop">
					 		<img src="<spring:url value='/boardImg/${subImg }'/>" class="board-file border border-secondary">
					 	</c:forEach>
				 	</c:if>
				 </div>
				
				<!-- 수정사항 업로드시 이미지 관련해서 좀 더 편하게 할 수 있도록 하자! -->
				
				<!-- 내용 입력란 -->
				<textarea class="form-control mt-5 " name="content" id="writeContent"><c:out value="${board.content}" /></textarea>
				<!-- 태그 리스트 나오는 곳 -->
				<ul id="tag-list" class='ulWrite'>
        		</ul>
        		<!-- 태그 입력란 -->
        		<c:forEach var="tag" items="${tag}" varStatus="loop">
        			<div style="display: inline;">#<input type="text" class="form-control col-auto" name="tag" value="<c:out value="${tag}" />" style="width: 100px; display: inline; margin: 0.5%;"></div>
        		</c:forEach>
        		
			</div>
				
			<div class="writeButton mt-5">
				<button type="button" class="btn btn-outline-primary" onclick="history.go(-1)">돌아가기</button>
				<button type="submit" class="btn btn-primary">수정하기</button>
			</div>
			<input type="hidden" name="boardNum" value="${boardNum}">
		</form>
	</div>








	<script>
		// 국내 선택시 지역선택 설정 가능
		function disable_select() {
			$("#select_place").attr("disabled", "disabled");
		}
		function disable_select2() {
			$("#select_place").removeAttr("disabled", "disabled");
		}
		
		//대표 사진 클릭시 이전 이미지 hide
	    function thumbnailHide() {
	        $(".board-thumbnail").hide();
	    }
	    function fileHide() {
	        $(".board-file").hide();
	    }
	    
	    // 썸네일 이미지 파일 체크
	    function checkImg(){
	    	var imgFile = $('#thumbnail').val();
	    	var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|JPG|JPEG|PNG|GIF|BMP|PDF)$/;
	    	var maxSize = 5 * 1024 * 1024 * 8;
	    	var fileSize;

	    	if(imgFile != "" && imgFile != null) {
	    		fileSize = document.getElementById("thumbnail").files[0].size;
	    	    
	    	    if(!imgFile.match(fileForm)) {
	    	    	alert("이미지 파일만 업로드 가능");
	    	        return false;
	    	    } else if(fileSize > maxSize) {
	    	    	alert("파일 사이즈는 5MB까지 가능");
	    	        return false;
	    	    }
	    	}
	    }
	    // 이미지 파일 체크
	    function checkImg2(){
	    	var imgFile = $('#input-file').val();
	    	var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|JPG|JPEG|PNG|GIF|BMP|PDF)$/;
	    	var maxSize = 5 * 1024 * 1024 * 8;
	    	var fileSize;

	    	if(imgFile != "" && imgFile != null) {
	    		fileSize = document.getElementById("input-file").files[0].size;
	    	    
	    	    if(!imgFile.match(fileForm)) {
	    	    	alert("이미지 파일만 업로드 가능");
	    	        return false;
	    	    } else if(fileSize > maxSize) {
	    	    	alert("파일 사이즈는 5MB까지 가능");
	    	        return false;
	    	    }
	    	}
	    }
		
		// 대표사진 미리보기
		function setThumbnail(event) {
			for (var image of event.target.files) {
				var reader = new FileReader(); 
				reader.onload = function(event) {
					var img = document.createElement("img"); 
					img.setAttribute("src", event.target.result);
					img.setAttribute("class", "board-thumbnail border border-secondary");
					document.querySelector("div#image_container").appendChild(img); 
				}; 
			console.log(image); reader.readAsDataURL(image); 
			} 
		}
		// 추가사진 미리보기
		function setFile(event) {
			for (var image of event.target.files) {
				var reader = new FileReader(); 
				reader.onload = function(event) {
					var img = document.createElement("img"); 
					img.setAttribute("src", event.target.result);
					img.setAttribute("class", "board-file border border-secondary"); 
					document.querySelector("div#image_container2").appendChild(img); 
				}; 
			console.log(image); reader.readAsDataURL(image); 
			} 
		}
		

	</script>
	
</body>
</html>