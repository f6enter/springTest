<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  ${hi}
</h1>
	<form action="<%=request.getContextPath()%>/" method="get">
		아이디 <input type="text" name="id"><br>
		비밀번호 <input type="password" name="pw"><br>
		<button>로그인</button>
	</form>
	<a href="<%=request.getContextPath()%>/signup">회원가입</a>
</body>
</html>
