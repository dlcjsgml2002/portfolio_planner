<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../include/header.jsp"%>
<section class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Register Board</h3>
				</div>
				<form role="form" method="post" action="modify" enctype="multipart/form-data">
					<div class="box-body">
						<div class="form-group">
							<label>Title</label> <input type="text" name="title"
								class="form-control" placeholder="Enter Title"
								value="${board.title }">
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea rows="5" class="form-control" name="content"
								placeholder="Enter Content">${board.content }</textarea>
						</div>
						<div class="form-group">
							<label>Writer</label> <input type="text" name="writer"
								class="form-control" placeholder="Enter Writer"
								value="${login.name }" readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>Image File</label>
							<input type="file" name="addfiles" class="form-control" multiple="multiple">
						</div>
					                           
						<div class="form-group">
							<c:forEach var="file" items="${board.files }">
								<div class="item">
									<img alt="" src="displayFile?filename=${file }"> <span>${fn:substring(file,51,-1)}</span>
									<button type="button" class="btnDel" data-src="${file }">X</button>
								</div>
							</c:forEach>
						</div>
						
						<div id="delFileWrap"></div>
					</div>

					<script>
						$(".item").each(function(i, obj){
	
							var img = new Image();
							
							img.onload = function() {
								$(obj).css("width", this.width);
							}
							
							img.src = $(obj).find("img").attr("src");
						})
					                        
						$(".btnDel").click(function(){
							var filename = $(this).attr("data-src");
							var $input = $("<input>").attr("type", "hidden").attr("name", "delFiles").val(filename);
							$("#delFileWrap").append($input);
							$(this).parent().remove();
						})
				</script>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">submit</button>
						<button type="reset" class="btn btn-primary">Cancel</button>
					</div>

					<input type="hidden" name="bno" value="${board.bno }"> <input
						type="hidden" name="page" value="${cri.page }">
				</form>

			</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>