<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function boardView(boardNo){
		
		document.all.boardNo.value= boardNo;
		$("#boardVO").attr("action","./boardView.jdk");
		$("#boardVO").submit();
	}
	
	function paging_click(su){
		document.all.boardCount.value = su;
		$("#boardVO").attr("action","./boardList.jdk");
		$("#boardVO").submit();
	}
	
	$(document).ready(function(){
		$("#btn_search").click(function(){
			if($("#searchContent").val() == ''){ alert("검색내용을 입력해주세요."); return;}
			$("#boardVO").attr("method","POST");
			$("#boardVO").attr("action","./boardList.jdk");
			$("#boardVO").submit();
		});
		
		$("#btn_Insert").click(function(){
			$("#form").attr("method","GET");
			$("#form").attr("action","./boardInsertMove.jdk");
			$("#form").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form" method="get"></form>
<form id="boardVO" method="post">
<input type="hidden" name="boardNo" id="boardNo"/>
<input type="hidden" name="boardCount" id="boardCount"/>
<table>
	<tbody>
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>글쓴이</td>
			<td>조회수</td>
			<td>글쓴일</td>
		</tr>
		<c:forEach var="list" items="${boardList }" >
			<tr>
				<td>${list.boardNo }</td>
				<td><a id="boardTitle" onclick="boardView('${list.boardNo}')">${list.boardTitle }</a></td>
				<td>${list.boardUserId }</td>
				<td>${list.boardCount }</td>
				<td>${list.boardTime }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<select id="searchMode" name="searchMode">
				<option value="0">--선택--</option>
				<option value="1">제목만</option>
				<option value="2">내용망</option>
				<option value="3">제목+내용</option>
			</select>
			<input type="text" name="searchContent" id="searchContent"/>&nbsp;<input type="button" value="검색" name="btn_search" id="btn_search"/>&nbsp;<input type="button" value="글작성" name="btn_Insert" id="btn_Insert"/></td>
		</tr>
		
		<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
				<c:if test="${totalPageCount >= 1 }">
					<c:forEach var="su" begin="1" end="${totalPageCount}" step="1">
						<c:choose>
							<c:when test="${su == boardCount}"><b style="cursor:pointer;color:blue" onclick="paging_click('${su}')">${su}</b></c:when>
							<c:otherwise><span style="cursor:pointer;color:blue;" onclick="paging_click('${su}')">${su}</span></c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>