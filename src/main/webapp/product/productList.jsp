<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<c:set var="path2" value="${pageContext.request.contextPath}" />
<section>
	<br>
	<div align="center">
		<h2>상품 목록 조회</h2>
		<table border=1 width=800>
			<tr align="center">
				<td>상품번호</td>
				<td>상품명</td>
				<td>가격</td>
				<td>상세설명</td>
				<td>상품사진</td>
				<td>등록일</td>
			</tr>
			<c:forEach items="${productLi}" var="vo" varStatus="status">
			<tr align="center">
				<td>${vo.productId}</td>
				<td><a href="selectOneProduct.do?productId=${vo.productId}">${vo.productName}</a></td>
				<td><fmt:formatNumber value="${vo.productPrice}" pattern="#,###"/>원</td>
				<td>${vo.productDesc}</td>
				<td><img src="${path}/product/files/${vo.productImgStr}" width=100 height=100></td>
				<td>${vo.productDate}</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>
</section>
<br><br><br>
<c:import url="/include/bottom.jsp" />