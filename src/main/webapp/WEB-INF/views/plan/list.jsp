<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	table {
		margin: 0 auto;
		width: 1000px;
	}

	thead {
		text-align: right;
	}
	
	button {
		width: 130px;
	}
</style>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<tr>
			<td style="width: 60%">{{title}}</td>
			<td style="width: 20%"><button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/plan/read?pno={{pno }}'">플랜 수정</button></td>
			<td style="width: 20%"><button class="btn btn-danger" onclick="remove_ajax({{pno }})">플랜 삭제</button></td>
		<tr>
	{{/each}}
</script>
<script>
	function plan_list() {
		$.ajax({
			url : "${pageContext.request.contextPath}/plan/plan_list",
			type : "get",
			data : {"mno": ${login.mno}},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				$("#test").empty();
				
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				
				$("#test").append(result);
				}
			})
		}

	function remove_ajax(pno){
		$.ajax({
			url : "${pageContext.request.contextPath}/plan/remove_ajax",
			type : "get",
			data : {"pno": pno},
			dataType : "json",
			success : function(json) {
				console.log(json);
				}
			})
		}
	
	$(function(){
		$("button").on("click", function(){
			plan_list();
		})
		
		plan_list();
	})
</script>
<section>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<td colspan="3"><button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/plan/insert'">플랜 추가</button></td>
			</tr>
		</thead>
		<tbody id="test">
		</tbody>
	
	</table>
</section>
<%@ include file="../include/footer.jsp"%>