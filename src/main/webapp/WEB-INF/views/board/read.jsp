<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	div.item {
		margin: 5px;
		width: 100px;
		float: left;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<section class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Home Page</h3>
				</div>
				<div class="box-body">
					<div class="form-group">
						<label>Title</label> <input type="text" name="title"
							class="form-control" placeholder="Enter Title"
							value="${board.title }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea rows="5" class="form-control" name="content"
							placeholder="Enter Content" readonly="readonly">${board.content }</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input type="text" name="writer"
							class="form-control" placeholder="Enter Writer"
							value="${board.member.name }" readonly="readonly">
					</div>
					<div class="form-group">
						<c:forEach var="file" items="${board.files }">
							<div class="item">
								<img alt="" src="displayFile?filename=${file }">
							</div>
						</c:forEach>
					</div>
				</div>
				<script>
					$(".item").each(function(i, obj){

						var img = new Image();
						
						img.onload = function() {
							$(obj).css("width", this.width);
						}
						
						img.src = $(obj).find("img").attr("src");
					})
					
				</script>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="btnList">Go List</button>
					<button type="submit" class="btn btn-primary" id="btnModify">Modify</button>
					<button type="submit" class="btn btn-primary" id="btnRemove">Remove</button>
				</div>

				<form id="f1" action="" method="post">
					<input type="hidden" name="bno" value="${board.bno}"> <input
						type="hidden" name="page" value="${cri.page}">
				</form>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label>Writer</label> <input type="text" class="form-control" value="${login.name }" placeholder="${login.name }" id="newReplyWriter" readonly>
						<label>Reply Text</label> <input type="text" class="form-control" placeholder="Reply Text" id="newReplyText">
				</div>
				<div class="box-footer">
					<button class="btn btn-primary" id="btnReplyAdd">ADD REPLY</button>
				</div>
			</div>
			<ul class="timeline">
				<li class="time-label" id="reliesDiv"><span class="bg-green">Replies List</span></li>
			</ul>
			<div class="text-center">
				<ul id="pagination" class="pagination pagination-sm no-margin">
				</ul>
			</div>
		</div>
	</div>

	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>
						<input type="text" id="replytext" class="form-control">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="btnReplyMod"
						data-rno="">Modify</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</section>
<script id="template1" type="text/x-handlebars-template">
{{#each.}}
<li class="replyLi" data-rno="{{rno}}">
<i class="fa fa-comments bg-blue"></i>
<div class="timeline-item">
	<span class="item">
		<i class="fa fa-clock-o"></i>{{tempdate regdate}}
	</span>
	<h3 class="timeline-header">
		<strong>{{rno}}</strong> - {{replyer}}
	</h3>
	<div class="timeline-body">
		{{replytext}}
	</div>
	<div class="timeline-footer">
		<a class="btn btn-primary btn-xs btnModify" data-toggle="modal" data-target="#modifyModal">
			Modify
		</a>
		<a class="btn btn-danger btn-xs btnDelete">Delete</a>
	</div>
</div>
</li>
{{/each}}
</script>
<script>
	$(function() {
		$("#btnList").click(function() {
			location.href = "${pageContext.request.contextPath}/sboard/list";
			$("#f1").attr("action", "list");
			$("#f1").attr("method", "get");
			$("#f1").submit();
		})

		$("#btnRemove").click(function() {
			// #f1(form)ë¥¼ submit ë³´ë
			$("#f1").attr("action", "remove");
			$("#f1").attr("method", "post");
			$("#f1").submit();
		})

		$("#btnModify").click(function() {
			$("#f1").attr("action", "modify");
			$("#f1").attr("method", "get");
			$("#f1").submit();
		})
	})
</script>
<script>
	Handlebars.registerHelper("tempdate", function(value) {
		var date = new Date(value);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();

		return year + "/" + month + "/" + day;
	});

	var bno = ${ boardVO.bno };
	function getPageList(page) {
		$.ajax({
			url : "${pageContext.request.contextPath}/replies/" + bno + "/" + page,
			type : "get",
			dataType : "json",
			success : function(json) {
				console.log(json);
				$(".replyLi").remove(); // 계속되는 추가를 막기위한 초기화

				var cnt = json.replycnt;
				console.log(cnt);
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json.list);
				$(".timeline").append(result);

				// pagination
				$("#pagination").empty();
				for (var i = json.pageMaker.startPage; i <= json.pageMaker.endPage; i++) {
					var liTag = $("<li>");
					var aTag = $("<a>").append(i).attr("href", "#");
					liTag.append(aTag);
					if (i == json.pageMaker.cri.page) {
						liTag.addClass("active");
					}
					$("#pagination").append(liTag);
				}
					}
				})
	}

	$(function() {
		getPageList(1);

		$("#btnReplyAdd").click(function() {
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			var jsonBody = {
				bno : bno,
				replyer : replyer,
				replytext : replytext
			};

			//@RequestBody, header, JSON.stringify
			$.ajax({
				url : "${pageContext.request.contextPath}/replies/",
				type : "post",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				data : JSON.stringify(jsonBody), //"{bno:bno, replyer:replyer, replytext:replytext}"
				dataType : "text",
				success : function(json) {
					console.log(json);
					if (json == "success") {
						alert("등록하였습니다.");
						getPageList(1);
						$("#newReplyWriter").val("");
						$("#newReplyText").val("");
					}
				}
			})
		})

		$(document).on("click", ".btnDelete", function() {
			var rno = $(this).parents(".replyLi").attr("data-rno");
			var jsonBody = {
				replytext : replytext
			};
			$.ajax({
				url : "${pageContext.request.contextPath}/replies/" + rno,
				type : "delete",
				dataType : "text",
				success : function(json) {
					console.log(json);

					if (json == "success") {
						alert(rno + "가 삭제되었습니다.");
					}
					getPageList(1);
				}
			})
		})

		$(document).on("click", ".pagination a", function(e) {
			e.preventDefault();
			var num = $(this).text();
			getPageList(num);
		})

		$("#btnModify").click(function() {
			var rno = $(this).parents(".replyLi").attr("data-rno");
			var replytext = $("#replytext").val();
			var jsonBody = {
				replytext : replytext
			};
			$.ajax({
				url : "${pageContext.request.contextPath}/replies/" + rno,
				type : "put",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT"
				},
				data : JSON.stringify(jsonBody),
				dataType : "text",
				success : function(json) {
					console.log(json);

					if (json == "success") {
						alert(rno + "가 수정되었습니다.");
					}
					$("#modDiv").hide();
					getPageList(1);
				}
			})
		})
	})
</script>
<%@ include file="../include/footer.jsp"%>