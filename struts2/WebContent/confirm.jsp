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
    <title>注文確認画面</title>
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
            background-color: black;
            clear:both;
            position: fixed;
		    bottom: 0;
		    width: 100%;
		    height: 80px;
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
            <p>Confirm</p>
        </div>
        <div>
            <h3>注文確認画面</h3>

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
    <h3>合計金額:<s:property value="total"/></h3><br>
<s:if test="#session.paySelect == 1">
    <p>カード会社：<s:property value="cardCategory" /><s:hidden name="cardCategory" value="%{cardCategory}" />
    </p>
    <p>カード名義：
    <s:property value="cardHolder" /><s:hidden name="cardHolder" value="%{cardHolder}" />
    </p>
    <p>カード番号：
    <s:property value="cardNumber" /><s:hidden name="cardNumber" value="%{cardNumber}" />
    </p>
    <p>期限月：<s:property value="month" /><s:hidden name="month" value="%{month}" />
    期限年：<s:property value="year" /><s:hidden name="year" value="%{year}" /></p>
    <p>セキュリティコード：
    <s:property value="security" /><s:hidden name="security" value="%{security}" />
    </p>
</s:if>
<s:else>
    <p>口座振り込み先は *************<p>
</s:else>
<s:form action="ConfirmAction">
    <s:submit value="注文を完了する"/>
</s:form><br/>
            <div id="text-link">
  <!--          <p>支払い画面へ戻る<a href="<s:url action="GoPaymentAction" />">こちら</a></p> -->
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