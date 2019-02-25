<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="include/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
	#banner {
		width: 800px;
		height: 400px;
	}
</style>
<script>
	$(document).ready(function() {
		$('.slider').bxSlider();
	});
</script>
<section>
	<div id="banner">
		<div class="slider">
			<div>I am a slide.</div>
		    <div>I am another slide.</div>
		    <div>I am another another slide.</div>
		</div>
	</div>
</section>
<%@ include file="include/footer.jsp"%>