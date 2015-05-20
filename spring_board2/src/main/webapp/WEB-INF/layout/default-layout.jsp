<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<style type="text/css">
	html,body {
	margin: 0;
	padding: 0;
}
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<table style="table-layout:fixed;height:100%;padding:-10px;margin:0px" width="100%"> 
<tr style="height:100%;table-layout:fixed">
	<td width="250" style="border-right:1px #000 solid;vertical-align:top;padding-top:100px"><tiles:insertAttribute  name="menu" /></td> 
	<td><tiles:insertAttribute name="body" /></td>
</tr>
</table>

</body>
</html>