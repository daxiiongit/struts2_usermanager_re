<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<h3><font color="blue">添加用户</font></h3>
		<s:form action="user-add" method="post">
			<table width="300" border="1" bordercolor="#99CCFF" bgcolor="#FFFFEE">
				<s:hidden name="id"></s:hidden>
				<s:textfield name="name" label="姓名"></s:textfield>
				<s:select list="sexs" name="sex" label="性别"></s:select>
				<s:textfield name="age" label="年龄"></s:textfield>
				<s:textfield name="telephone" label="电话"></s:textfield>
				<s:textfield name="email" label="邮箱"></s:textfield>
				<s:textfield name="specialty" label="专业"></s:textfield>
				<s:textfield name="school" label="学校"></s:textfield>
				<s:textfield name="address" label="地址"></s:textfield>
				<s:submit value="提交" align="center"></s:submit>
			</table>
		</s:form>
	</div>

</body>
</html>