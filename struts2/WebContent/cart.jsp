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

<s:form action = "CartDeleteAction">
<s:hidden name="userID" value="%{userID}"/>
<s:iterator value="cartInfoList" status="st">
	<tr><!-- itemIDをリストで受け取る。 -->
		<td><s:property value="itemName" /></td>
		<td><s:property value="price" /></td>
		<td><!-- ここの個数限界stock参照してぇ -->
			<!--<s:form action = "CartUpdateAction">
				<s:select name="quantity" list="{\"1\",\"2\",\"3\",\"4\",\"5\"}" />
					<s:hidden name="itemID" value="%{itemID}"></s:hidden>
				<s:submit value="更新"/>
			</s:form>-->
			ITEMID=<s:property value="itemID" />
		</td>
		<td><s:property value="subtotal" /></td>
		<td>
		<s:checkbox name="checkList" value="check" id ="%{#st.index}" fieldValue="%{#st.index}"/>
		<!--<s:checkbox name="checkList[%{#st.index}]" id ="%{#st.index}" fieldValue=""/>-->
		<!--<s:checkbox name="checkList[%{#st.index}]" value="checked" fieldValue="%{#st.index}"/>-->
		<!--<s:hidden name="cartInfoList[%{#st.index}]" value="%{cartInfoList[#st.index]}"/>-->
		<input type="hidden" name="cartInfoList" value="<s:property value='cartInfoList'/>">
		</td>
	</tr>

</s:iterator>
<!--
<s:iterator value="cartInfoList" status="st">

		<s:hidden name="itemName" value="itemName" />
		<s:hidden name="price" value="price" />
		<s:hidden name="itemID" value="itemID" />
		<s:hidden name="subtotal" value="subtotal" />
		<s:hidden name="cartInfoList%{#st.index}" value="%{cartInfoList[#st.index]}"/>
</s:iterator>
 -->
<s:submit value="削除"/>
</s:form>
</table>
合計金額：<s:property value="amountAll"/>

<s:form action="GoPyamentAction">
	<s:submit value="支払い方法選択へ"/>
</s:form>

</body>
</html>