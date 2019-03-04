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
<div id="insert" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">플랜 수정하기</h4>
					<button type="button" class="btn btn-primary" >운동추가</button>
			</div>
			<div class="modal-body">
				<p>카테고리</p>
				<select id="part">
					<c:forEach var="list" items="${map.list }">
						<option value="${list }">${list }</option>
					</c:forEach>
				</select>
				<select id="exercise">
					
				</select>
				<button>수정하기</button>
				<input type="date" placeholder="시작일">
				<input type="date" placeholder="종료일">
			</div>
			<div id="choose">
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		</div>
	</div>
</div>