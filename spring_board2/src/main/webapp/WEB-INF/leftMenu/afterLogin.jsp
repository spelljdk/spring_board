<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	$(document).ready(function(){
		$("#logout").click(function(){
			$("#memberVO").submit();
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${sessionScope.userInfo.user_Id}�� �ȳ��ϼ���
<form id="memberVO" name="memberVO" method="post" action="./logout.jdk">
	<input type="button" value="�α׾ƿ�" id="logout" name="logout"/>
</form>
</body>
</html>