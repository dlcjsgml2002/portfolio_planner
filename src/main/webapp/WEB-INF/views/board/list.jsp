<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
</style>
<section>
	<div class="box-body">
		<select name="searchType">
			<option value="n">---</option>
			<option value="t" ${cri.searchType == 't' ? 'selected' : '' }>Title</option>
			<option value="c" ${cri.searchType == 'c' ? 'selected' : '' }>Content</option>
			<option value="w" ${cri.searchType == 'w' ? 'selected' : '' }>Writer</option>
			<option value="tc" ${cri.searchType == 'tc' ? 'selected' : '' }>Title or Content</option>
			<option value="cw" ${cri.searchType == 'cw' ? 'selected' : '' }>Content or Winter</option>
			<option value="tcw" ${cri.searchType == 'tcw' ? 'selected' : '' }>Title of Content or Writer</option>
		</select>
		<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">
		<button id="btnSearch">Search</button>
		<button id="btnNewBoard">New Board</button>
	</div>
	<div>
		<table class="table table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bno }</td>
						<td>
							<a href="${pageContext.request.contextPath }/board/read?bno=${board.bno }&page=${pageMaker.cri.page }">${board.title }</a>
							<%-- <strong>[${board.replycnt }]</strong> --%>
						</td>
						<td>${board.member.name }</td>
						<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd" />
						</td>
						<td><span class="badge bg-red">${board.viewcnt }</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="page" class="text-center">                
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li><a href="${pageContext.request.contextPath }/board/list?page=${pageMaker.startPage - 1 }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li ${pageMaker.cri.page == idx ? 'class="active"' : '' }>
						<a href="${pageContext.request.contextPath }/board/list?page=${idx }&searchType=${cri.searchType }&keyword=${cri.keyword }">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<li><a
						href="${pageContext.request.contextPath }/board/list?page=${pageMaker.endPage + 1 }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</section>
<script>
	$(function(){
		$("#btnSearch").click(function(){
			var searchType = $("select[name='searchType']").val();
			var keyword = $("#keywordInput").val();
			location.href = "${pageContext.request.contextPath}/board/list?searchType=" + searchType + "&keyword=" + keyword;
		})
		
		$("#btnNewBoard").click(function(){
			location.href = "${pageContext.request.contextPath}/board/register";
		})
	})
</script>
<%@ include file="../include/footer.jsp"%>