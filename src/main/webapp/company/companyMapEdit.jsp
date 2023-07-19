<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>지도 상세보기</h2>
		<table border=1>
			<tr>
				<td colspan=2>
					<div id="map" style="width: 100%; height: 250px;"></div>
				</td>
			</tr>
			<tr>
				<td align="center">번호</td>
				<td>&nbsp;<input type=text name=idx value="${m.idx}"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td>&nbsp;<input type=text name=rdnmadr value="${m.rdnmadr}"></td>
			</tr>
			<tr>
				<td align="center">기업명</td>
				<td>&nbsp;<input type=text name=entrprsNm value="${m.entrprsNm}"></td>
			</tr>
			<tr>
				<td align="center">대표명</td>
				<td>&nbsp;<input type=text name=rprsntvNm value="${m.rprsntvNm}"></td>
			</tr>
			<tr>
				<td align="center">주력상품</td>
				<td>&nbsp;<input type=text name=mainGoods value="${m.mainGoods}"></td>
			</tr>
		</table>
	</div>
	<br>
</section>
<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=61c77bfef760de50784298ccbab79587"></script>
		<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = { 
				        center: new kakao.maps.LatLng(${m.latitude}, ${m.logitude}), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };
				
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
				
				// 마커가 표시될 위치입니다 
				var markerPosition  = new kakao.maps.LatLng(${m.latitude}, ${m.logitude}); 
				
				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
				    position: markerPosition
				});
				
				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);
				
				// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
				// marker.setMap(null);    
		</script>
<c:import url="/include/bottom.jsp" />