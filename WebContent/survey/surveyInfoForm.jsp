<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
	<form action="surveyInfoProc.jsp" method="post">
		<fieldset>
			<legend><b>코로나 블루</b></legend>
				<p>코로나 블루란?</p> 
				코로나 블루는 코로나19와 우울감(blue)가 합져진 신조어로 코로나19로 인한 자가격리나<br>
				사회적 거리두기 등으로 일상생활에 큰 변화가 닥치면서 생긴 우울감이나 무기력증을 뜻한다.
		</fieldset>
		<fieldset>
			<legend><b>설문자 정보입력</b></legend>
			<ul>
				<li>
					<b>나이 </b>  
					<select name="age">
						<option value="10">10대</option>
						<option value="20">20대</option>
						<option value="30">30대</option>
						<option value="40">40대</option>
						<option value="50">50대</option>
						<option value="60">60대 이상</option>
					</select><br>
				</li>
			</ul>
			<ul>
				<li>
					<b>성별 </b>
					<input type="radio" name="gender" value="남" required>남자
					<input type="radio" name="gender" value="여" required>여자<br>
				</li>
			</ul>
			<ul>
				<li>
					<b>지역 </b>
					<select name="area">
						<option value="서울">서울특별시</option>
						<option value="부산">부산광역시</option>
						<option value="대구">대구광역시</option>
						<option value="인천">인천광역시</option>
						<option value="광주">광주광역시</option>
						<option value="대전">대전광역시</option>
						<option value="울산">울산광역시</option>
						<option value="제주">제주특별자치도</option>
						<option value="세종">세종특별자치시</option>
						<option value="경기">경기도</option>
						<option value="강원">강원도</option>
						<option value="충북">충청북도</option>
						<option value="충남">충청남도</option>
						<option value="전북">전라북도</option>
						<option value="전남">전라남도</option>
						<option value="경북">경상북도</option>
						<option value="경남">경상남도</option>
					</select>
				</li>
			</ul>
				<input type="hidden" name="num" value="0">
				<input type="submit" value="설문조사시작">
				<input type="button" value="돌아가기" onclick="window.location='surveyMain.jsp'">
		</fieldset>
	
	
	</form>
</body>
</html>