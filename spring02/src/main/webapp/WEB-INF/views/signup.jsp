<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
	<form action="<%= request.getContextPath()%>/signup" method="post">
		아이디 <input type="text" name="id"><br>
		비밀번호 <input type="password" name="pw"><br>
		이메일  <input type="email" name="email"><br>
		성별 
		<input type="radio" name="gender" value="female" id="female" checked>
		<label for="female">여</label>
		<input type="radio" name="gender" value="male" id="male">
		<label for="male">남</label><br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>
