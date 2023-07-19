<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>공공 API 기업 조회</h2>
		<table border=1 width=1000>
			<tr align="center">
				<td>No.</td>
				<td>번호</td>
				<td>기업명</td>
				<td>대표명</td>
				<td>주력상품</td>
				<td>지역</td>
				<td>위도</td>
				<td>경도</td>
			</tr>
			<c:forEach items="${li}" var="vo" varStatus="status">
			<tr align="center">
				<td>${status.count}</td>
				<td>${vo.idx}</td>
				<td>
					<c:url value="/companyEdit.do" var="url">
						<c:param name="entrprsNm" value="${vo.entrprsNm}" />
						<c:param name="sno" value="${vo.idx}" />
					</c:url>
					<a href="${url}">${vo.entrprsNm}</a>
				</td>
				<td>${vo.rprsntvNm}</td>
				<td>${vo.mainGoods}</td>
				<td>${vo.rdnmadr}</td>
				<td>${vo.latitude}</td>
				<td>${vo.logitude}</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>
</section>
<br><br><br>
<c:import url="/include/bottom.jsp" />