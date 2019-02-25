<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div>
		<form action="login" method="post">
			<label>아이뒤</label>
			<input type="text" id="id">
			<label>비밀번호</label>
			<input type="password" id="pw">
			<br>
			<a href="${pageContext.request.contextPath}/user/search">찾아보자</a>
			<input type="submit" value="로그인">
			<a href="${pageContext.request.contextPath}/user/register">회원가입하기</a>
		</form>
	</div>
<%@ include file="../include/footer.jsp"%>