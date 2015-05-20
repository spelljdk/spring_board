<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

	function board_UpdateMove(no,title,content){
		
		document.all.boardNo.value = no;
		document.all.boardTitle.value = title;
		document.all.boardContent.value = content;
		
		$("#boardVO").attr("method","POST");
		$("#boardVO").attr("action","./boardUpdateMove.jdk");
		$("#boardVO").submit();
	}
	
	function board_Delete(no,title,content){
		
		document.all.boardNo.value = no;
		document.all.boardTitle.value = title;
		document.all.boardContent.value = content;
		
		$("#boardVO").attr("method","POST");
		$("#boardVO").attr("action","./boardDelete.jdk");
		$("#boardVO").submit();
	}

	$(document).ready(function(){
		$("#btn_list").click(function(){
			$("#boardNo").attr("value","");
			$("#boardTitle").attr("value","");
			$("#boardContent").attr("value","");
			
			$("#boardVO").attr("method","GET");
			$("#boardVO").attr("action","./boardList.jdk");
			$("#boardVO").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="boardVO" name="boardVO">
	<input type="hidden" id="boardNo" name="boardNo" value="${boardvo.boardNo }"/>
	<input type="hidden" id="boardTitle" name="boardTitle" value="${boardvo.boardTitle }"/>
	<input type="hidden" id="boardContent" name="boardContent" value="${boardvo.boardContent }"/>
</form>
제목 : ${boardvo.boardTitle }<br/>
글쓴이 : ${boardvo.boardUserId }<br/>
조회수 : ${boardvo.boardCount }<br/>
내용 : ${boardvo.boardContent }<br/>
<input type="button" value="글목록" id="btn_list"/>

<c:if test="${sessionScope.userInfo.user_Id == boardvo.boardUserId}">
	<input type="button" value="글수정" id="btn_update" onclick="board_UpdateMove('${boardvo.boardNo }','${boardvo.boardTitle }','${boardvo.boardContent }')"/>
	<input type="button" value="글삭제" id="btn_delete" onclick="board_Delete('${boardvo.boardNo }','${boardvo.boardTitle }','${boardvo.boardContent }')"/>
</c:if>
</body>
</html>