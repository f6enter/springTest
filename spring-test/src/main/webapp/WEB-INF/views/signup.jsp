<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
<style>
	.width {width: 100px; color:red; display:inline-block;}
	.margin1 {margin-left:105px;}
</style>
</head>
<body>
	<form action="<%= request.getContextPath()%>/signup" method="post" id="form">
		<label class="width">아이디</label>
		<input type="text" name="id" id="id">
		<button id="dup" type="button">중복확인</button><br>
		<label class="width">비밀번호</label>
		<input type="password" name="pw"><br>
		<label class="width">이메일</label>
		<input type="email" name="email"><br>
		<label class="width">성별</label>
		<input type="radio" name="gender" value="female" id="female" checked>
		<label for="female">여</label>
		<input type="radio" name="gender" value="male" id="male">
		<label for="male">남</label><br>
		<div></div>
		<button type="button" id="btnOk" class="margin1">회원가입</button>
	</form>
	<script type="text/javascript">
		var dup=0;
	    $('#dup').click( function() { // 중복확인 버튼
	        var id = "";
	        id = $('#id').val(); // 아이디 정보 가져옴
	        $.ajax({
	        	async:true,
	        	type: 'POST',
	        	data:id,
	            url: '/springTest/signup/dup',
	            dataType: 'json', /* pom.xml에 의존성 추가 */
	            contentType:"application/json; charset=UTF-8",
	            success: function(data) { // data는 서버에서 받은 데이터 
	                if(data.dup){
	                	dup = 1;
	                    alert("id 중복");
	                }
	                else{
	                	dup = -1;
	                    alert("사용 가능 id");
	                }
	            }
	            	 
	        });
	    })
	    $("#btnOk").click(function(){
	    	if(dup == 0) {
	    		alert("아이디 중복 체크를 하세요");
	    		return false;
	    	}
	    	if(dup == 1) {
	    		alert("중복된 아이디입니다. 다른 아이디를 입력하세요.");
	    		return false;
	    	}
	    	$("#form").submit();
	    	return true;
	    });
	</script>
</body>
</html>