<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>충전소 지도 상세보기</h2>
		<table border=1 width="1000">
			<tr>
				<td colspan=2>
					<div id="map" style="width: 100%; height: 250px;"></div>
				</td>
			</tr>
			<tr>
				<td align="center">번호</td>
				<td>&nbsp;<input type=text name=idx value="${m2.idx}"></td>
			</tr>
			<tr>
				<td align="center">충전소이름</td>
				<td>&nbsp;<input type=text name=rdnmadr value="${m2.csNm}"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td>&nbsp;<input type=text name=entrprsNm size="50" value="${m2.addr}"></td>
			</tr>
			<tr>
				<td align="center">충전타입</td>
				<td>&nbsp;<input type=text name=rprsntvNm value="${m2.cpNm}"></td>
			</tr>
			<tr>
				<td align="center">충전상태코드(1:충전가능 2:충전중 3:고장/점검 4:통신장애 5:통신미연결)</td>
				<td>&nbsp;<input type=text name=mainGoods value="${m2.cpStat}"></td>
			</tr>
		</table>
	</div>
	<br>
</section>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=61c77bfef760de50784298ccbab79587&libraries=services"></script>
		<script th:inline="javascript" >
		/*<![CDATA[*/
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.510202, 126.491506), // 지도의 중심좌표
		        level: 4 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
	 	

		    // 주소로 좌표를 검색합니다
		    geocoder.addressSearch("${m2.addr}", function(result, status) {
	            	
		    	// 정상적으로 검색이 완료됐으면
		        if (status === kakao.maps.services.Status.OK) {

		          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		          // 결과값으로 받은 위치를 마커로 표시합니다
		          var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords,
		          });
		          
		          map.setCenter(coords);

			    } 
			}); 

/*]]>*/
</script>
<c:import url="/include/bottom.jsp" />