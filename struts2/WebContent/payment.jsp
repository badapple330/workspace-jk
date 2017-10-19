<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>payment</title>
</head>
<body>

<!--
ここjavascriptで分岐できる？
あるいは、現金かクレジットカードにsubmitボタンを作成して、
このjspを再構成する？

<a href="createcreditcard.jsp">クレジットカードを登録する</a>
-->
<a href="<s:url action="GoCreditCardAction" />">TEST</a>
<s:form action="PaymentAction">
	<p>
		<!-- 現金を選択したらjavascriptでクレカ入力欄機能を停止させる。あるいはs:if test -->
		<select name="paySelect" required>
			<option value="">--</option>
			<option value="1">現金</option>
			<option value="2">クレジットカード</option>
		</select>
	</p>

	<p>
		<select name="cardCategory" required>
			<option value="visa">Visa</option>
			<option value="mastercard">MasterCard</option>
			<option value="americanexpress">American Express</option>
		</select>
	</p>
	クレジットカード名義：<input name="cardHolder" size="25" maxlength="40" value="" required />
	クレジットカード番号：<input name="cardNumber" size="25" maxlength="40" value="" required />
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
				<option value="12" >12</option>
				</select>
	<!-- jQueryで自動算出 -->
	期限年：<input name="year" size="25" maxlength="40" value="" required />
	セキュリティコード：<input name="security" size="25" maxlength="40" value="" required />
	<s:submit value="確認画面へ進む"/>
</s:form>





</body>
</html>