<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
thead{background-color: yellow}

</style>
</head>
<body>
<h2 align="center">${item.itemName}의 정보</h2>
<table align="center">
	<thead>
		<tr align="right">
			<td>조회수</td>
			<td>장바구니 담기</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td rowspan="3">
				<img src="img/${item.url}"><br>
				<a href="fruit.do">상품 목록 보기</a>
			</td>
			<td> 종류: ${item.itemName}</td>
		</tr>
		<tr>
			<td> 가격: ${item.price}</td>
		</tr>
		<tr>
			<td> 설명: ${item.description }</td>
		</tr>
	</tbody>
</table>
</body>
</html>