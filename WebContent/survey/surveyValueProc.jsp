<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="survey.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
    
<jsp:useBean id="value" class="survey.SurveyValueVo"/>
<jsp:setProperty property="*" name="value"/>
<%
	SurveyService surveyService = SurveyService.getInstance();

	boolean checkValue =surveyService.registValue(value);
	if(checkValue){
		response.sendRedirect("surveyComplete.jsp");
	} else{
		response.sendRedirect("surveyMain.jsp");
	}
%>