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
    <title>支払い方法選択画面</title>
    <style type="text/css">

        /* ========TAG LAYOUT======== */
        body {
           margin:0;
           padding:0;
           line-height:1.6;
           letter-spacing:1px;
           font: 14px/1.6 "Hiragino Kaku Gothic Pro",Osaka,"メイリオ","ＭＳ Ｐゴシック","MS PGothic",Verdana,Arial,sans-serif;
           font-size:12px;
           color:#313131;
           background:#fff;
        }

        table {
            text-align:center;
            margin:0 auto;
        }

        /* ========ID LAYOUT======== */
        #top {
           width: 90%;
           margin:30px auto;
           border:1px solid #333;
           margin-top: 10px;
        }

        /*****HEADER*****/
        header{
            display: block;
            overflow: hidden;
            font-size: 80%; /*フォントサイズの指定*/
            width: 100%;    /*横幅の指定*/
            text-align: center; /*文字の中央寄せ*/
            font-size: 15px;
            height: 20px;
            padding-top: 10px;  /*文字上部の余白指定*/
            padding-bottom: 10px;   /*文字下部の余白指定*/
            background-color: #313131;  /*背景色の指定*/
            position: fixed;
            top: 0;
        }
        header address{
            color: #fff;    /*文字色の指定*/
            letter-spacing: 5px;    /*文字と文字の間隔をあける*/
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
            margin-bottom: 40px;
        }

        /*****NAV*****/
        nav{
            width: 100%;    /*横幅の指定*/
            border-bottom: 1px solid orange;    /*下部の線の色を指定*/
            margin-bottom: 5px; /**/
            overflow: hidden;   /*おまじない*/
            height:45px;
            padding-top: 40px;
        }
        nav ul{
            width: 60%; /*横幅の指定*/
            margin-left: 20%;   /*左端から20%右側に動かす*/
        }
        nav li{
            width: calc(25% - 2px); /*横幅の指定（線の分をマイナスする）*/
            border-left: 1px solid orange;  /*線を描く*/
            text-align: center; /*文字を中央に*/
            float: left;    /*左から並べる*/
        }
        nav li:last-child{
            border-right: 1px solid orange; /*li要素の最後の物は右側に線を描く*/
        }
        nav a{
            display: block; /*1つのli全体にリンクを有効にする*/
            text-decoration: none;  /*ブラウザ標準のリンク装飾をオフに*/
            color:#313131;  /*文字色の変更*/
            font-size: 110%;    /*フォントサイズの指定*/
            letter-spacing: 5px;    /*文字と文字の間隔をあける*/
            font-weight: 400;   /*文字の太さを調整*/
            line-height: 25px;  /*行間の指定（ナビボタンの高さ指定）*/
        }
        nav a:hover{
            background-color: orange;   /*背景色の指定*/
            color: #fff;    /*文字色の変更*/
            transition: 0.5s;   /*ホバー時の動きをなめらかにする*/
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
    <header>
        <address>Struts2 ECサイト構築練習</address>
    </header>
            <nav>
              <ul style="list-style:none;">
                <li><a href="GoHomeAction">トップページ</a></li>
                <li><a href="GoMypageAction">マイページ</a></li>
                <li><a href="GoCartFromHeaderAction">カート</a></li>
                <li><a href="LogoutAction">ログアウト</a></li>
              </ul>
            </nav>
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
    <footer>
       <address>Copyright(C)2017 Junepi Koziumi,Allright Reserved.</address>
    </footer>
</body>
</html>