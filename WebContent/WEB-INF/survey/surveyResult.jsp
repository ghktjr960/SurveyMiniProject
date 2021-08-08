<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과</title>
<style>
ul{
	list-style:none;
}
</style>
</head>
<body>
	<h1>설문조사 결과</h1>
	<p><h3>설문에 참여해주셔서 감사합니다.<br> <a href="<%=request.getContextPath()%>/">메인페이지 돌아가기</a></h3>
	
	<fieldset>
		<legend><h3>설문 참여자</h3></legend>
		<ul>
			<li>
			<p><b>설문 참여자 총 인원 : ${total}명</b></p>
			<p><b>설문 참여자 비율</b></p>
			<c:forEach var="i" items="${gender}">
				${i.key} : ${i.value*100}% <br>		
			</c:forEach>
			<c:forEach var="i" items="${age}">
				<c:choose>
					<c:when test="${i.key eq '60'}">
						${i.key}대 이상: ${i.value*100}% <br>		
					</c:when>
					<c:otherwise>
						${i.key}대 : ${i.value*100}% <br>		
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend><h3>설문 결과</h3></legend>
		<ul>
			<li>
			<b>1. 최근 사회적 거리두기 단계 격상 이후 코로나 블루를 경험한 적이 있습니까?</b><br>
				<c:forEach var="i" items="${blueExperience}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>2. 코로나 블루를 경험한 가장 큰 원인이 무엇입니까?</b><br>
				<c:forEach var="i" items="${blueReason}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>3. 코로나 블루를 해소하는 방법은 무엇입니까?</b><br>
				<c:forEach var="i" items="${blueRelieve}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>4. 최근 사회적 거리두기 단계 격상 이후 야외활동 경험이 있습니까?(직장, 학업 제외)</b><br>
				<c:forEach var="i" items="${activitieExperience}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>5. 주로 어떤 종류의 야외활동을 합니까?</b><br>
				<c:forEach var="i" items="${activitieKind}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>6. 야외활동은 일주일동안 평균적으로 며칠 정도 합니까?</b>
				<br>(1 : 1일 이내 / 3 : 3일 이내 / 5 : 5일 이내 / 7 : 7일 이내)<br>
				<c:forEach var="i" items="${activitieDate}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>7. 야외활동을 하는 시간대는 주로 언제입니까?</b>
			<br>(1 : 오전 12시 ~ 오전 6시 / 2 : 오전 6시 ~ 오후 12시 / 3 : 오후 12시 ~ 오후 6시 / 4 : 오후 6시 ~ 오전 12시)<br>
				<c:forEach var="i" items="${activitieTime}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>8. 사회적 거리두기 단계 격상 이전과 비교했을 때 야외활동이 증가했습니까?</b><br>
				<c:forEach var="i" items="${activitieIncrease}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
		<ul>
			<li>
			<b>9. 사회적 거리두기 단계 격상 이후 여름철 휴가계획이 있습니까?</b><br>
				<c:forEach var="i" items="${vactionPlan}">
					${i.key} : ${i.value*100}% <br>		
				</c:forEach>
			</li>
		</ul>
	</fieldset>
</body>
</html>