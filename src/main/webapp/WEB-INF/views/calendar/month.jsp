<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	section {
		margin: 10px auto;
		width: 80%;
		height: 760px;
	}

	table {
		margin: 10px auto;
		width: 100%;
		border-collapse: collapse;
	}
	
	th:first-child, td:first-child a {
		color: red;
	}
	
	th:last-child, td:last-child a {
		color: blue;
	}
	
	a {
		color: black;
		text-decoration: none;
	}

	th, td {
		width: 100px;
		height: 100px;
		border: 1px solid black;
	}
	
	#calendar_menu {
		float: right;
	}
	
	#calendar_menu a {
		border: 1px solid black;
	}
</style>
<script>
	var today = null;
	var lastArr = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	
	function month(y, m, d) {
		today = new Date(y, m, d);
		
		var table = "";
		var first = new Date(y, m, 1);
		var day = first.getDay();
		
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
			lastArr[1] = 29;
		}
		
		var last = lastArr[m];
		var row = Math.ceil((day + last) / 7);
		var num = 1;
		
		table += "<table>"
		table += "<caption><a href='#' id='prev'>&lt;</a>" + y + "년 " + (m + 1) + "월<a href='#' id='next'>&gt;</a></caption>";
		table += "<tr>";
		table += "<th>일</th>";
		table += "<th>월</th>";
		table += "<th>화</th>";
		table += "<th>수</th>";
		table += "<th>목</th>";
		table += "<th>금</th>";
		table += "<th>토</th>";
		table += "</tr>";
		
		for (var i = 0; i < row; i++) {
			table += "<tr>";
			for (var j = 1;  j <= 7; j++) {
				if (i == 0 && j <= day) {
					table += "<td></td>";
				} else if(num > last) {
					table += "<td></td>";
				} else {
					if(num == d && m == ${map.month} && y == ${map.year}) {
						table += "<td><a href='${pageContext.request.contextPath}/calendar/day' class=''>" + num + "</a></td>";
						table += "<ul>";
						table += "<li>";
						table += "";
						table += "</li>";
						table += "</ul>";
					} else {
						table += "<td><a href='${pageContext.request.contextPath}/calendar/day' class=''>" + num + "</a></td>";
					}
					num++;
				}
			}
			table += "</tr>";
		}
		table += "</table>";
		
		$("#calendar").html(table);
	}
	
	
	$(function(){
		var date = new Date(${map.today.time});
		month(date.getFullYear(), date.getMonth(), date.getDate() );
		
		$(document).on("click", "#prev", function(){
			today.setMonth( today.getMonth() - 1 );
			month(today.getFullYear(), today.getMonth(), today.getDate() );
		})
		
		$(document).on("click", "#next", function(){
			today.setMonth( today.getMonth() + 1 );
			month(today.getFullYear(), today.getMonth(), today.getDate() );
		})
		
	})
</script>
<section>

	<div id="calendar_menu">
		<a href="${pageContext.request.contextPath}/calendar/day">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/month">Month</a>
	</div>
	<div id="calendar">
		
	</div>
</section>
<%@ include file="../include/footer.jsp"%>