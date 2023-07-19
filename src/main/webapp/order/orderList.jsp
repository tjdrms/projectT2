<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>주문서 현황</h2>
			<table border=1 width=800>
				<tr align="center">
					<th>번호</th>
					<th>주문자번호</th>
					<th>배송비</th>
					<th>총 가격</th>
					<th>주문일</th>
				</tr>
				<c:forEach items="${orderLi}" var="vo">
				<tr align="center">
					<td><a href="selectOrderEdit.do?orderG=${vo.idx}">${vo.idx}</a></td>
					<td>${vo.custno2}</td>
					<td><fmt:formatNumber value="${vo.baesongbi}" pattern="#,###"/>원</td>
					<td><fmt:formatNumber value="${vo.totalMoney}" pattern="#,###"/>원</td>
					<td>${vo.getDate}</td>
				</tr>
				</c:forEach>
			</table>
		<br><br>
	</div>
</section>
<script>
<br><br><br>
<c:import url="/include/bottom.jsp" />