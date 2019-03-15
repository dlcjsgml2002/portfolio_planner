<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.modal-dialog {
	    max-width: 1200px;
	    margin: 1.75rem auto;
	}
	
	.modal-body{
		min-height: 500px;
	}
	
	.modal-header button {
		float: right;
	}
	
	.title {
		display: inline-block;
		width: 300px;
	}
</style>
<script>
	function update_plan(pno) {
		$("#update").modal("show");
	}
	
	$(function() {
		$(".btn_plan_insert").on("click", function() {
			var date = today.getFullYear()  + "-" + (today.getMonth() + 1) + "-" + today.getDate();
			$.ajax({
				url : "${pageContext.request.contextPath}/calendar/testajax",
				type : "post",
				data : {
					"pno": $(this).val(),
					"date": date
					},
				dataType : "json",
				success : function(json) {
					console.log(json);
					
					getPlanList();
					}
				})
			})
		$(".btn_plan_update").on("click", function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/calendar/update_ajax",
				type : "get",
				data : {
					"pno": $(this).val(),
					},
				dataType : "json",
				success : function(json) {
					console.log(json);
					}
				})
			})
		$(".btn_plan_delete").on("click", function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/calendar/delete_ajax",
				type : "get",
				data : {
					"pno": $(this).val(),
					},
				dataType : "json",
				success : function(json) {
					console.log(json);
					}
				})
			})   
	})
</script>
<div id="list" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">${login.name }님의 계획 목록</h4>
				<button type="button" class="btn btn-primary btn btn-primary" onclick="insert_plan()">플랜 등록</button>
				<button type="button" class="btn btn-primary btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/plan/list'">플랜 관리</button>
			</div>
			<div class="modal-body">
				<c:forEach var="list" items="${map.plan }">
					<p>
						<a class="title">${list.title }</a>
						<button class="btn_plan_insert btn btn-success" value="${list.pno }">추가하기</button>
					</p>
				</c:forEach>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		</div>
	</div>
</div>