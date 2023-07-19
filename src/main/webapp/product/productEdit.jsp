<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h2>상품 정보 상세보기</h2>
		<form action="insertCart.do" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td align="center">사진</td>
					<td align="center">
						&nbsp;<img src="${path}/product/files/${productM.productImgStr}" width=200 height=200>
						<input type=hidden name=custno value="${loginSession.custno}" >
					</td>
				</tr>
				<tr>
					<td align="center">상품번호</td>
					<td>&nbsp;<input type=text name=productId value="${productM.productId}"></td>
				</tr>
				<tr>
					<td align="center">상품명</td>
					<td>&nbsp;<input type=text value="${productM.productName}"></td>
				</tr>
				<tr>
					<td align="center">가격</td>
					<td>&nbsp;<input type=text value="${productM.productPrice}"></td>
				</tr>
				<tr>
					<td align="center">상세설명</td>
					<td>&nbsp;<textarea cols=30 rows=9>${productM.productDesc}</textarea></td>
				</tr>
				<tr>
					<td align="center">구매수량</td>
					<td>&nbsp;<input type=text name=amount min=1 max=5></td>
				</tr>
				<tr>
					<td colspan=2  align="center"> 
						<input type=submit value="구매하기">&emsp;
						<input type=button value="목록보기"  onclick="selectAllProduct(${loginSession.custno})">&emsp;
					    <input type=button value="삭제하기"  onclick="deleteProduct(${productM.productId})">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<br><br>
<script>
	function selectAllProduct(i) {
		location.href = "selectAllProduct.do?custno=" + i;
	}
	function deleteProduct(i) {
		location.href = "deleteProduct.do?productId=" + i;
	}
</script>
<c:import url="/include/bottom.jsp" />