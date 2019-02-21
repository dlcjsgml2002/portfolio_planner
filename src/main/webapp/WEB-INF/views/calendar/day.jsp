<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	#cal {
		width: 60%;
		text-align: center;
	}
</style>
<section>
	<div>
		<a href="${pageContext.request.contextPath}/calendar/day">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/month">Month</a>
	</div>
	<div id="calendar">
		<fmt:formatDate value="${map.today }" pattern="yyyy-MM-dd"/>
		<ul>
			<li>리스트
				<ul>
					<li>리스트 안 내용
					</li>
				</ul>
			</li>
		</ul>
	</div>
	<div>
	<h1>일정명</h1>
	<p>카테고리</p>
		<select>
			<option>--부위--</option>
		</select>
		<select>
			<option>--운동 이름--</option>
		</select>
		<p></p>
		<input type="date" placeholder="시작일">
		<input type="date" placeholder="종료일">
	</div>
	<div>
		<h3>이름</h3>
		<p>바이시클</p>
		<h3>설명</h3>
		<p>바이시크은 부릉부릉</p>
		<h3>동영상</h3>
		<iframe width="560" height="315" src="https://www.youtube.com/embed/kgUndAxMqY8" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
		<a href="https://www.youtube.com/embed/kgUndAxMqY8">영상보기</a>
</section>	
<%@ include file="../include/footer.jsp"%>