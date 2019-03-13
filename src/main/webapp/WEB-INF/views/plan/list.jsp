<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<p>{{title}}</p>
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
		plan_list();
	})
</script>
<section>
	<button onclick="location.href='${pageContext.request.contextPath}/plan/insert'">플랜 추가</button>
	<form action="list" method="get">
		<c:forEach var="plan" items="${plan }">
			<p>
				${plan.pno } and ${plan.title }
				<a href="${pageContext.request.contextPath}/plan/read?pno=${plan.pno }">플랜 수정</a>
				<button onclick="remove_ajax(${plan.pno })">플랜 삭제</button>
			</p>
		</c:forEach>
		<div id="test">
		</div>
	</form>
</section>
<%@ include file="../include/footer.jsp"%>