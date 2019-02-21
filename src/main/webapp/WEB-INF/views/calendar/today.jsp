<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<style>
		#cal {
			width: 60%;
			text-align: center;
		}
	</style>
	<div id="cal">
		${map.today }<br>
		호우호우
		<h1>일정명</h1>
		<p>일정 기간(시작일 ~ 종료일)</p>
		<p>일정 내용</p>
		<a>일정 추가</a>
		<a>일정 수정</a>
		<a>일정 삭제</a>
	</div>
<%@ include file="../include/footer.jsp"%>