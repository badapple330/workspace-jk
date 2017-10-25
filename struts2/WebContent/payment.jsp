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
				<table border="0" cellspacing="0" cellpadding="0">
					  <h4>お支払い方法</h4>
					 <tr>
						<td>
							<label><input type="radio" name="paySelect" value="0" onclick="formChange1();" required/>口座引き落とし</label>
							<label><input type="radio" name="paySelect" value="1" onclick="formChange1();" required/>クレジットカード</label>
					   </td>
					</tr>
					<tr>
					   <td>
		                    <form name="PaymentAction" id="PaymentAction" action="/struts2/PaymentAction.action" method="post">
		                    <div id="firstBox">
		                    <h4>口座引き落とし</h4>
							 <input type="text" value="" placeholder="口座番号を入力"/>     <!-- ←ここinsert -->
							 <input type="text" value="" placeholder="名義"/>
							 <p>
							 <input type ="hidden" name="paySelect" value="0"/>
							 <input type="submit" value="確認画面へ進む"/>
							 </p>
							</div>
							</form>
						</td>
					</tr>
					<!--
					<tr>
    				   <th>クレジットカード入力</th>
    				 </tr>
    				  -->
    				 <tr>
					   <td>
					   <form name="PaymentAction" id="PaymentAction" action="/struts2/PaymentAction.action" method="post">
					   <div id="secondBox">
					   <h4>クレジットカード入力</h4>
					       <!--
							    <p>
							        <select name="paySelect" required>
							            <option value="">--</option>
							            <option value="0">口座振込</option>
							            <p><option value="1">クレジットカード</option></p>
							        </select>
							    </p>
						    -->
							    <p>
							        <select name="cardCategory" required>
							            <option value="visa">Visa</option>
							            <option value="mastercard">MasterCard</option>
							            <option value="americanexpress">American Express</option>
							        </select>
							    </p>
							    <p>クレジットカード名義：<input name="cardHolder" size="25" maxlength="40" value="" required /></p>
							    <p>クレジットカード番号：<input type="text" name="cardNumber" size="25" maxlength="40" value="" required onKeyup="this.value=this.value.replace(/[^0-9]+/,'')" placeholder="半角数値を入力"/></p>
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
							    <!-- <input name="year" size="21" maxlength="30" value="" required /></p>  -->
							    <p>セキュリティコード：<input type="text" name="security" size="25" maxlength="40" value="" required onKeyup="this.value=this.value.replace(/[^0-9]+/,'')" placeholder="半角数値を入力"/></p>
							    <input type ="hidden" name="paySelect" value="1"/>
							    <input type="submit" value="確認画面へ進む"/>
						  </div>
                        </form>
					</td>
				</tr>
               </table>

			<script type="text/javascript">
			function formChange1(){
			radio = document.getElementsByName('paySelect')
			if(radio[0].checked) {
			document.getElementById('firstBox').style.display = "";
			document.getElementById('secondBox').style.display = "none";
			}else if(radio[1].checked) {
			document.getElementById('firstBox').style.display = "none";
			document.getElementById('secondBox').style.display = "";
			}
			}



			//オンロードさせ、リロード時に選択を保持
			window.onload = formChange1;
			</script>
			<br/>
			<div id="text-link">
				<p>クレジットカードを登録する場合は<a href="<s:url action="GoCreditCardAction" />">こちら</a></p>
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