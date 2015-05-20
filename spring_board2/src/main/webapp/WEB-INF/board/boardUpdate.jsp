<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function board_Update(no,title,content){
		
		document.all.boardNo.value = no;
		
		if($("#boardTitle").val() == ""){alert("제목을 입력해주세요");return;}
		if($("#boardContent").val() == ""){alert("내용을 입력해주세요");return;}
		$("#boardVO").attr("action","./boardUpdate.jdk");
		$("#boardVO").submit();
	}

	$(document).ready(function(){
		$("#btn_reset").click(function(){
			$("#boardTitle").attr("value","");
			$("#boardContent").attr("value","");
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="boardVO" name="boardVO" method="POST">
	<input type="hidden" id="boardNo" name="boardNo" value="${boardVO.boardNo}"/>
	제목 : <input type="text" id="boardTitle" name="boardTitle" value="${boardVO.boardTitle}"/><br/>
	내용 : <input type="text" id="boardContent" name="boardContent" value="${boardVO.boardContent }"/><br/>
	<input type="button" value="다시작성" id="btn_reset"/>&nbsp;<input type="button" value="수정" id="btn_update" onclick="board_Update('${boardVO.boardNo}','${boardVO.boardTitle}','${boardVO.boardContent}')"/>
</form>
</body>
</html>