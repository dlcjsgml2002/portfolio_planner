<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	table {
		margin: 10px auto;
		width: 50%;
		border-collapse: collapse;
	}
	
	th:first-child, td:first-child a {
		color: red;
	}
	
	th:last-child, td:last-child a {
		color: blue;
	}
	
	a {
		text-decoration: none;
	}

	th, td {
		width: 100px;
		height: 100px;
		border: 1px solid black;
	}
</style>
<script>
	var today = null;
	var month = ${map.month};
	var tyear = ${map.year};
	function cal(y, m, d) {		
		var table = "";
		today = new Date(y, m, d);
		var oneDay = new Date(y, m, 1);
		var theDay = oneDay.getDay();
		
		var lastArr = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		var year = y;
		
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			lastArr[1] = 29;
		}
		
		var lastDay = lastArr[m];
		var row = Math.ceil((theDay + lastDay) / 7);
		
		table += "<table>"
		table += "<caption><a href='#' id='prev'>&lt;</a>" + y + "." + (m + 1) + "<a href='#' id='next'>&gt;</a></caption>";
		table += "<tr>";
		table += "<th>일</th>";
		table += "<th>월</th>";
		table += "<th>화</th>";
		table += "<th>수</th>";
		table += "<th>목</th>";
		table += "<th>금</th>";
		table += "<th>토</th>";
		table += "</tr>";
		
		var num = 1;
		
		for (var i = 0; i < row; i++) {
			table += "<tr>";
			for (var j = 1;  j <= 7; j++) {
				if (i == 0 && j <= theDay) {
					table += "<td></td>";
				} else if(num > lastDay) {
					table += "<td></td>";
				} else {
					if(num == d && m == month && y == tyear) {
						table += "<td><a href='${pageContext.request.contextPath}/board/today' class=''>" + num + "</a></td>";
					} else {
						table += "<td><a href='${pageContext.request.contextPath}/calendar/today' class=''>" + num + "</a></td>";
					}
					num++;
				}
			}
			table += "</tr>";
		}
		table += "</table>";
		
		$("#cal").html(table);
	}
	
	$(function(){
		var date = new Date(${map.today.time});
		cal(date.getFullYear(), date.getMonth(), date.getDate() );
		
		$(document).on("click", "#prev", function(){
			today.setMonth( today.getMonth() - 1 );
			cal(today.getFullYear(), today.getMonth(), today.getDate() );
		})
		
		$(document).on("click", "#next", function(){
			today.setMonth( today.getMonth() + 1 );
			cal(today.getFullYear(), today.getMonth(), today.getDate() );
		})
		
	})
</script>
<section>
	<div>
		<a href="${pageContext.request.contextPath}/calendar/today">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/calendar">Month</a>
	</div>
	<div id="cal">
		
	</div>
</section>
<%@ include file="../include/footer.jsp"%>