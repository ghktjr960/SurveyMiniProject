<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="survey.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="info" class="survey.SurveyInfoVo"/>
<jsp:setProperty property="*" name="info"/>
<%
	SurveyService surveyService = SurveyService.getInstance();
	String area = info.getArea();
	if(area.equals("서울") || area.equals("경기") || area.equals("인천")){
		info.setMetro(1);
	} else {
		info.setMetro(2);
	}

	boolean checkInfo = surveyService.registInfo(info);

	if(checkInfo){
		response.sendRedirect("surveyValueForm.jsp");
	} else{
		response.sendRedirect("surveyInfoForm.jsp");
	}
%>
