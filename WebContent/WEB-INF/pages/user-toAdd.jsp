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

    <s:debug></s:debug>
	<s:property value="id"/>
	<s:property value="name"/>

	<div align="center">
		<h3><font color="blue">
			<s:if test="%{user.id} == 0">
				添加用户
			</s:if>
			<s:else>
				修改用户
			</s:else>
		</font></h3>
		<s:form action="saveOrUpdate-user" method="post">
			<table width="300" border="1" bordercolor="#99CCFF" bgcolor="#FFFFEE">
				<s:hidden name="user.id"></s:hidden>
				<s:textfield name="user.name" label="姓名"></s:textfield>
				<s:select list="sexs" name="user.sex" label="性别"></s:select>
				<s:textfield name="user.age" label="年龄"></s:textfield>
				<s:textfield name="user.telephone" label="电话"></s:textfield>
				<s:textfield name="user.email" label="邮箱"></s:textfield>
				<s:textfield name="user.specialty" label="专业"></s:textfield>
				<s:textfield name="user.school" label="学校"></s:textfield>
				<s:textfield name="user.address" label="地址"></s:textfield>
				<s:submit value="提交" align="center"></s:submit>
			</table>
		</s:form>
	</div>

</body>
</html>