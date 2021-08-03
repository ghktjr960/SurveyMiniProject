<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="survey.*, java.util.*, java.text.DecimalFormat"%>
<%
	SurveyService surveyService = SurveyService.getInstance();
	
	int participantTotal = surveyService.participantTotal();

	//설문참여자 정보
	int total = surveyService.participantTotal();
	Map<String, Double> participantAge = surveyService.participantAge();
	Map<String, Double> participanrGender = surveyService.participantGender();
	List<String> ageValueList = surveyService.surveyValueList("AGE", "SURVEYINFO");
	List<String> genderValueList = surveyService.surveyValueList("GENDER", "SURVEYINFO");

	//설문항목정보
	Map<String, Double> blueExperienceValue = surveyService.resultBlueExperience();
	List<String> blueExperienceList = surveyService.surveyValueList("BLUEEXPERIENCE", "SURVEYVALUE");
	Map<String, Double> blueReasonValue = surveyService.resultBlueReason();
	List<String> blueReasonList = surveyService.surveyValueList("BLUEREASON", "SURVEYVALUE");
	Map<String, Double> blueRelieveValue = surveyService.resultBlueRelieve();
	List<String> blueRelieveList = surveyService.surveyValueList("BLUERELIEVE", "SURVEYVALUE");
	Map<String, Double> activitieExperienceValue = surveyService.resultActivitieExperience();
	List<String> activitieExperienceList = surveyService.surveyValueList("ACTIVITIEEXPERIENCE", "SURVEYVALUE");
	Map<String, Double> activitieKindValue = surveyService.resultActivitieKind();
	List<String> activitieKindList = surveyService.surveyValueList("ACTIVITIEKIND", "SURVEYVALUE");
	Map<String, Double> activitieDateValue = surveyService.resultActivitieDate();
	List<String> activitieDateList = surveyService.surveyValueList("ACTIVITIEDATE", "SURVEYVALUE");
	Map<String, Double> activitieTimeValue = surveyService.resultActivitieTime();
	List<String> activitieTimeList = surveyService.surveyValueList("ACITIVITIETIME", "SURVEYVALUE");
	Map<String, Double> activitieIncreaseValue = surveyService.resultActivitieIncrease();
	List<String> activitieIncreaseList = surveyService.surveyValueList("ACTIVITIEINCREASE", "SURVEYVALUE");
	Map<String, Double> vactionPlanValue = surveyService.resultVactionPlan();
	List<String> vactionPlanList = surveyService.surveyValueList("VACATIONPLAN", "SURVEYVALUE");
	
	DecimalFormat format = new DecimalFormat("0.000");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul{
	list-style:none;
}
</style>
</head>
<body>
	<h1>설문조사 결과</h1>
	<p><h3>설문에 참여해주셔서 감사합니다.<br> <a href="surveyMain.jsp">메인페이지 돌아가기</a></h3>
	
	<fieldset>
		<legend><h3>설문 참여자</h3></legend>
		<ul>
			<li>
			<p><b>설문 참여자 총 인원 : <%=total %>명</b></p>
			<p><b>설문 참여자 비율</b></p>
			<%	
			for(int i = 0; i < genderValueList.size(); i++){
					String gv = genderValueList.get(i);	
			%>
				<%=gv %> : <%=Math.round(participanrGender.get(gv)*100) %>%<br>
			<%	
			} for(int i = 0; i < ageValueList.size(); i++){
				String av = ageValueList.get(i);
				if(av.equals("60")){	
			%>
				<br><%=av %>대이상 : <%=Math.round(participantAge.get(av)*100) %>% 
			<%	} else{ %>
				<br><%=av %>대 : <%=Math.round(participantAge.get(av)*100) %>%
			<%	
				}
			}	
			%>				
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend><h3>설문 결과</h3></legend>
		<ul>
			<li>
			<b>1. 최근 사회적 거리두기 단계 격상 이후 코로나 블루를 경험한 적이 있습니까?</b>
			<%
				for(int i = 0; i < blueExperienceList.size(); i++){
					String answer = blueExperienceList.get(i);
					double result = Double.parseDouble(format.format(blueExperienceValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>2. 코로나 블루를 경험한 가장 큰 원인이 무엇입니까?</b>
			<%
				for(int i = 0; i < blueReasonList.size(); i++){
					String answer = blueReasonList.get(i);
					double result = Double.parseDouble(format.format(blueReasonValue.get(answer)));
					
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>3. 코로나 블루를 해소하는 방법은 무엇입니까?</b>
			<%
				for(int i = 0; i < blueRelieveList.size(); i++){
					String answer = blueRelieveList.get(i);
					double result = Double.parseDouble(format.format(blueRelieveValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>4. 최근 사회적 거리두기 단계 격상 이후 야외활동 경험이 있습니까?(직장, 학업 제외)</b>
			<%
				for(int i = 0; i < activitieExperienceList.size(); i++){
					String answer = activitieExperienceList.get(i);
					double result = Double.parseDouble(format.format(activitieExperienceValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>5. 주로 어떤 종류의 야외활동을 합니까?</b>
			<%
				for(int i = 0; i < activitieKindList.size(); i++){
					String answer = activitieKindList.get(i);
					double result = Double.parseDouble(format.format(activitieKindValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>6. 야외활동은 일주일동안 평균적으로 며칠 정도 합니까?</b>
				<br>(1 : 1일 이내 / 3 : 3일 이내 / 5 : 5일 이내 / 7 : 7일 이내)
			<%
				for(int i = 0; i < activitieDateList.size(); i++){
					String answer = activitieDateList.get(i);
					double result = Double.parseDouble(format.format(activitieDateValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>7. 야외활동을 하는 시간대는 주로 언제입니까?</b>
			<br>(1 : 오전 12시 ~ 오전 6시 / 2 : 오전 6시 ~ 오후 12시 / 3 : 오후 12시 ~ 오후 6시 / 4 : 오후 6시 ~ 오전 12시)
			<%
				for(int i = 0; i < activitieTimeList.size(); i++){
					String answer = activitieTimeList.get(i);
					double result = Double.parseDouble(format.format(activitieTimeValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			
			</li>
		</ul>
		<ul>
			<li>
			<b>8. 사회적 거리두기 단계 격상 이전과 비교했을 때 야외활동이 증가했습니까?</b>
			<%
				for(int i = 0; i < activitieIncreaseList.size(); i++){
					String answer = activitieIncreaseList.get(i);
					double result = Double.parseDouble(format.format(activitieIncreaseValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
		<ul>
			<li>
			<b>9. 사회적 거리두기 단계 격상 이후 여름철 휴가계획이 있습니까?</b>
			<%
				for(int i = 0; i < vactionPlanList.size(); i++){
					String answer = vactionPlanList.get(i);
					double result = Double.parseDouble(format.format(vactionPlanValue.get(answer)));
			%>
					<br><%=answer %> : <%=result*100 %>%
			<%
				}
			%>
			</li>
		</ul>
	</fieldset>
</body>
</html>