<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支払い画面</title>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta charset="utf-8">
	<title>商品詳細画面</title>
	<style type="text/css">

		/* ========TAG LAYOUT======== */
		body {
		   margin:0;
		   padding:0;
		   line-height:1.6;
		   letter-spacing:1px;
		   font-family:Verdana, Helvetica, sans-serif;
		   font-size:12px;
		   color:#333;
		   background:#fff;
		}

		table {
			text-align:center;
			margin:0 auto;
		}

		/* ========ID LAYOUT======== */
		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
		}

		#header {
		   width: 100%;
		   height: 80px;
		   background-color: black;
		}

		#main {
		   width: 100%;
		   height: 500px;
		   text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}

		#text-link {
			display: inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<div id="header">
	 	<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Payment</p>
		</div>
		<div>
			<h3>支払情報入力</h3>
				<!--
ここjavascriptで分岐できる？
あるいは、現金かクレジットカードにsubmitボタンを作成して、
このjspを再構成する？

<a href="createcreditcard.jsp">クレジットカードを登録する</a>
-->
<s:form action="PaymentAction">
		<!-- 現金を選択したらjavascriptでクレカ入力欄機能を停止させる。あるいはs:if test -->
	<p>
		<select name="paySelect" required>
			<option value="">--</option>
			<option value="0">現金</option>
			<option value="1">クレジットカード</option>
		</select>
	</p>
	<p>
		<select name="cardCategory" required>
			<option value="visa">Visa</option>
			<option value="mastercard">MasterCard</option>
			<option value="americanexpress">American Express</option>
		</select>
	</p>
	<p>クレジットカード名義：<input name="cardHolder" size="25" maxlength="40" value="" required /></p>
	<p>クレジットカード番号：<input name="cardNumber" size="25" maxlength="40" value="" required /></p>
	<p>期限月：
		<select name="month" required>
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
	期限年：<input name="year" size="21" maxlength="30" value="" required /></p>
	<p>セキュリティコード：<input name="security" size="25" maxlength="40" value="" required /></p>
	<s:submit value="確認画面へ進む"/>
</s:form>
			<br/>
			<div id="text-link">
				<p>クレジットカードを登録する場合は<a href="<s:url action="GoCreditCardAction" />">こちら</a></p>
				<p>マイページへは<a href='<s:url action="GoCreateUserAction" />'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>