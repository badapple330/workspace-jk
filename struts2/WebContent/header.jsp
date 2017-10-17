<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
<header>
	<s:if test="session.userID != null && session.adminflg == 0">
	<table border=1>
	<tr>
		<td><a href="<s:url action="GoToppageAction"/>" class="header_btn">トップページ</a></td>
		<td><a href="<s:url action="MypageAction"/>" class="header_btn">マイページ</a></td>
		<td><a href="<s:url action="GoCartAction"/>" class="header_btn">カート</a></td>
		<td><a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a></td>
	</tr>
	</table>
	</s:if>

	<s:if test="session.userID != null && session.adminflg == 1">
		管理者トップ
		<a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a>
		管理者商品
		<a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a>
		管理者ユーザー
		<a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a>
		管理者販売履歴
		<a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a>
		ログアウト
		<a href="<s:url action="LogoutAction"/>" class="header_btn">ログアウト</a>
	</s:if>
</header>
</body>
</html>