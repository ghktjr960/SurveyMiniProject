package survey.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.model.*;

public class ValueProcAction implements CommandAction {
	public String requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		SurveyValueVo value = new SurveyValueVo();
		value.setActivitieDate(Integer.parseInt(req.getParameter("activitieDate")));
		value.setActivitieExperience(req.getParameter("activitieExperience"));
		value.setActivitieIncrease(req.getParameter("activitieIncrease"));
		value.setActivitieKind(req.getParameter("activitieKind"));
		value.setActivitieTime(Integer.parseInt(req.getParameter("activitieTime")));
		value.setBlueExperience(req.getParameter("blueExperience"));
		value.setBlueReason(req.getParameter("blueReason"));
		value.setBlueRelieve(req.getParameter("blueRelieve"));
		value.setVacationPlan(req.getParameter("vacationPlan"));
		
		SurveyDao surveydao = SurveyDao.getInstance();
		int result = surveydao.insertValue(value);
		if(result > 0) {
			return "surveyValueProc";
		}
			return "surveyValueError";
	
	}
}
