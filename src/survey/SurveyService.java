package survey;

import java.util.*;

public class SurveyService {
	private static SurveyService instance;
	private SurveyDao surveyDao;

	private SurveyService(SurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}

	public static SurveyService getInstance() {
		synchronized (SurveyService.class) {
			if (instance == null) {
				instance = new SurveyService(SurveyDao.getInstance());
			}
		}
		return instance;
	}

	// 설문자 인적사항 등록
	public boolean registInfo(SurveyInfoVo info) {
		boolean result = false;
		int checkInfo = surveyDao.insertInfo(info);
		if (checkInfo == 1) {
			result = true;
		}
		return result;
	}

	// 설문조사 결과 등록
	public boolean registValue(SurveyValueVo value) {
		boolean result = false;
		int checkValue = surveyDao.insertValue(value);
		if (checkValue == 1) {
			result = true;
		}
		return result;
	}
	
	// 전체 참여자 수
	public int participantTotal() {
		return surveyDao.selectParticipantTotal();
	}
	
	// 설문 참여자 전체,남,여 비율 : jsp에서 *100으로 백분율 표시
	public Map<String, Double> participantGender() {
		String column = "GENDER";
		String table = "SURVEYINFO";
		Map<String, Double> result = new HashMap<String, Double>();
		Map<String, Integer> tmp = surveyDao.selectParticipantGender(column, table);
		List<String> genderInfoValue = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < genderInfoValue.size(); i++) {
			result.put(genderInfoValue.get(i), (double)tmp.get(genderInfoValue.get(i))/total);
		}
		return result;
	}
	
	// 설문 참여자 나이 정보 : jsp에서 *100으로 백분율 표시
	public Map<String, Double> participantAge(){
		String column = "AGE";
		String table = "SURVEYINFO";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectParticipantAge(column, table);
		List<String> ageInfoValue = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		
		int total = surveyDao.selectParticipantTotal();
		
		for (int i = 0; i < ageInfoValue.size(); i++) {
			result.put(ageInfoValue.get(i), (double)tmp.get(ageInfoValue.get(i))/total);
		}
		return result;
	}
	
	// 인적사항, 설문항목 값 빼오기
	public List<String> surveyValueList(String column, String table){
		TreeSet<String> treeValue = new TreeSet<String>(surveyDao.surveyValueSet(column, table));
		return new ArrayList<>(treeValue);
	}
	
	// 설문결과 뽑기
	public Map<String, Double> resultBlueExperience() {
		String column = "BLUEEXPERIENCE";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultBlueReason() {
		String column = "BLUEREASON";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultBlueRelieve() {
		String column = "BLUERELIEVE";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultActivitieExperience() {
		String column = "ACTIVITIEEXPERIENCE";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultActivitieKind() {
		String column = "ACTIVITIEKIND";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;	}

	public Map<String, Double> resultActivitieDate() {
		String column = "ACTIVITIEDATE";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultActivitieTime() {
		String column = "ACITIVITIETIME";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultActivitieIncrease() {
		String column = "ACTIVITIEINCREASE";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

	public Map<String, Double> resultVactionPlan() {
		String column = "VACATIONPLAN";
		String table = "SURVEYVALUE";
		Map<String, Double> result = new HashMap<>();
		Map<String, Integer> tmp = surveyDao.selectSurveyValue(column, table);
		List<String> valueList = new ArrayList<String>(surveyDao.surveyValueSet(column, table));
		int total = surveyDao.selectParticipantTotal();
		for (int i = 0; i < valueList.size(); i++) {
			result.put(valueList.get(i), (double)tmp.get(valueList.get(i))/total);
		}
		return result;
	}

}
