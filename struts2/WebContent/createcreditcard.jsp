<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create creditcard</title>
</head>
<body>
<s:form action="CreateCreditCardAction">
	<s:textfield name="cardCategory"/>
	<s:textfield name="cardHolder"/>
	<s:textfield name="cardNumber"/>
	<s:textfield name="month"/>
	<s:textfield name="year"/>
	<s:textfield name="security"/>
	<s:submit value="クレジットカードを登録"/>
</s:form>
</body>
</html>