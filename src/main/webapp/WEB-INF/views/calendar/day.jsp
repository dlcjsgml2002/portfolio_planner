<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	section {
		margin: 10px auto;
		width: 80%;
		height: 760px;
	}
	
	#calendar_table tbody tr:first-child td {
		
	}
	
	#calendar_table tbody tr td {
		padding: 10px;
		border: 1px solid #ddd;
	}
	
	#calendar_menu {
		float: right;
	}
	
	#calendar_menu a {
		border: 1px solid black;
	}
	
	.plan_item_div {
		color: #424242;
		position: relative;
		display: block;
		padding: 10px 15px;
		margin-bottom: -1px;
		background-color: #fff;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<option value="{{eno}}">{{name}}</option>
	{{/each}}
</script>
<script id="template2" type="text/x-handlebars-template">
	{{#each.}}
		<tr>
			<td>
				<p>{{appDate}}</p>
				<p>{{exec}}</p>
				<p>{{plan.title}}</p>
				{{#plan.planList}}
					<p>{{exercise.name}}</p>
				{{/plan.planList}}
			</td>
		</tr>
	{{/each}}
</script>
<script>
	var today = null;
	
	function day(y, m, d) {
		today = new Date(y, m, d);
		var cale = "<th><a href='#' id='prev'>&lt;</a>" + y + "년 " + (m + 1) + "월" + d + "일<a href='#' id='next'>&gt;</a></th>";
		
		$("#cale").html(cale);
	}
	
	function getExerciseList() {
		var part = $("#part").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/dayajax",
			type : "get",
			data : {"part": part},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				$("#exercise").empty();
				
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				
				$("#exercise").append(result);
				}
			})
		}
	
	function getPlanList() {
		var time = today.getFullYear()  + "-" + (today.getMonth() + 1) + "-" + today.getDate();
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/dateajax",
			type : "get",
			data : {
				"mno" : ${login.mno},
				"time": time
				},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				$("#cal_tbody").empty();
				
				var source = $("#template2").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				
				$("#cal_tbody").append(result);
				}
			})
		}
	                   
	function add_plan() {
		$("#list").modal("show");
	}
	
	function insert_plan() {
		$("#t").val(today);
		$("#insert").modal("show");
	}

	function get_plan_info(pno) {
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/day",
			type : "get",
			data : {"pno": pno},
			success : function(json) {
				console.log(json);
				}
			})
		}
	
	$(function(){
		var date = new Date(${map.today.time});
		day(date.getFullYear(), date.getMonth(), date.getDate() );
		
		$(document).on("click", "#prev", function(){
			today.setDate( today.getDate() - 1 );
			day(today.getFullYear(), today.getMonth(), today.getDate() );
			getPlanList();
		})
		
		$(document).on("click", "#next", function(){
			today.setDate( today.getDate() + 1 );
			day(today.getFullYear(), today.getMonth(), today.getDate() );
			getPlanList();
		})
		
		getExerciseList();
		getPlanList();
		
		$("#part").on("change", function(){
			getExerciseList();
		})
	})
	
</script>
<section>
	<div id="calendar_menu">
		<a href="${pageContext.request.contextPath}/calendar/day?mno=${login.mno }">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week?mno=${login.mno }">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/month?mno=${login.mno }">Month</a>
	</div>
	
	<table class="table" id="calendar_table">
		<colgroup>
			<col width="25%">
			<col width="5%">
		</colgroup>
	
		<thead>
			<tr id="cale">
				
			</tr>
			
			<tr>
				<th style="text-align: center; font-size: 25px"><fmt:formatDate value="${map.today }" pattern="yyyy-MM-dd"/></th>
				<th><button class="btn btn-primary" onclick="insert_plan()">계획 추가하기</button></th>
				<th><button class="btn btn-primary" onclick="add_plan()">계획 불러오기</button></th>
			</tr>
		</thead>
		<tbody id="cal_tbody">
			<%-- <c:forEach var="plan" items="${map.plan }">
				<tr>
					<td>
						<a href="javascript:void(0)" onclick="get_plan_info(${plan.pno })">${plan.title }</a>
					</td>
				</tr>
				<tr>
					<td>
						<c:forEach var="planList" items="${plan.planList }">
							<p><a href="${planList.exercise.link }">${planList.exercise.name }</a>${planList.setcnt }개 ${planList.exec }</p>
						</c:forEach>
					</td>
				</tr>
			</c:forEach> --%>
		</tbody>
	</table>	
</section>                         
<%@ include file="../calendar/modal/list.jsp"%>
<%@ include file="../calendar/modal/insert.jsp"%>
<%@ include file="../calendar/modal/update.jsp"%>
<%@ include file="../include/footer.jsp"%>