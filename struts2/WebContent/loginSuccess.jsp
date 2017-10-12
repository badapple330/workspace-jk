<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta charset=utf-8”> -->
<title>トップページ</title>
</head>
<body>
<h1>トップページ</h1>
<s:iterator value = "itemList">
	<a href="<s:url action="GoItemDetailAction"><s:param name="itemID" value="itemID"/></s:url>">test</a>
</s:iterator>
</body>
</html>