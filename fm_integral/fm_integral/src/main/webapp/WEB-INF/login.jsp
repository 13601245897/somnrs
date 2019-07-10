<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hi springMvc view!!</h1>
	<button onclick="addint()">积分</button>
</body>
<script type="text/javascript" src="js/jquery.min.js">
function addint(){
	
	 $.ajax({
	        url:'http://localhost:8012/login/add',
	        type:'post',
	        dataType:'json',
	        cache:false,
	        contentType: "application/json;charset=utf-8",
	        data:
	        		jifen : 1,
	        success:function(jsondata){
	          
	        }
	    })
}

</script>
</html>