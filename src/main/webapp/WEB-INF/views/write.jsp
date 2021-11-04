<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="stylesheet" href="/resources/css/writeStyle.css" />
<link rel="stylesheet" href="/resources/css/mapStyle.css" />
<title>TripDiary</title>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />

	<div class="container">
		<h2>글쓰기</h2>
		
		<div class="writeForm mt-5" style="text-align: left;">
		<h4>키워드 검색 >> 여행간 곳 마커로 표시</h4>
		<div class="map_wrap"style="margin: auto; color: black">
			<div id="map"style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
				<div id="menu_wrap" class="bg_white">
					<div class="option">
						<div>
							<form onsubmit="searchPlaces(); return false;">
								키워드 : <input type="text" value="강남" id="keyword" size="15">
								<button type="submit">검색하기</button>
							</form>
						</div>
					</div>
					<hr>
					<ul id="placesList"></ul>
					<div id="pagination"></div>
				</div>
			</div>
		</div>

		<form action="/write" method="post" enctype="multipart/form-data"
			class="mt-5 mb-5">
			<div id="clickLatlng" style="display: none"></div>
				<input type="hidden" id="lat" name="markerLat" value="0"> 
				<input type="hidden" id="lng" name="markerLng" value="0"> 
			<div class="writeForm mt-5">
				<div class="writeSelect row ">	
					<div class="col-auto mb-5">
						<h4>여행 날짜</h4>
						<c:set var="year" value="2021" />
						<select name="year" class="form-select">
							<option value="${year}" selected>${year}</option>
							<c:forEach var="i" begin="1" end="70">
								<option value="<c:out value="${year-i}" />"><c:out
										value="${year-i}" />
								</option>
							</c:forEach>
	
						</select> <select name="month" class="form-select">
							<option value="1" selected>1</option>
							<c:forEach var="i" begin="2" end="12">
								<option value="${i}">${i}</option>
							</c:forEach>
	
						</select> <select name="day" class="form-select">
							<option value="1" selected>1</option>
							<c:forEach var="i" begin="2" end="31">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-auto mb-5">
						<h4 class="">여행 지역</h4>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="placeCheck"
								value="abroad" onclick="disable_select()"> <label
								class="form-check-label">해외</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="placeCheck"
								onclick="disable_select2()" checked> <label
								class="form-check-label">국내</label>
						</div>
	
						<select name="place" id="select_place" class="form-select">
							<option value="seoul" selected>서울특별시</option>
							<option value="busan">부산광역시</option>
							<option value="daegu">대구광역시</option>
							<option value="incheon">인천광역시</option>
							<option value="gwangju">광주광역시</option>
							<option value="daejeon">대전광역시</option>
							<option value="ulsan">울산광역시</option>
							<option value="sejong">세종특별자치시</option>
							<option value="gyeonggi">경기도</option>
							<option value="gangwon">강원도</option>
							<option value="chungbuk">충청북도</option>
							<option value="chungnam">충청남도</option>
							<option value="jeonbuk">전라북도</option>
							<option value="jeonnam">전라남도</option>
							<option value="gyeongbuk">경상북도</option>
							<option value="gyeongnam">경상남도</option>
							<option value="jeju">제주도특별자치도</option>
						</select>
					</div>
				</div>

				
					
				<label for="thumbnail" class="btn btn-outline-secondary mt-5"
					id="image_container"> <span class="imgText">대표사진 업로드
						(최대 1장)</span>
				</label> <input name="thumbnail" type="file" id="thumbnail" accept="image/*"
					onchange="checkImg(); thumbnailHide(); setThumbnail(event);" style="display: none" />
				<div class="mt-3" id="image_container"></div> 

				<label for="input-file" class="btn btn-outline-secondary mt-3"
					id="image_container"> <span class="imgText">추가사진 업로드
						(최대 10장)</span>
				</label> <input name="file" type="file" id="input-file" accept="image/*"
					onchange="checkImg2(); fileHide(); setFile(event);" style="display: none"
					multiple="multiple" />
				<div class="mt-5" id="image_container2"></div>
				<h6 class="mt-5" style="color: red;">
					* 등록할 사진을 한번에 클릭해 업로드 해주십시오.<br>* 버튼을 재클릭시 이전에 업로드한 사진은 등록되지
					않습니다.
				</h6>
				
				

				<!-- 내용 입력란 -->
				<textarea class="form-control mt-5 "
					placeholder="내용을 입력해주세요.  (1000자 이내)" name="content"
					id="writeContent"></textarea>
				<!-- 태그 리스트 나오는 곳 -->
				<ul id="tag-list" class='ulWrite'>
				</ul>
				<!-- 태그 입력란 -->
				<textarea id="tag" class="form-control mb-5"
					placeholder="#태그를 입력해주세요. (태그 형식으로 10자 이내, 최대 5개)"></textarea>
			</div>

			<div class="writeButton">
				<button type="button" class="btn btn-outline-primary"
					onclick="history.go(-1)">돌아가기</button>
				<button type="submit" class="btn btn-primary">작성하기</button>
			</div>
			<input type="hidden" name="memberNum" value="${memberNum}">
		</form>
	</div>






	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d21da3744ebeea9a10c9a6f6aa2244c4&libraries=services"></script>
	<script>
		// 마커를 담을 배열입니다
		var markers = [];

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places();

		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		// 키워드로 장소를 검색합니다
		searchPlaces();

		// 키워드 검색을 요청하는 함수입니다
		function searchPlaces() {

			var keyword = document.getElementById('keyword').value;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				alert('키워드를 입력해주세요!');
				return false;
			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			ps.keywordSearch(keyword, placesSearchCB);
		}

		// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				// 정상적으로 검색이 완료됐으면
				// 검색 목록과 마커를 표출합니다
				displayPlaces(data);

				// 페이지 번호를 표출합니다
				displayPagination(pagination);

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 결과가 존재하지 않습니다.');
				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		// 검색 결과 목록과 마커를 표출하는 함수입니다
		function displayPlaces(places) {

			var listEl = document.getElementById('placesList'), menuEl = document
					.getElementById('menu_wrap'), fragment = document
					.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

			// 검색 결과 목록에 추가된 항목들을 제거합니다
			removeAllChildNods(listEl);

			// 지도에 표시되고 있는 마커를 제거합니다
			removeMarker();

			for (var i = 0; i < places.length; i++) {

				// 마커를 생성하고 지도에 표시합니다
				var placePosition = new kakao.maps.LatLng(places[i].y,
						places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
						i, places[i]); // 검색 결과 항목 Element를 생성합니다

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				bounds.extend(placePosition);

				// 마커와 검색결과 항목에 mouseover 했을때
				// 해당 장소에 인포윈도우에 장소명을 표시합니다
				// mouseout 했을 때는 인포윈도우를 닫습니다
				(function(marker, title) {
					kakao.maps.event.addListener(marker, 'mouseover',
							function() {
								displayInfowindow(marker, title);
							});

					kakao.maps.event.addListener(marker, 'mouseout',
							function() {
								infowindow.close();
							});

					itemEl.onmouseover = function() {
						displayInfowindow(marker, title);
					};

					itemEl.onmouseout = function() {
						infowindow.close();
					};
				})(marker, places[i].place_name);

				fragment.appendChild(itemEl);
			}

			// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
			listEl.appendChild(fragment);
			menuEl.scrollTop = 0;

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			map.setBounds(bounds);
		}

		// 검색결과 항목을 Element로 반환하는 함수입니다
		function getListItem(index, places) {

			var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
					+ (index + 1)
					+ '"></span>'
					+ '<div class="info">'
					+ '   <h5>' + places.place_name + '</h5>';

			if (places.road_address_name) {
				itemStr += '    <span>' + places.road_address_name + '</span>'
						+ '   <span class="jibun gray">' + places.address_name
						+ '</span>';
			} else {
				itemStr += '    <span>' + places.address_name + '</span>';
			}

			itemStr += '  <span class="tel">' + places.phone + '</span>'
					+ '</div>';

			el.innerHTML = itemStr;
			el.className = 'item';

			return el;
		}

		// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
		function addMarker(position, idx, title) {
			var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
			imgOptions = {
				spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
				spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				offset : new kakao.maps.Point(13, 37)
			// 마커 좌표에 일치시킬 이미지 내에서의 좌표
			}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new kakao.maps.Marker({
				position : position, // 마커의 위치
				image : markerImage
			});

			marker.setMap(map); // 지도 위에 마커를 표출합니다
			markers.push(marker); // 배열에 생성된 마커를 추가합니다

			return marker;
		}

		// 지도 위에 표시되고 있는 마커를 모두 제거합니다
		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
		function displayPagination(pagination) {
			var paginationEl = document.getElementById('pagination'), fragment = document
					.createDocumentFragment(), i;

			// 기존에 추가된 페이지번호를 삭제합니다
			while (paginationEl.hasChildNodes()) {
				paginationEl.removeChild(paginationEl.lastChild);
			}

			for (i = 1; i <= pagination.last; i++) {
				var el = document.createElement('a');
				el.href = "#";
				el.innerHTML = i;

				if (i === pagination.current) {
					el.className = 'on';
				} else {
					el.onclick = (function(i) {
						return function() {
							pagination.gotoPage(i);
						}
					})(i);
				}

				fragment.appendChild(el);
			}
			paginationEl.appendChild(fragment);
		}

		// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
		// 인포윈도우에 장소명을 표시합니다
		function displayInfowindow(marker, title) {
			var content = '<div style="padding:5px;z-index:1;">' + title
					+ '</div>';

			infowindow.setContent(content);
			infowindow.open(map, marker);
		}

		// 검색결과 목록의 자식 Element를 제거하는 함수입니다
		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}
		
		var lat, lng;
		//지도에 클릭 이벤트를 등록합니다
		//지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

			// 클릭한 위도, 경도 정보를 가져옵니다 
			var latlng = mouseEvent.latLng;

			// 마커 위치를 클릭한 위치로 옮깁니다
			marker.setPosition(latlng);
			
			lat = latlng.getLat();
			lng = latlng.getLng();
			
			
			var message = '위도는 ' + lat + ' , ';
			message += '경도는 ' + lng + ' 입니다';
			document.getElementById("lat").value= lat;
			document.getElementById("lng").value= lng;
			var resultDiv = document.getElementById('clickLatlng');
			resultDiv.innerHTML = message;


		});
		//지도를 클릭한 위치에 표출할 마커입니다
		var marker = new kakao.maps.Marker({
			// 지도 중심좌표에 마커를 생성합니다 
			position : map.getCenter()
		});

		//지도에 마커를 표시합니다
		marker.setMap(map);
		
	    function check(){
	    	document.getElementById("lat").value= lat;
	    }

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
		     function test() {
		          $(".board-thumbnail").hide();
		          $(".board-file").hide();
		      }
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
		
		// 태그 입력받기
	    $(document).ready(function () {

	        var tag = {};
	        var counter = 0;

	        // 태그를 추가한다.
	        function addTag (value) {
	            tag[counter] = value; // 태그를 Object 안에 추가
	            counter++; // counter 증가 삭제를 위한 del-btn 의 고유 id 가 된다.
	        }

	        // 최종적으로 서버에 넘길때 tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
	        function marginTag () {
	            return Object.values(tag).filter(function (word) {
	                return word !== "";
	            });
	        }

	        $("#tag").on("keypress", function (e) {
	            var self = $(this);

	            // input 에 focus 되있을 때 엔터 및 스페이스바 입력시 구동
	            if (e.key === "Enter" || e.keyCode == 32) {

	                var tagValue = self.val(); // 값 가져오기

	                // 값이 없으면 동작 ㄴㄴ
	                if (tagValue !== "") {

	                    // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
	                    var result = Object.values(tag).filter(function (word) {
	                        return word === tagValue;
	                    })
	                
	                    // 태그 중복 검사
	                    if (result.length == 0) { 
	                        $("#tag-list").append("<li class='tag-item' name='tag'><input name='tag' type='hidden' value='"+tagValue+"'/>    #"+tagValue+"<span class='del-btn' idx='"+counter+"'>x</span></li>");
	                        addTag(tagValue);
	                        self.val("");
	                    } else {
	                        alert("태그값이 중복됩니다.");
	                    }
	                }
	                e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
	            }
	        });

	        // 삭제 버튼 
	        // 삭제 버튼은 비동기적 생성이므로 document 최초 생성시가 아닌 검색을 통해 이벤트를 구현시킨다.
	        $(document).on("click", ".del-btn", function (e) {
	            var index = $(this).attr("idx");
	            tag[index] = "";
	            $(this).parent().remove();
	        });
	})
	</script>

</body>
</html>