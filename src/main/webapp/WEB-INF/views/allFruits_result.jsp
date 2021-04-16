<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">SHOW ALL FRUITS I.</h1>
	<table align="center" border="2">
		<tr>
			<c:forEach items="${itemList}" var="item">
				<td><a href="detail.do?itemnumber=${item.itemId}"><img
						src="img/${item.url}" width="150" height="150"></a><br> <!-- ?뒤의 부분이 그대로 FruitController 로 form 에서 값을 갖고오는 것과 동일하게 전해짐  이때, Integer itemIddd 로 값을 form 이름과 동일하게 parameter로 받으면 객체에 자동 바인딩된다 -->
					상품명 : ${item.itemName}<br> 가 격 : ${item.price}원</td>
			</c:forEach>
		</tr>
	</table>


	<!-- 오늘 본 상품 정보를 이곳에 출력  -->
	<c:if test="${!empty fruits}">
		<h2 align="center">
			<font color="purple">오늘 본 상품 정보</font>
		</h2>
		<table align="center" bgcolor="lightgray">
			<tr>
				<c:forEach items="${fruits}" var="fruit">
					<td><img src="${fruit}" width="100" height="100"></td>
				</c:forEach>
			</tr>
		</table>
	</c:if>
</body>
</html>