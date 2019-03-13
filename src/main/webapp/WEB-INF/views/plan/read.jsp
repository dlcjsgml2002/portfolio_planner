<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<section>
	${plan }
	<c:forEach var="planList" items="${plan.planList }">
		<p> ${planList.exercise.name } ${planList.setcnt } ${planList.execnt }</p>
	</c:forEach>
</section>
<%@ include file="../include/footer.jsp"%>