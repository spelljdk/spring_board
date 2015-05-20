<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	$(document).ready(function(){
		//다시작성
		$("#btn_reset").click(function(){
			$("#user_Email").attr("value","");
		});
		
		$("#btn_find").click(function(){
			if($("#user_Email").val() === ""){ alert("이메일를 입력해주세요"); $("#user_Email").focus(); return;}
			//document.memberVO.action = "$("#memberVO").attr("action","./memberFind.jdk");
			$("#memberVO").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="memberVO" id="memberVO" method="post" action="./memberFind.jdk">
	이메일 : <input type="text" id="user_Email" name="user_Email" value="iirw135@naver.com"/><br/>
	<input type="button" value="다시작성" id="btn_reset" name="btn_reset"/>&nbsp;<input type="button" value="회원찾기" id="btn_find" name="btn_find"/>
</form>
</body>
</html>