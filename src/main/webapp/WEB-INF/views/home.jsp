<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="include/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<style>
	#slider_form {
		margin: 10% auto;
		width: 80%;
	}
	
	.slider img {
		width: 100%;
		height: 400px;
	}
</style>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function() {
		$('.slider').bxSlider();
	
		$('#slider_form').bxSlider({
			captions: true,
			auto : true,
			autoControls : true,
			stopAutoOnClick : true,
			pager : true,
			slideWidth : 600,
			pause: 10000
		});
	});
</script>
<section>
	<div id="slider_form">
		<div>
			<img alt="" src="${pageContext.request.contextPath }/resources/images/test.jpg">
			<p>1</p>
		</div>
	    <div>
	    	<img alt="" src="${pageContext.request.contextPath }/resources/images/test.jpg">
			<p>2</p>
	    </div>
	    <div>
	    	<img alt="" src="${pageContext.request.contextPath }/resources/images/test.jpg">
			<p>3</p>
	    </div>
	</div>
</section>
<%@ include file="include/footer.jsp"%>