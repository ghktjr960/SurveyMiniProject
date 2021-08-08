package survey.action;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.model.SurveyDao;

public class ResultAction implements CommandAction {
	
	SurveyDao surveyDao = SurveyDao.getInstance();
	DecimalFormat fm = new DecimalFormat("0.000");
	
	public String requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int total = surveyDao.selectParticipantTotal();
		
		req.setAttribute("total", total);
		req.setAttribute("gender", participant("GENDER"));
		req.setAttribute("age", participant("AGE"));
		
		req.setAttribute("blueExperience", surveyValue("BLUEEXPERIENCE"));
		req.setAttribute("blueReason", surveyValue("BLUEREASON"));
		req.setAttribute("blueRelieve", surveyValue("BLUERELIEVE"));
		req.setAttribute("activitieExperience", surveyValue("ACTIVITIEEXPERIENCE"));
		req.setAttribute("activitieKind", surveyValue("ACTIVITIEKIND"));
		req.setAttribute("activitieDate", surveyValue("ACTIVITIEDATE"));
		req.setAttribute("activitieTime", surveyValue("ACITIVITIETIME"));
		req.setAttribute("activitieIncrease", surveyValue("ACTIVITIEINCREASE"));
		req.setAttribute("vactionPlan", surveyValue("VACATIONPLAN"));
		return "surveyResult";
	}

	public Map<String, Double> participant(String column) {
		String table = "SURVEYINFO";
		int total = surveyDao.selectParticipantTotal();
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectParticipant(column, table);
		List<String> infoValue = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		for (int i = 0; i < infoValue.size(); i++) {
			double dummy = Double.parseDouble(fm.format((double)tmp.get(infoValue.get(i))/total));
			result.put(infoValue.get(i), dummy);
		}
		return result;
	}

	public Map<String, Double> surveyValue(String column) {
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			double dummy = Double.parseDouble(fm.format((double)tmp.get(valueList.get(i))/total));
			result.put(valueList.get(i), dummy);
		}
		return result;
	}
}
