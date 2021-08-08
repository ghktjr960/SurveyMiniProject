<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 안내</title>
</head>
<body>
<p><b>조사명</b> : 코로나 블루와 야외활동에 대한 연관성 조사</p>
<p><b>문항수</b> : 9문항<br>
<b>응답시간</b> : 약 3분소요
<p><b>조사 목적</b><br>
최근 사회적 거리두기가 격상되면서 사회적 거리두기의 장기화가 이어지고 있다.<br>
이로인해 우울감과 불안감이 코로나 바이러스와 함께 퍼지고 있는데<br>
이 설문조사는 사회적 거리두기 단계의 격상과 장기화가 코로나 블루에 영향을 미치는지를 확인하고<br>
실제 야외활동에 영향을 주는지를 확인하기 위한 설문조사이다.
</p>
<p>
<form>
	<input type="button" value="설문조사 진행" onclick="window.location='<%=request.getContextPath()%>/infoForm'">
	<input type="button" value="돌아가기" onclick="window.location='<%=request.getContextPath()%>/'">
</form>
</body>
</html>