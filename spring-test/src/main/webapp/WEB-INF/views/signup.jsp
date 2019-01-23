<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
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
	<script type="text/javascript">
		var signup = ${signup};
		if(signup == false) alert("회원가입에 실패했습니다.");
	</script>
</body>
</html>