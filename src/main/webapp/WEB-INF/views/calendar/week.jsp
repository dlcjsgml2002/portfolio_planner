<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	section {
		margin: 100px auto;
		width: 80%;
		height: 760px;
	}

	table {
		margin: 10px auto;
		width: 100%;
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
		border: 1px solid black;
	}
	
	th {
		height: 50px;
		text-align: center;
	}
	
	td {
		height: 100px;
		padding-top: 2px;
		padding-left: 2px;
		vertical-align: top;
	}
	
	#calendar_menu {
		float: right;
	}
	
	#calendar_menu a {
		border: 1px solid black;
	}
	
	.btn-group {
		float: right;
		margin-bottom: 20px;
	}
	
	button {
		width: 130px;
	}
	
	span {
		color: black;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	<li>{{title}}</li>
</script>
<script>
	var today = null;
	
	function getMonthList() {
		var month = today.getFullYear() + "-" + (today.getMonth() + 1);
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/monthajax",
			type : "get",
			data : {
				"mno": ${login.mno},
				"month": month
				},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				for (var i = 0; i < json.length; i++) {
					var date = new Date(json[i].appDate);
					var day = date.getDate();
					
					console.log(date.getDate());
					
					var source = $("#template1").html();
					var f = Handlebars.compile(source);
					var result = f(json[i].plan);
					
					$("td a[value=" + day + "] + ul").append(result);
				}
				             
				}
			})
		}
	
	function week(y, m, d) {
		today = new Date(y, m, d);
		
		var table = "";
		var day = today.getDay();
		
		table += "<table>"
		table += "<thead class='thead-dark'><tr><th colspan='7'><h3><a href='#' id='prev'>&lt;</a><span> " + y + "년 " + (m + 1) + "월 </span><a href='#' id='next'>&gt;</a></h3></th></tr></thead>";
		table += "<tr>";
		table += "<th>일</th>";
		table += "<th>월</th>";
		table += "<th>화</th>";
		table += "<th>수</th>";
		table += "<th>목</th>";
		table += "<th>금</th>";
		table += "<th>토</th>";
		table += "</tr>";
		table += "<tr>";
		
		for (var i = 0; i < day; i++) {
			var date = new Date(today.getFullYear(), today.getMonth(), today.getDate());
			today.setDate(today.getDate() - (day - i));
			var time = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
			table += "<td>";
			table += "<a href='${pageContext.request.contextPath}/calendar/day?time=" + time + "' value='" + (today.getDate()) + "'>" + (today.getDate()) + "</a>";
			table += "<ul></ul>";
			table += "</td>";
			today = date;
		}                
		                                     
		for (var i = day; i < 7; i++) {
			var date = new Date(today.getFullYear(), today.getMonth(), today.getDate());
			today.setDate(today.getDate() - (day - i));
			var time = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
			table += "<td>";
			table += "<a href='${pageContext.request.contextPath}/calendar/day?time=" + time + "' value='" + (today.getDate()) + "'>" + (today.getDate()) + "</a>";
			table += "<ul></ul>";
			table += "</td>";
			today = date;
		}
		
		table += "</tr>";
		table += "</table>";
		                                
		$("#calendar").html(table);
		getMonthList();
	}
	
	
	$(function(){
		var date = new Date(${map.today.time});
		week(date.getFullYear(), date.getMonth(), date.getDate());
		
		$(document).on("click", "#prev", function(){
			today.setDate( today.getDate() - 7 );
			week(today.getFullYear(), today.getMonth(), today.getDate());
		})
		
		$(document).on("click", "#next", function(){
			today.setDate( today.getDate() + 7 );
			week(today.getFullYear(), today.getMonth(), today.getDate());
		})
		
	})
</script>
<section>
	<div class="btn-group" role="group">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/day?mno=${login.mno }'" class="btn btn-secondary">일</button>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/week?mno=${login.mno }'" class="btn btn-secondary">주</button>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/month?mno=${login.mno }'" class="btn btn-secondary">월</button>
	</div>
	<div id="calendar">
		
	</div>
</section>
<%@ include file="../include/footer.jsp"%>