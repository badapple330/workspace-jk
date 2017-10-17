<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
</head>
<body>
<s:form action="CreateUserAction">
	<s:textfield name="userID"/>
	<s:textfield name="password"/>
	<s:submit value="アカウントを作成"/>
</s:form>
</body>
</html>