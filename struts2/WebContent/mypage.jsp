<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mypage</title>
</head>
<body>
<h1>マイページ</h1>
<!--
自分のアカウント情報の列挙　user情報の表示。select○
自分のアカウント情報の変更。textfieldにpropertyで入れ込む。update
 -->
<h2>ユーザー情報</h2>
<s:form action="MypageAction">
	ユーザーID:
	<s:textfield name="userID"><s:property value="userID"></s:property></s:textfield>
	パスワード：
	<s:textfield name="password"><s:property value="password"></s:property></s:textfield>
	<s:submit value="入力したユーザー情報に変更する"/>
</s:form>

<h2>クレジットカード情報</h2>
<s:form action="UpdaetCreditcardAction">
	<p>
		<input type="checkbox" name="cardCategory" value="visa" checked="checked">VISA
		<input type="checkbox" name="cardCategory" value="master">MASTER
		<input type="checkbox" name="cardCategory" value="american">AMERICAN
	</p>
	クレジットカード名義：<s:textfield name="cardHolder" required><s:property value="cardHolder"/></s:textfield>
	クレジットカード番号：<s:textfield name="cardNumber" required><s:property value="cardNumber"/></s:textfield>
	期限月：	<select name="month" required>
				<option value="">--</option>
				<option value="1" >01</option>
				<option value="2" >02</option>
         		<option value="3" >03</option>
				<option value="4" >04</option>
				<option value="5" >05</option>
				<option value="6" >06</option>
				<option value="7" >07</option>
				<option value="8" >08</option>
				<option value="9" >09</option>
				<option value="10" >10</option>
				<option value="11" >11</option>
				<option value="12" >12</option></select>
	期限年：<s:textfield name="year"><s:property value="security"/></s:textfield>
	セキュリティコード：<s:textfield name="security"required><s:property value="security"/></s:textfield>
	<s:submit value="クレジットカード情報を更新"/>
</s:form>

<h2>購入履歴</h2>
<table border="1">
	<s:iterator value="itemList">
		<tr>
			<td>商品ID:<s:property value="itemID"/></td>
			<td>商品名:<s:property value="itemName"/></td>
			<td>値段:<s:property value="price"/></td>
			<td>数量:<s:property value="quantity"/></td>
			<td>小計:<s:property value="subtotal"/></td>
		</tr>
	</s:iterator>
</table>

</body>
</html>