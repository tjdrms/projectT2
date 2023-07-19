<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  

<c:set var="path" value="${pageContext.request.contextPath}"
                                          scope="session" />

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>마주스토리/마주이야기</title>
<link href="${path}/include/top.css" rel="stylesheet" type="text/css"  />
<style type="text/css">

</style>

</head>
<body>
<header>
 <b> 마주스토리 / 마주이야기 쇼핑몰 </b>
</header>
<nav>
&emsp;<a href="${path}/ShopForm.do">회원등록</a>
&emsp;<a href="${path}/ShopSelectAll.do">회원목록</a>
&emsp;<a href="${path}/ShopMoney.do">회원매출조회</a>
<c:if test="$user == 'admin'">
	&emsp;<a href="${path}/companySelectAll.do">공공API기업조회</a>
	&emsp;<a href="${path}/evSelectAll.do">전기차충전소조회</a>
	&emsp;<a href="${path}/companyMapSelectAll.do">공공API카카오맵</a>
	&emsp;<a href="${path}/evSelectMapAll.do">전기차충전소카카오맵api</a>
</c:if>
&emsp;<a href="${path}/product/productForm.jsp">상품등록</a>
&emsp;<a href="${path}/selectAllProduct.do">상품목록조회</a>

&emsp;<a href="${path}/index.jsp">홈으로.</a>

<c:if test="${empty loginSession.custno}">
&emsp;<a href="${path}/login/login.jsp">로그인</a>
</c:if>

<c:if test="${!empty loginSession.custno}">
&emsp;<a href="${path}/logout.do?custno=${loginSession.custno}">${loginSession.custname}</a>
&emsp;<a href="${path}/selectCustnoCount.do?custno=${loginSession.custno}">장바구니</a>
</c:if>
&emsp;<a href="${path}/selectOrderMoney.do">주문서목록</a>
</nav>