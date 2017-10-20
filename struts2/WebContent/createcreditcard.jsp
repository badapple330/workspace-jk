<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
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
			<p>Register Creditcard</p>
		</div>
		<div>
			<h3>クレジットカード情報登録</h3>
				<!--
ここjavascriptで分岐できる？
あるいは、現金かクレジットカードにsubmitボタンを作成して、
このjspを再構成する？

<a href="createcreditcard.jsp">クレジットカードを登録する</a>
-->
<s:form action="CheckCreditcardAction">

	<select name="cardCategory" required>
		<option value="visa">Visa</option>
		<option value="mastercard">MasterCard</option>
		<option value="americanexpress">American Express</option>
	</select>
	<p>	<input type="text" name="cardHolder" placeholder="カード名義" required>
	</p>
	<p>	<input type="text" name="cardNumber" placeholder="カード番号" required>
	</p>
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
	期限年：
		<select name="year" required>
			<option value="">--</option>
			<option value="2017" >2017</option>
			<option value="2018" >2018</option>
			<option value="2019" >2019</option>
			<option value="2020" >2020</option>
			<option value="2021" >2021</option>
		</select>
	</p>
	<p>	<input type="text" name="security" placeholder="セキュリティコード" required>
	</p>

	<s:submit value="クレジットカード情報確認画面へ"/>
</s:form>
			<br/>
			<div id="text-link">
				<p>支払い画面へ戻る<a href="<s:url action="GoPaymentAction" />">こちら</a></p>
				<p>マイページへは<a href='<s:url action="GoMypageAction" />'>こちら</a></p>
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