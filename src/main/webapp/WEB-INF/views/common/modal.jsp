<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 첫번째 엠블럼 모달 -->
<div class="modal fade" id="emblemModal" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">엠블럼</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"></span>
				</button>
			</div>

			<div class="modal-body row" style="text-align: center">
				<c:forEach var="emblem" items="${emblem}" varStatus="loop">
					<div class="col-4 p-3">
						<c:forEach var="haveEmblem" items="${haveEmblem}" varStatus="loop">
							<c:if test="${emblem.emblemNum eq haveEmblem.emblemNum }">
								<c:set var="get" value="${haveEmblem.emblemNum}"></c:set>
							</c:if>
						</c:forEach>

						<c:if test="${empty get}">
							<c:if test="${empty sessionScope.darkmode}">
								<a data-toggle="modal" href="#Emblem${emblem.emblemNum }"> <img
									alt="" src="resources/img/emblem/none.png" class="icon2"
									style="width: 100%">
								</a>
							</c:if>
							<c:if test="${not empty sessionScope.darkmode}">
								<a data-toggle="modal" href="#Emblem${emblem.emblemNum }"> <img
									alt="" src="resources/img/emblem/darknone.png" class="icon2"
									style="width: 100%">
								</a>
							</c:if>
						</c:if>
						<c:if test="${not empty get}">
							<a data-toggle="modal" href="#getEmblem${emblem.emblemNum }">
								<img alt=""
								src="resources/img/emblem/emblem${emblem.emblemNum}.png"
								class="icon2" style="width: 100%">
							</a>
						</c:if>${emblem.emblemName }
						<c:remove var="get" />
					</div>
				</c:forEach>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					style="margin: auto;">닫기</button>
			</div>
		</div>
	</div>
</div>

<c:if test="${sessionScope.memberNum eq profile.memberNum }">
	<!-- 프로필 수정 모달 -->
	<div class="modal fade" id="profileUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">프로필 수정</h5>
					<button type="button" class="btn-close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true"></span>
					</button>
				</div>
				<div class="modal-body">
					<form action="/profileUpdate" method="post"
						enctype="multipart/form-data">
						<div class="form-group" style="text-align: center;">
							<label for="thumbnail" class="btn btn-outline-secondary mt-3"
								id="image_container"> <span class="imgText">프로필
									사진 수정</span>
							</label> <input name="profile_img" type="file" id="thumbnail"
								accept="image/*"
								onchange="thumbnailHide(); setThumbnail(event);"
								style="display: none" />
							<div class="mt-3" id="image_container"></div>
						</div>
						<br>
						<div class="form-group">
							<label>상태메세지 수정</label> <input type="text" name="message"
								value="<c:out value="${profile.message}" />"
								class="form-control" maxlength="30"> <input
								type="hidden" name="memberNum"
								value="${sessionScope.memberNum }" />
						</div>
						<br>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">닫기</button>
							<button type="submit" class="btn btn-primary">수정</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 획득한 엠블럼 모달 -->
	<c:forEach var="emblem" items="${emblem}" varStatus="loop">
		<div class="modal fade" id="getEmblem${emblem.emblemNum }"
			tabindex="-1" role="dialog" aria-labelledby="modal"
			aria-hidden="true">
			<div class="modal-dialog modal-sm mt-5">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modal">이미 획득한 엠블럼</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>

					<div class="modal-body" style="text-align: center">
						" ${emblem.emblemName } "<br> ${emblem.emblemExplain }
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							style="margin: auto;">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- 획득하지 못한 엠블럼 모달 -->
	<c:forEach var="emblem" items="${emblem}" varStatus="loop">
		<div class="modal fade" id="Emblem${emblem.emblemNum }" tabindex="-1"
			role="dialog" aria-labelledby="modal" aria-hidden="true">
			<div class="modal-dialog modal-sm mt-5">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modal">엠블럼 획득 조건</h5>
						<button type="button" class="btn-close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>

					<div class="modal-body" style="text-align: center">
						" ${emblem.emblemName } "<br> ${emblem.emblemExplain }<br>
						<c:choose>
							<c:when test="${emblem.emblemNum eq 1 }">
								( ${actCnt.tdLikePressCnt } / 1 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 2 }">
								( ${actCnt.tdLikePressCnt } / 10 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 3 }">
								( ${actCnt.tdLikePressCnt } / 100 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 4 }">
								( ${actCnt.pickPressCnt } / 1 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 5 }">
								( ${actCnt.pickPressCnt } / 10 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 6 }">
								( ${actCnt.pickPressCnt } / 100 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 7 }">
								( ${actCnt.boardWriteCnt } / 1 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 8 }">
								( ${actCnt.boardWriteCnt } / 10 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 9 }">
								( ${actCnt.boardWriteCnt } / 100 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 10 }">
								( ${actCnt.replyWriteCnt } / 1 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 11 }">
								( ${actCnt.replyWriteCnt } / 10 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 12 }">
								( ${actCnt.replyWriteCnt } / 100 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 13 }">
								( ${actCnt.tdLikeReceiveCnt } / 1 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 14 }">
								( ${actCnt.tdLikeReceiveCnt } / 10 )
							</c:when>
							<c:when test="${emblem.emblemNum eq 15 }">
								( ${actCnt.tdLikeReceiveCnt } / 100 )
							</c:when>

						</c:choose>
					</div>
					<div class="modal-footer">
						<div style="margin: auto;">

							<form action="/getEmblem" method="POST">
								<input type="hidden" name="memberNum"
									value="${sessionScope.memberNum }">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">닫기</button>



								<c:choose>
									<c:when test="${emblem.emblemNum eq 1 }">
										<c:if test="${actCnt.tdLikePressCnt gt 0}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 2 }">
										<c:if test="${actCnt.tdLikePressCnt gt 9}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 3 }">
										<c:if test="${actCnt.tdLikePressCnt gt 99}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 4 }">
										<c:if test="${actCnt.pickPressCnt gt 0}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 5 }">
										<c:if test="${actCnt.pickPressCnt gt 9}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 6 }">
										<c:if test="${actCnt.pickPressCnt gt 99}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 7 }">
										<c:if test="${actCnt.boardWriteCnt gt 0}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 8 }">
										<c:if test="${actCnt.boardWriteCnt gt 9}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 9 }">
										<c:if test="${actCnt.boardWriteCnt gt 99}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 10 }">
										<c:if test="${actCnt.replyWriteCnt gt 0}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 11 }">
										<c:if test="${actCnt.replyWriteCnt gt 9}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 12 }">
										<c:if test="${actCnt.replyWriteCnt gt 99}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 13 }">
										<c:if test="${actCnt.tdLikeReceiveCnt gt 0}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 14 }">
										<c:if test="${actCnt.tdLikeReceiveCnt gt 9}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>
									<c:when test="${emblem.emblemNum eq 15 }">
										<c:if test="${actCnt.tdLikeReceiveCnt gt 99}">
											<input type="hidden" name="emblemNum"
												value="${emblem.emblemNum }">
											<button type="submit" class="btn btn-warning">획득하기</button>
										</c:if>
									</c:when>

								</c:choose>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>

