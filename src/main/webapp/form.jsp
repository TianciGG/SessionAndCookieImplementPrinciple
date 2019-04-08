<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Form表单</title>
<script type="text/javascript">
	var flag = false;//false表示未提交 true表示已经提交 
	function isSubmit() {
	    if(!flag){
	    	flag=true;
	    	return true;
	    }else{
	    	return false;
	    }
	}
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/DoFormServlet"
		method="post" onsubmit="return isSubmit();">
		<input type="hidden" name="token" value="${token}">
		用户名：<input type="text" name="userName"> <input type="submit"
			value="提交" id="submit">
	</form>
</body>
</html>
