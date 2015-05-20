<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	$(document).ready(function(){
		$("#btn_reset").click(function(){
			$("#board_Title").attr("value","");
			$("#board_Content").attr("value","");
		});
		
		$("#btn_board").click(function(){
			if($("#board_Title").val() == ''){alert("글제목을 입력해주세요."); return;}
			if($("#board_Content").val() == ''){alert("글내용을 입력해주세요."); return;}
			
			$("#boardVO").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글작성</h1>
<form name="boardVO" id="boardVO" method="POST" action="./boardInsert.jdk">
	글제목 : <input type="text" name="boardTitle" id="boardTitle"/><br/>
	<span style="vertical-align:top">내용 : </span><textarea rows="10" cols="10" name="boardContent" id="boardContent"></textarea><br/>
	<input type="button" value="다시작성" id="btn_reset"/>&nbsp;<input type="button" value="글작성" id="btn_board"/>
</form>
</body>
</html>