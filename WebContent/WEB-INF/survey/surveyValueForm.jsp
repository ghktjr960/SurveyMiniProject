<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
<style>
ul{
   list-style:none;
   }
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/valueProc" method="post">
		<fieldset>
			<legend>설문조사</legend>		
				<p>
					<b>1. 최근 사회적 거리두기 단계 격상 이후 코로나 블루를 경험한적이 있습니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="blueExperience" value="있다" required>있다</label><br>
						<label><input type="radio" name="blueExperience" value="없다" required>없다</label><br>
						</li>				
					</ul>
				<p>
					<b>2. 코로나 블루를 경험한 가장 큰 원인이 무엇입니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="blueReason" value="경제" required>경제적 문제</label><br>
						<label><input type="radio" name="blueReason" value="활동제한" required>단계격상으로 인한 활동제한</label><br>
						<label><input type="radio" name="blueReason" value="가족" required>가족관계</label><br>
						<label><input type="radio" name="blueReason" value="학업" required>학업문제</label><br>
						<label><input type="radio" name="blueReason" value="취업" required>취업문제</label><br>
						<label><input type="radio" name="blueReason" value="기타" required>기타</label><br>
						</li>				
					</ul>
				<p>
					<b>3. 코로나 블루를 해소하는 방법은 무엇입니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="blueRelieve" value="집_취미" required>집에서 하는 취미생활</label><br>
						<label><input type="radio" name="blueRelieve" value="운동_산책" required>가벼운 운동 또는 산책</label><br>
						<label><input type="radio" name="blueRelieve" value="소통" required>다양한 미디어를 통한 사람들과 소통</label><br>
						<label><input type="radio" name="blueRelieve" value="여가활동" required>쇼핑, 영화등 여가활동</label><br>
						<label><input type="radio" name="blueRelieve" value="지인" required>지인들과 만남</label><br>
						<label><input type="radio" name="blueRelieve" value="기타" required>기타</label><br>
						</li>				
					</ul>
				<p>
					<b>4. 최근 사회적 거리두기 단계 격상 이후 야외활동 경험이 있습니까?(직장, 학업 제외)</b>
					<ul>
						<li>	
						<label><input type="radio" name="activitieExperience" value="있다" required>있다</label><br>
						<label><input type="radio" name="activitieExperience" value="없다" required>없다</label><br>
						</li>				
					</ul>
				<p>
					<b>5. 주로 어떤 활동이였습니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="activitieKind" value="쇼핑" required>쇼핑</label><br>
						<label><input type="radio" name="activitieKind" value="실내체육" required>실내체육시설 이용</label><br>
						<label><input type="radio" name="activitieKind" value="운동_산책" required>가벼운 운동 또는 산책</label><br>
						<label><input type="radio" name="activitieKind" value="외식" required>카페, 음식점등 외식</label><br>
						<label><input type="radio" name="activitieKind" value="여행" required>여행</label><br>
						<label><input type="radio" name="activitieKind" value="놀이시설" required>놀이시설</label><br>
						<label><input type="radio" name="activitieKind" value="기타" required>기타</label><br>
						</li>				
					</ul>
				<p>
					<b>6. 야외활동은 일주일동안 평균적으로 며칠정도 합니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="activitieDate" value="1" required>1일이내</label><br>
						<label><input type="radio" name="activitieDate" value="3" required>3일이내</label><br>
						<label><input type="radio" name="activitieDate" value="5" required>5일이내</label><br>
						<label><input type="radio" name="activitieDate" value="7" required>7일이내</label><br>
						</li>				
					</ul>
				<p>
					<b>7. 야외활동을 하는 시간대는 주로 언제입니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="activitieTime" value="1" required>오전 12시 ~ 오전 6시</label><br>
						<label><input type="radio" name="activitieTime" value="2" required>오전 6시 ~ 오후 12시</label><br>
						<label><input type="radio" name="activitieTime" value="3" required>오후 12시 ~ 오후 6시</label><br>
						<label><input type="radio" name="activitieTime" value="4" required>오후 6시 ~ 오전 12시</label><br>
						</li>				
					</ul>
				<p>
					<b>8. 사회적 거리두기 단계 격상 이전과 비교했을 때 야외활동이 증가했습니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="activitieIncrease" value="감소" required>감소했다</label><br>
						<label><input type="radio" name="activitieIncrease" value="그대로" required>그대로다</label><br>
						<label><input type="radio" name="activitieIncrease" value="증가" required>증가했다</label><br>
						</li>				
					</ul>
				<p>
					<b>9. 사회적 거리두기 단계 격상 이후 여름철 휴가계획이 있습니까?</b>
					<ul>
						<li>	
						<label><input type="radio" name="vacationPlan" value="있다" required>있다</label><br>
						<label><input type="radio" name="vacationPlan" value="없다" required>없다</label><br>
						</li>				
					</ul>
				<p>
				<input type="submit" value="설문조사 완료">
		</fieldset>	
	</form>
</body>
</html>