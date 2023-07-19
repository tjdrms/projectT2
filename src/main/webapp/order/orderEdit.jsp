<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>주문 정보 상세보기</h2>
			<table border=1 width=800>
				<tr align="center">
					<th>주문번호</th>
					<th>상품번호</th>
					<th>상품명</th>
					<th>수량</th>
				</tr>
				<c:forEach items="${orderEditLi}" var="vo">
				<tr align="center">
					<td><${vo.idx}</td>
					<td>${vo.productId}</td>
					<td>${vo.productName}</td>
					<td>${vo.amount}개</td>
				</tr>
				</c:forEach>
			</table>
	</div>
	<br>
</section>
<br><br>
<c:import url="/include/bottom.jsp" />