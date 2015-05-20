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
			document.memberVO.user_Id.value="";
			document.memberVO.user_Pw.value="";
			$("#user_Email").attr("value","");
		});
		
		$("#btn_join").click(function(){
			if(document.memberVO.user_Id.value.length == 0){ alert("아이디를 입력해주세요"); document.memberVO.user_Id.focus(); return;}
			if(document.memberVO.user_Pw.value.length == 0){ alert("비밀번호를 입력해주세요"); document.memberVO.user_Pw.focus(); return;}
			if($("#user_Email").val() === ""){ alert("이메일를 입력해주세요"); $("#user_Email").focus(); return;}
			$("#memberVO").attr("action","./newMemberJoin.jdk");
			$("#memberVO").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="memberVO" id="memberVO" method="POST" action="./newMemberJoin.jdk">
	아이디 : <input type="text" id="user_Id" name="user_Id"/><br/>
	비밀번호 : <input type="password" id="user_Pw" name="user_Pw"/><br/>
	이메일 : <input type="text" id="user_Email" name="user_Email"/><br/>
	<input type="button" value="다시작성" id="btn_reset" name="btn_reset"/>&nbsp;<input type="button" value="회원가입" id="btn_join" name="btn_join"/>
</form>
</body>
</html>