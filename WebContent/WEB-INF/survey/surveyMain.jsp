<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Corona Survey</title>
</head>
<body>
<h3>코로나 블루 설문조사</h3>
<form>
	<p>
	코로나 블루 설문조사를 시작하시려면 옆에 버튼을 눌러주세요
	<input type="button" value="설문조사 시작" onclick="window.location='<%=request.getContextPath()%>/announcement'">
	</p>
	<p>
	설문조사에 대한 결과를 보시려면 옆에 버튼을 눌러주세요
	<input type="button" value="설문조사 결과보기" onclick="window.location='<%=request.getContextPath()%>/result'">
	</p>
</form>
</body>
</html>