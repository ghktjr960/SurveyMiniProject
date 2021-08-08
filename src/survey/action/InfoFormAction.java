package survey.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoFormAction implements CommandAction {

	public String requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "surveyInfoForm";
	}
}
