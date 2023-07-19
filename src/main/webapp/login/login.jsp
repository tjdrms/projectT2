<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
<br>
	<div align=center>
		<h2>로 그 인</h2>
		<form name=f1 action="${path}/login.do">
			<table border=1 width="300">
				<tr>
					<td align="center">아이디</td>  
				    <td><input type=text name=id /> </td>
				</tr> 
				<tr>
					<td align="center">비밀번호</td>  
				   	<td><input type=text name=password /> </td>
				</tr>
				<tr>
					<td colspan=2  align="center"> 
				    	<input  type=submit value="로그인">&emsp;
				   </td>
			   </tr>
			</table>
		</form>
	</div>
<br>
</section>

<c:import url="/include/bottom.jsp" />