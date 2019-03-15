<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="include/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<style>
	section {
		padding-left: 15%;
	}
	#slider_form {
		margin: 10% auto;
		width: 80%;
	}
	
	#slider_form img {
		width: 100%;
		height: 100%;
	}
</style>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function() {
		$('.slider').bxSlider();
	
		$('#slider_form').bxSlider({
			captions: true,
			auto : true,
			slideWidth : 800,
			pause: 5000
		});
	});
</script>
<section>
	<div id="slider_form">
		<div>
			<img alt="" src="${pageContext.request.contextPath }/resources/images/1.jpg">
		</div>
	    <div>
	    	<img alt="" src="${pageContext.request.contextPath }/resources/images/2.jpg">
	    </div>
	    <div>
	    	<img alt="" src="${pageContext.request.contextPath }/resources/images/3.jpg">
	    </div>
	</div>
</section>
<%@ include file="include/footer.jsp"%>