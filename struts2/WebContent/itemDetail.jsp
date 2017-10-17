<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ItemDetail</title>
</head>
<body>
<h1>商品詳細</h1>
<s:form action="GoCartAction">
	<s:iterator value="itemInfoList">
		<s:hidden name="itemID" value="itemID"><s:property value="itemName"/></s:hidden>
		<p><s:text name="商品名:"/><s:hidden name="itemName"><s:property value="itemName"/></s:hidden></p>
		<p><s:text name="値段:"/><s:hidden name="price"><s:property value="price"/></s:hidden></p>
		<p><s:text name="在庫:"/><s:hidden name="stocks"><s:property value="stocks"/></s:hidden></p>
		<p><s:text name="画像:"/><s:property value="imaPath"/></p>
		<s:submit value="カートに入れる"/>
	</s:iterator>
</s:form>

</body>
</html>