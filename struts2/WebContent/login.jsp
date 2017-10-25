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
    <title>Login画面</title>
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
        /*****FOOTER*****/
footer{
    font-size: 80%; /*フォントサイズの指定*/
    width: 100%;    /*横幅の指定*/
    text-align: center; /*文字の中央寄せ*/
    padding-top: 10px;  /*文字上部の余白指定*/
    padding-bottom: 10px;   /*文字下部の余白指定*/
    background-color: #313131;  /*背景色の指定*/
    position: fixed;
    bottom: 0;
}
footer address{
    color: #fff;    /*文字色の指定*/
    letter-spacing: 5px;    /*文字と文字の間隔をあける*/
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
			<h3>ログイン</h3>
			<s:form action="LoginAction">
				<s:textfield name="userID" placeholder="userID"/>
				<s:password name ="password" placeholder="password"/>
				<s:submit value = "ログイン"/>
			</s:form>
			<br/>
			<div id="text-link">
				<p>新規ユーザー登録は<a href='<s:url action="GoMypageAction" />'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<footer>
	   <address>Copyright(C)2017 Junepi Koziumi,Allright Reserved.</address>
	</footer>
</body>
</html>