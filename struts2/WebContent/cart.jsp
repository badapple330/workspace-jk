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
			<p>Login</p>
		</div>
		<div>
<s:form action = "CartDeleteAction">
<table border="1">
<!-- td=データ th=見出し -->
	<tr>
		<th><s:text name="商品名"/></th>
		<th><s:text name="値段"/></th>
		<th><s:text name="個数"/></th>
		<th><s:text name="個別合計"/></th>
		<th><s:text name="削除チェック"/></th>
	</tr>


<s:hidden name="userID" value="%{userID}"/>
<s:iterator value="cartInfoList" status="st">
	<s:hidden name="itemID" value="%{itemID}"/>
	<tr>
		<td><s:property value="itemName" /></td>
		<td><s:property value="price" /></td>
		<td><input type="number" name="quantity" value=<s:property value="quantity"></s:property> min="0" max="100" size="3" ></td>
		<td><s:property value="subtotal" /></td>
		<td><!--  value="check"が入ってたid ="%{#st.index}" value="%{#st.index}" -->
			<input type="checkbox" name="checkList" value="<s:property value='itemID' />"/>
		</td>
		<td><input type="submit" formaction="CartUpdateAction" value="個数を更新"></td>
	</tr>
</s:iterator>
<!--
<s:iterator value="cartInfoList" status="st">
		<s:hidden name="itemName" value="%{itemName}" />
		<s:hidden name="price" value="price" />
		<s:hidden name="itemID" value="itemID" />
		<s:hidden name="subtotal" value="subtotal" />
		<s:hidden name="cartInfoList%{#st.index}" value="%{cartInfoList[#st.index]}"/>
</s:iterator> -->
<s:submit value="チェックした商品を削除"/>
</table>
</s:form>
<h4>合計金額：<s:property value="amountAll"/>円</h4>

<s:form action="GoPaymentAction">
	<s:submit value="支払い方法選択へ"/>
</s:form>
			<br/>
			<div id="text-link">
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