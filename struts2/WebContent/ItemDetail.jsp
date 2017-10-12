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

<s:hidden name="itemID" value="itemID"/>
<s:hidden name="itemName" value="itemName"/>
<s:hidden name="stocks" value="stocks"/>
<s:hidden name="imgPath" value="imgPath"/>
<p><s:text name="商品名:"/><s:property value="itemName"/></p>
<p><s:text name="値段:"/><s:property value="price"/></p>
<p><s:text name="在庫:"/><s:property value="stocks"/></p>
<p><s:text name="画像:"/><s:property value="imaPath"/></p>
<s:submit value="カートに入れる" action="GoCartAction"/>


</body>
</html>