<!-- 지도 모달 -->
<div class="modal fade" id="boardModal" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">나만의 여행지도</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"></span>
				</button>
			</div>
			<div class="modal-body">
				<div id="map" style="width: 100%; height: 600px; margin: auto; color: black;"></div>
			</div>
			<div class="modal-footer">
				<div style="margin: auto;">
					<button type="button" class="btn btn-primary" onclick="relayout()">지도
						재호출</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- pick 모달 -->
<div class="modal fade" id="pickModal" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">PICK!</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"></span>
				</button>
			</div>
			<div class="modal-body" style="text-align: center;">
				여행가고 싶은곳을 "PICK" 해보세요!<br> 그리고 자신이 여행간 일을 공유해주세요.<br>
				여행일기를 작성하면 달력에 여행 날짜가 표시됩니다.
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					style="margin: auto;">닫기</button>
			</div>
		</div>
	</div>
</div>


<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d21da3744ebeea9a10c9a6f6aa2244c4"></script>
<script type="text/javascript">

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	mapOption = {
		center : new kakao.maps.LatLng(38.7083, 124.9358), // 지도의 중심좌표
		level : 13
	// 지도의 확대 레벨
	};
	// 지도를 생성한다 
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 마커를 표시할 위치와 title 객체 배열입니다 
	var positions = [
		<c:forEach var="mapCmd" items="${mapCmd}" varStatus="loop">
			{
			content : '<div style="padding:3px;width:150px;text-align:center; margin:auto;">TripDiary</div>',
	  	     latlng : new kakao.maps.LatLng(${mapCmd.markerLat} , ${mapCmd.markerLng})
	  	    },
	  	</c:forEach>
	];

	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

	for (var i = 0; i < positions.length; i++) {

		// 마커 이미지의 이미지 크기 입니다
		var imageSize = new kakao.maps.Size(24, 35);

		// 마커 이미지를 생성합니다    
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			map : map, // 마커를 표시할 지도
			position : positions[i].latlng, // 마커를 표시할 위치
			title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			image : markerImage
		// 마커 이미지 
		});
		
	    // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });

	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	}
	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}

	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}

	function openModal(){
		setTimeout(function (){
			map.relayout(); 
			}, 300);
	}
	function relayout() {    
	    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
	    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
	    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
		map.relayout(); 
	}

	
		// 풀캘린더 스크립트 부분
		var all_events = null;
		<c:if test="${not empty calendar}">
		all_events = [
			<c:forEach var="calendarList" items="${calendar}" varStatus="loop">
				{
		  	      title  : '여행일',
		  	      start  : '${calendarList }'
		  	    },
		  	</c:forEach>
	  	  ]
		</c:if>
		$(document).ready(function() {
		    var calendarEl = document.getElementById('calendar');
		    var calendar = new FullCalendar.Calendar(calendarEl, {
		      initialView: 'dayGridMonth',
		      locales: 'ko',
		      events: all_events
	    });
	    calendar.render();
	  });    
		
		// 프로필 사진 클릭시 이전 이미지 hide
	    function thumbnailHide() {
	        $(".board-thumbnail").hide();
	    }
		
		// 프로필 사진 미리보기
		function setThumbnail(event) {
			for (var image of event.target.files) {
				var reader = new FileReader(); 
				reader.onload = function(event) {
					var img = document.createElement("img"); 
					img.setAttribute("src", event.target.result);
					img.setAttribute("class", "board-thumbnail border border-secondary rounded-circle"); 
					document.querySelector("div#image_container").appendChild(img); 
				}; 
			console.log(image); reader.readAsDataURL(image); 
			} 
		}
	</script>
