<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
	<c:if test="${user != null}">
		<a href="<%=request.getContextPath()%>/signout">로그아웃</a>
	</c:if>
	<c:if test="${user == null}">
		<a href="<%=request.getContextPath()%>/">로그인</a>
	</c:if>
	<table class="table">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.id}</td>
				<td><a href="<%=request.getContextPath()%>/bbs/detail?id=${board.id}">${board.title}</a></td>
				<td>${board.writer}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%=request.getContextPath()%>/bbs/register"><button>등록</button></a>
</body>
</html>