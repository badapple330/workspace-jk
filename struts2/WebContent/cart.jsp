<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<!-- td=データ th=見出し -->
	<tr>
		<th><s:text name="商品名"/></th>
		<th><s:text name="値段"/></th>
		<th><s:text name="個数"/></th>
		<th><s:text name="個別合計"/></th>
	</tr>

	<s:iterator value="cartInfoList">
	<tr>
			<!-- itemIDをリストで受け取る。 -->
		<td><s:checkbox name="itemIdList" value="itemIdList" /></td>
		<td><s:property value="itemName" /></td>
        <td><s:property value="price" /></td>
        <td>
        	<s:form action = "CartUpdateAction">
        		<!-- ここの個数限界stock参照してぇ -->
        		<s:select list="{\"1\",\"2\",\"3\",\"4\",\"5\"}" name="quanityty" value="quanityty"/>
				<s:hidden name="itemID" value="itemID"/>
				<s:submit value="更新"/>
			</s:form></td>
      	<td><s:property value="subtotal" /></td>
      	<td>
      		<s:form action = "CartDeleteAction">
      		<s:hidden name="itemIdList" value="itemIdList"/>
      	 		<s:submit value="削除"/>
      	 	</s:form></td>
	</tr>
	</s:iterator>
</table>
合計金額：<s:property value="amountAll"/>
<s:form action="PyamentAction">
	<s:submit value="支払い方法選択"/>
</s:form>

</body>
</html>