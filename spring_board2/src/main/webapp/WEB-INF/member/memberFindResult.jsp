<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" id="form" action="./"/>
<c:choose>

<c:when test="${findResult.user_Id !='' && findResult.user_Id ne null}">회원님의 정보를 알려드립니다.<br/>
아이디 : ${findResult.user_Id }<br/>
비밀번호 : ${findResult.user_Pw }<br/></c:when>

<c:when test="${findResult.user_Id == '' || findResult.user_Id eq null }">존재하는 아이디가 없습니다.<br/></c:when>
</c:choose>
<input type="button" value="되돌아가기" onclick="history.go(-1)"/>&nbsp;<input type="button" value="로그인화면" onclick="document.form.submit();"/>
</body>
</html>