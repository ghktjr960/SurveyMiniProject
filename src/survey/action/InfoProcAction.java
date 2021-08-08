package survey.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.model.SurveyDao;
import survey.model.SurveyInfoVo;

public class InfoProcAction implements CommandAction {
	public String requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		SurveyInfoVo info = new SurveyInfoVo();
		info.setAge(Integer.parseInt(req.getParameter("age")));
		info.setGender(req.getParameter("gender"));
		info.setArea(req.getParameter("area"));
		
		String area = req.getParameter("area");
		if(area.equals("서울") || area.equals("경기") || area.equals("인천")){
			info.setMetro(1);
		} else {
			info.setMetro(2);
		}
		
		SurveyDao surveydao = SurveyDao.getInstance();
		int result = surveydao.insertInfo(info);
		
		if(result > 0) {
			return "surveyInfoProc";
		} else {
			return "surveyInfoError";
		}
		
	}
}
