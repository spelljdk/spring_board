<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript">
$(document).ready(function() {
	//Click login
	$("#login").click(function(){
		var user_Id = $("#user_Id").val();
		var user_Pw = $("#user_Pw").val();
		
		if(user_Id == "") {alert("아이디를 입력해주세요.");return;}
		if(user_Pw === "") {alert("암호를 입력해주세요.");return;}
		
		else{
			$("#memberVO").attr("action","./login.jdk");
			$("#memberVO").submit();
		}
		
	});
	
	//move NewMember
	$("#newMember").click(function(){
		$("#memberVO").attr("method","GET");
		$("#memberVO").attr("action","./newMemberJoinMove.jdk");
		$("#memberVO").submit();
	});
	
	//move NewMember
	$("#memFind").click(function(){
		$("#memberVO").attr("method","GET");
		$("#memberVO").attr("action","./memberFindMove.jdk");
		$("#memberVO").submit();
	});
});
	
</script>
<title>Insert title here</title>
</head>
<body>
<form name="memberVO" id="memberVO" method="post">
	<table>
		<tbody>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_Id" id="user_Id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_Pw" id="user_Pw"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="로그인" name="login" id="login"/>&nbsp;<input type="button" value="회원찾기" name="memFind" id="memFind"/>&nbsp;<input type="button" value="회원가입" name="newMember" id="newMember"/></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>