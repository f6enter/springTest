<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
	<form action="<%= request.getContextPath()%>/signup" method="post">
		아이디 <input type="text" name="id" id="id">
		<button id="dup" type="button">중복확인</button><br>
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
		var dup;
	    $('#dup').click( function() { // 중복확인 버튼
	        var id = "";
	        id = $('#id').val(); // 아이디 정보 가져옴
	        $.ajax({
	        	async:true,
	        	type: 'POST',
	        	data:id,
	            url: '/springTest/signup/dup',
	            dataType: 'json',
	            contentType:"application/json; charset=UTF-8",
	            success: function(data) {
	            	console.log(data.dup);
	                if(data.dup == 1){
	                    alert("id 중복");
	                }
	                else{
	                    alert("사용 가능 id");
	                }
	            }
	        });
	    })
	</script>
</body>
</html>