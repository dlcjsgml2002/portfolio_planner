<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var today = new Date();
	var oneDay = new Date(today.getFullYear(), today.getMonth(), 1);
	var theDay = oneDay.getDay();
	                
	var lastArr = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	var year = today.getFullYear();
	
	if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
		lastArr[1] = 29;
	}
	
	var lastDay = lastArr[today.getMonth()];
	var row = Math.ceil((theDay + lastDay) / 7);
	console.log(row);
	
	document.write("<table>");
	document.write("<caption>" + year + "." + (today.getMonth() + 1) + "</caption>");
	document.write("<tr>");
	document.write("<td>일</td>");
	document.write("<td>월</td>");
	document.write("<td>화</td>");
	document.write("<td>수</td>");
	document.write("<td>목</td>");
	document.write("<td>금</td>");
	document.write("<td>토</td>");
	document.write("</tr>");
	
	var num = 1;
	
	for (var i = 0; i < row; i++) {
		document.write("<tr>");
		for (var j = 1;  j <= 7; j++) {
			if (i == 0 && j <= theDay) {
				document.write("<td></td>");
			} else if(num > lastDay) {
				document.write("<td></td>");
			} else {
				document.write("<td>" + num + "</td>");
				num++;
			}
		}
		document.write("</tr>");
	}
	document.write("</table>");
</script>
</head>
<body>
 	<table>
 		<tr>
 			<th>일</th>
 			<th>월</th>
 			<th>화</th>
 			<th>수</th>
 			<th>목</th>
 			<th>금</th>
 			<th>토</th>
 		</tr>
 		<tr>
 		</tr>
 	</table>
</body>
</html>