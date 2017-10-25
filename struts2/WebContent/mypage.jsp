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
    <title>マイページ</title>
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
            <p>Mypage</p>
        </div>
        <div>
<h2>マイページ</h2>
<!--
自分のアカウント情報の列挙　user情報の表示。select○
自分のアカウント情報の変更。textfieldにpropertyで入れ込む。update
 -->
<h3>ユーザー情報</h3>
<s:form action="MypageAction">
    <p>
    ユーザーID:
    <input type="text" name="userID" value="<s:property value="userID"/>" placeholder=<s:property value="userID"/>>
    </p>
    <p>
    パスワード：
    <input type="text" name=password value="<s:property value="password"/>"placeholder=<s:property value="password"/>>
    </p>
    <s:submit value="入力したユーザー情報に変更する"/>
</s:form>

<h3>クレジットカード情報</h3>
<p>クレジットカードを登録する場合は<a href="<s:url action="GoCreditCardAction" />">こちら</a></p>
<s:form action="UpdateCreditcardAction">
    <p>
        <input type="radio" name="cardCategory" value="visa" checked="checked">VISA
        <input type="radio" name="cardCategory" value="master">MASTER
        <input type="radio" name="cardCategory" value="american">AMERICAN
    </p>
    <p>
    クレジットカード名義：<input type="text" name="cardHolder" value="<s:property value="cardHolder"/>" placeholder=<s:property value="cardHolder"/>>
    <p>
    クレジットカード番号：<input type="text" name="cardNumber" value="<s:property value="cardNumber"/>" placeholder=<s:property value="cardNumber"/>>
    </p>
    <p>
    期限月：<select name="month" required>
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
    期限年：<select name="year" required>
                <option value="">--</option>
                <option value="2017" >2017</option>
                <option value="2018" >2018</option>
                <option value="2019" >2019</option>
                <option value="2020" >2020</option>
                <option value="2021" >2021</option>
            </select>
    </p>
    <p>
    セキュリティコード：<input type="text" name="security" value="<s:property value="security"/>" placeholder=<s:property value="security"/>>
    </p>
    <s:submit value="クレジットカード情報を更新"/>
</s:form>

<h2>購入履歴</h2>
<table>
    <s:iterator value="itemList">
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>値段</th>
            <th>数量</th>
            <th>小計</th>
        </tr>
        <tr>
            <td><s:property value="itemID"/></td>
            <td><s:property value="itemName"/></td>
            <td><s:property value="price"/></td>
            <td><s:property value="quantity"/></td>
            <td><s:property value="subtotal"/></td>
        </tr>
    </s:iterator>
</table>
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