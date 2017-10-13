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
 -->

<s:form action="PaymentAction">
	<p>
		<input type="checkbox" name="paySelect" value="1" checked="checked">クレジットカード
		<input type="checkbox" name="paySelect" value="2">現金
		<!-- 現金を選択したらjavascriptでクレカ入力欄機能を停止させる -->
	</p>
		<p>
		<input type="checkbox" name="cardCategory" value="visa" checked="checked">VISA
		<input type="checkbox" name="cardCategory" value="master">MASTER
		<input type="checkbox" name="cardCategory" value="american">AMERICAN
	</p>
	クレジットカード名義：<s:textfield name="cardHolder"required/>
	クレジットカード番号：<s:textfield name="cardNumber"required/>
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
	期限年：<s:textfield name="year"required/>
	セキュリティコード：<s:textfield name="security"required/>

	<s:submit value="決定"/>
</s:form>




</body>
</html>