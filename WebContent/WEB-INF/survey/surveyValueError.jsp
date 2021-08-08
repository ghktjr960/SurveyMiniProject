<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<script>
	alert("입력정보를 확인해주세요");
	document.location.href="<%=request.getContextPath()%>/valueForm";
</script>
</body>
</html>