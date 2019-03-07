<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.modal-dialog {
	    max-width: 1400px;
	    margin: 1.75rem auto;
	}
	
	.modal-body{
		min-height: 500px;
	}
</style>
<script>
	
</script>
<div id="list" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">${login.name }님의 계획 목록</h4>
				<button type="button" class="btn btn-primary" onclick="insert_plan()">플랜 추가</button>
			</div>
			<div class="modal-body">
				<c:forEach var="list" items="${map.plan }">
					<a>${list.title }</a><a style="font-size: 2em;" class="insert_button">[+]</a><br>
				</c:forEach>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		</div>
	</div>
</div>