<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
</head>
<body>
	<form  action="/SSMTest5/LoginAdmin">
			<input  placeholder="请输入账号" name="accounts" type="text"><br>
			<input  placeholder="请输入密码" name="password" type="password"><br>
			<input type="submit" value="登录"><br>
			${msg}
	</form>
</body>
</html>