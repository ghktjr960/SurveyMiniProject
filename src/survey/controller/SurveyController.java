package survey.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.action.*;

public class SurveyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Map<String, CommandAction> actionMap = new HashMap<String, CommandAction>();
	
	@Override
	public void init() throws ServletException {
		actionMap.put("/", new MainAction());
		actionMap.put("/announcement", new AnnouncementAction());
		
		actionMap.put("/infoForm", new InfoFormAction());
		actionMap.put("/infoProc", new InfoProcAction());
		actionMap.put("/valueForm", new ValueFormAction());
		actionMap.put("/valueProc", new ValueProcAction());
		actionMap.put("/complete", new CompleteAction());
		actionMap.put("/result", new ResultAction());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUri = req.getRequestURI();
		String cmd = reqUri.substring(req.getContextPath().length());
		
		CommandAction action = actionMap.get(cmd);
		System.out.println("action : " + action.getClass());
		
		String viewName = action.requestPro(req, resp);
		String viewPrefix = "/WEB-INF/survey/";
		String viewSuffix = ".jsp";
		String viewPage = viewPrefix + viewName + viewSuffix;
		
		System.out.println("viewPage : " + viewPage);
		req.getRequestDispatcher(viewPage).forward(req, resp);
		
	}
}
