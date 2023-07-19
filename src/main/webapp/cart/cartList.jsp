<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>장바구니 조회</h2>
		<form method="post" name="f1">
			<table border=1 width=800>
				<tr align="center">
					<th>번호</th>
					<th>상품사진</th>
					<th>상품명</th>
					<th>가격</th>
					<th>수량</th>
					<th>총 합</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${cartLi}" var="vo">
				<input type="hidden" name="cartId" value="${vo.cartId}" />
				<input type="hidden" name="custno" value="${loginSession.custno}" />
				<input type="hidden" name="productId" value="${vo.productId}" />
				<input type="hidden" name="productName" value="${vo.productName}" />
				<tr align="center">
					<c:set var="productAmountPrice" value="${vo.productPrice * vo.amount}" />
					<td>${vo.cartId}</td>
					<td><img src="${path}/product/files/${vo.productImg}" width=100 height=100></td>
					<td>${vo.productName}</td>
					<td><fmt:formatNumber value="${vo.productPrice}" pattern="#,###"/>원</td>
					<td><input type="number" value="${vo.amount}" name=amount></td>
					<td><fmt:formatNumber value="${productAmountPrice}" pattern="#,###"/>원</td>
					<td align="center"><input type="button" value="X" onclick="deleteOneCart('${vo.cartId}', '${loginSession.custno}')" /></td>
					<c:set var="totalPrice" value="${totalPrice + productAmountPrice}" />
				</tr>
				</c:forEach>
				<tr align="center">
					<td colspan=7 align="left">
						<c:choose>
							<c:when test="${totalPrice} >= 30000">
							<c:set var="baesongbi" value="0" />
							배송비: ${baesongbi}원 
							<br>
							장바구니 금액 합계: <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원
							<input type="hidden" name="totalMoney" value="${totalPrice}" />
							<input type="hidden" name="baesongbi" value="${baesongbi}" />
							</c:when>
							<c:otherwise>
							<c:set var="baesongbi" value="3000" />
							배송비: <fmt:formatNumber value="${baesongbi}" pattern="#,###"/>원
							<br>
							장바구니 금액 합계: <fmt:formatNumber value="${totalPrice + deliverPrice}" pattern="#,###"/>원
							<input type="hidden" name="totalMoney" value="${totalPrice + deliverPrice}" />
							<input type="hidden" name="baesongbi" value="${baesongbi}" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr align="center">
					<td colspan=7 align="center">
						<input type="submit" value="주문하기" onclick="javascript:action='orderCart.do'">&emsp;
						<input type="submit" value="수정하기" onclick="javascript:action='updateCart.do'">&emsp;
						<input type="button" value="전체삭제" onclick="deleteAllCart(${loginSession.custno})">
					</td>
				</tr>
			</table>
		</form>
		<br><br>
	</div>
</section>
<script>
function deleteOneCart(i, j) {
	alert('이 상품을 삭제하시겠습니까?');
	location.href = "deleteOneCart.do?cartId=" + i + "&custno=" + j;
}
function deleteAllCart(i) {
	alert("장바구니를 비우시겠습니까?");
	location.href = "deleteAllCart.do?custno=" + i;
}
</script>
<br><br><br>
<c:import url="/include/bottom.jsp" />