<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th><s:text name="商品名"/></th>
		<th><s:text name="値段"/></th>
		<th><s:text name="個数"/></th>
		<th><s:text name="個別合計"/></th>
	</tr>

	<s:iterator value="cartInfoList">
	<tr>
		<td><s:property value="itemName" /></td>
        <td><s:property value="price" /></td>
        <td><s:property value="quantity"/></td>
      	<td><s:property value="subtotal" /></td>
	</tr>
	</s:iterator>
</table>
	合計金額:<s:property value="total"/>

<table border="1">
<!-- クレジットカードの場合のみ出力。現金の場合はjavascriptでここを隠す -->
<!--
<s:if test=""/>を使u。session.containskey("paySelect"==1)がクレジットカードなら。
 -->
	<tr>
		<td>支払い方法：<s:property value="paySelect" /></td>
		<td>カード会社：<s:property value="cardCategory" /></td>
        <td>カード名義：<s:property value="cardHolder" /></td>
        <td>カード番号：<s:property value="cardNumber"/></td>
      	<td>期限月：<s:property value="month" /></td>
      	<td>期限年：<s:property value="year" /></td>
        <td>セキュリティコード：<s:property value="security" /></td>
	</tr>
</table>

<s:form action="ConfirmAction">
	<s:submit value="注文を完了する"/>
</s:form>

</body>
</html>