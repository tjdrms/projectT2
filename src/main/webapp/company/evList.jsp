<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>전기차 충전소 목록 조회</h2>
		<table border=1 width=1000>
			<tr align="center">
				<td>No.</td>
				<td>충전소이름</td>
				<td>주소</td>
				<td>충전타입</td>
				<td>CPSTAT</td>
			</tr>
			<c:forEach items="${li2}" var="vo" varStatus="status">
			<tr align="center">
				<td>${vo.idx}</td>
				<td>
					<c:url value="/companyEdit.do" var="url">
						<c:param name="csNm" value="${vo.csNm}" />
						<c:param name="idx" value="${vo.idx}" />
					</c:url>
					<a href="${url}">${vo.csNm}</a>
				</td>
				<td>${vo.addr}</td>
				<td>${vo.cpNm}</td>
				<td>${vo.cpStat}</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>
</section>
<br><br><br>
<c:import url="/include/bottom.jsp" />