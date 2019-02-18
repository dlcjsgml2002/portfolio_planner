<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th, td {
		width: 100px;
		height: 100px;
	}
</style>
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
	document.write("<th>일</th>");
	document.write("<th>월</th>");
	document.write("<th>화</th>");
	document.write("<th>수</th>");
	document.write("<th>목</th>");
	document.write("<th>금</th>");
	document.write("<th>토</th>");
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
				document.write("<td><a href='#'>" + num + "</a></td>");
				num++;
			}
		}
		document.write("</tr>");
	}
	document.write("</table>");
</script>
</head>
<body>
</body>
</html>