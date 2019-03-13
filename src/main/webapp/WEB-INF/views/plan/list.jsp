<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<section>
	<button onclick="location.href='${pageContext.request.contextPath}/plan/insert'">플랜 추가</button>
	<form action="list" method="get">
		<c:forEach var="plan" items="${plan }">
			<p>
				${plan.pno } and ${plan.title }
				<a href="${pageContext.request.contextPath}/plan/read?pno=${plan.pno }">플랜 수정</a>
				<button>플랜 삭제</button>
			</p>
		</c:forEach>
	</form>
</section>
<%@ include file="../include/footer.jsp"%>