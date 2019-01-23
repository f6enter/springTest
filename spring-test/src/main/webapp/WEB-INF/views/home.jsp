<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
	<!-- jsp에서 서버로 보낼 때 form태그 사용   -->
	<form action="<%= request.getContextPath()%>/" method="post" 
	 	  style="<c:if test="${user != null}">display:none;</c:if>">
		<input type-"text" name="id"><br>
		<input type="password" name="pw"><br>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
	
	<a href="<%= request.getContextPath()%>/signup">회원가입</a>
	<script type="text/javascript">
		var signup = ${signup};
		if(signup == true) alert('회원가입에 성공했습니다.');
	</script>
</body>

</html>
