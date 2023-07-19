<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<section>
 <br>
 <div align="center">
 <h2> 회원매출조회 </h2>
 
 <table border=1>
  <tr align="center"> 
	 <td>회원번호</td> <td>회원이름</td>
	 <td>회원등급</td>	 <td>회원매출</td> 
  </tr>    
 
 
 <c:forEach items="${li}"  var="m" >
 <tr align="center"> 
	 <td>${m.custno} </td>
	 <td>${m.custname}</td>
	 <td>${m.grade}</td>
	 <td>${m.price}</td>
	 
  </tr> 
  
 </c:forEach>
 </table>
 

 </div>
 <br>
</section>
<c:import url="/include/bottom.jsp" />