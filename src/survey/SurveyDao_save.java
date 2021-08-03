package survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SurveyDao_save {
	private static SurveyDao_save instance;
	private ConnectionUtil util;
	
	private SurveyDao_save() {
		util = ConnectionUtil.getInstance();
	}
	
	public static SurveyDao_save getInstance() {
		synchronized (SurveyDao_save.class) {
			if(instance == null) {
				instance = new SurveyDao_save();
			}
		}
		return instance;
	}
	
	// 인적사항 입력(SurveyInfoVO사용)
	public int insertInfo(SurveyInfoVo info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = util.getConnection();
			
			StringBuffer query = new StringBuffer();
			query.append("insert into \"SURVEYINFO\" (\"NUM\", \"AGE\", \"GENDER\", \"AREA\", \"METRO\")");
			query.append(" values (\"SURVEY_SEQ\".NEXTVAL, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, info.getAge());
			pstmt.setString(2, info.getGender());
			pstmt.setString(3, info.getArea());
			pstmt.setInt(4, info.getMetro());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("Info : " + result + "행이 삽입되었습니다");
			} else {
				System.out.println("Info : 삽입에 실패하였습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	} // end insertInfo
	
	public int insertValue(SurveyValueVo value) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = util.getConnection();
			StringBuffer query = new StringBuffer();
			query.append("insert into \"SURVEYVALUE\" ");
			query.append("(\"NUM\", \"BLUEEXPERIENCE\", \"BLUEREASON\", \"BLUERELIEVE\",");
			query.append("\"ACTIVITIEEXPERIENCE\", \"ACTIVITIEKIND\", \"ACTIVITIEDATE\", \"ACITIVITIETIME\",");
			query.append("\"ACTIVITIEINCREASE\", \"VACATIONPLAN\") values(\"SURVEY_SEQ\".CURRVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, value.getBlueExperience());
			pstmt.setString(2, value.getBlueReason());
			pstmt.setString(3, value.getBlueRelieve());
			pstmt.setString(4, value.getActivitieExperience());
			pstmt.setString(5, value.getActivitieKind());
			pstmt.setInt(6, value.getActivitieDate());
			pstmt.setInt(7, value.getActivitieTime());
			pstmt.setString(8, value.getActivitieIncrease());
			pstmt.setString(9, value.getVacationPlan());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("Value : " + result + "행이 삽입되었습니다");
			} else {
				System.out.println("Value : 삽입에 실패하였습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	} // end insertValue
	
	public int selectParticipantTotal() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = util.getConnection();
			String query = "select count(\"NUM\") from \"SURVEYINFO\"";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	} // end selectParticipantTotal
	
	public Map<String, Integer> selectParticipantGender() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		try {
			conn = util.getConnection();
			String query = "select count(\"GENDER\") as \"GENDERCOUNT\" from \"SURVEYINFO\" where \"GENDER\" = ?";
			String[] gender = {"남", "여"};
			for (int i = 0; i < gender.length; i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, gender[i]);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result.put(gender[i], rs.getInt("GENDERCOUNT"));
					pstmt.close();
					rs.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	} //end selectSurveyInfoValue
	
	public Map<Integer, Integer> selectParticipantAge(String column) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		
		try {
			conn = util.getConnection();
			String query = "selecet count(\"AGE\") as \"AGECOUNT\" from \"SURVEYINFO\" where \"AGE\" = ?";
			int[] age = {10, 20, 30, 40, 50, 60};
			for (int i = 0; i < age.length; i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, age[i]);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result.put(age[i], rs.getInt("AGECOUNT"));
					pstmt.close();
					rs.close();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	} // end participantAge
	
	public HashSet<String> surveyValueSet(String column) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashSet<String> valueSet = new HashSet<String>();
		try {
			conn = util.getConnection();
			String query = "select \"" + column + "\" from \"SURVEYVALUE\"";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				valueSet.add(rs.getString(1));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return valueSet;
	} //end surveyValueSet
	
	public Map<String, String> selectSurveyValue(String column) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashSet<String> valueSet = new HashSet<>();
		Map<String, String> result = new HashMap<String, String>();
		try {
			conn = util.getConnection();
			valueSet = surveyValueSet(column);
			List<String> valueList = new ArrayList<>(valueSet); // 중복없이 설문조사 결과담겨 있음
			String query = "select count(\"" + column + "\") as \"COUNT\" from \"SURVEYVALUE\" where \"" + column + "\" = ?";
			for (int i = 0; i < valueList.size(); i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, valueList.get(i));
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result.put(valueList.get(i), rs.getString("COUNT"));
				}
				pstmt.close();
				rs.close();
			} //end for
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	
//	public Map<String, Map<String, Integer>> selectSurveyValue(String column) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		String[] infoCategory = {"age", "gender", "area"};
//		String[] age = {"10", "20", "30", "40", "50", "60"};
//		String[] gender = {"남", "여"};
//		String[] area = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "제주", "세종", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남"};
//		
//		Map<String, Map<String, Integer>> result = new HashMap<String, Map<String,Integer>>();
//		Map<String, Integer> ageValue = new HashMap<String, Integer>();
//		Map<String, Integer> genderValue = new HashMap<String, Integer>();
//		Map<String, Integer> areaValue = new HashMap<String, Integer>();
//		
//		try {
//			conn = util.getConnection();
//			
//			StringBuffer joinTable = new StringBuffer(); 
//			joinTable.append("(select A.\"NUM\", A.\"AGE\", A.\"GENDER\", A.\"AREA\", B.\"");
//			joinTable.append(column);
//			joinTable.append("\" from \"SURVEYINFO\" A join \"SURVEYVALUE\" B on A.\"NUM\" = B.\"NUM\")");
//
//			for (int i = 0; i < infoCategory.length; i++) {
//				if(infoCategory[i].equals("age")) {
//					String query = 
//							"select count(\"" + column + "\") as \"AGECOUNT\" from " 
//									+ joinTable + "where \"AGE\" = ?";
//					System.out.println("query : " + query);
//					System.out.println("join : " + joinTable);
//					for (int j = 0; j < age.length; j++) {
//						pstmt = conn.prepareStatement(query);
//						pstmt.setString(1, age[j]);
//						rs = pstmt.executeQuery();
//						if(rs.next()) {
//							ageValue.put(age[j],  rs.getInt("AGECOUNT"));
//						}
//					}
//					result.put(infoCategory[i], ageValue);
//					pstmt.close();
//					rs.close();
//					query = null;
//				}
//				
//				if(infoCategory[i].equals("gender")) {
//					String query = "select count(\"" + column + "\") as \"GENDERCOUNT\" from " 
//							+ joinTable + "where \"GENDER\" = ?";
//					
//					for (int j = 0; j < gender.length; j++) {
//						pstmt = conn.prepareStatement(query.toString());
//						pstmt.setString(1, gender[j]);
//						rs = pstmt.executeQuery();
//						if(rs.next()) {
//							genderValue.put(gender[j], rs.getInt("GENDERCOUNT"));
//						}
//					}
//					result.put(infoCategory[i], genderValue);
//					pstmt.close();
//					rs.close();
//					query = null;
//				}
//				
//				if(infoCategory[i].equals("area")) {
//					String query = "select count(\"" + column + "\") as \"AREACOUNT\" from " 
//							+ joinTable + "where \"AREA\" = ?";
//					
//					for (int j = 0; j < area.length; j++) {
//						pstmt = conn.prepareStatement(query.toString());
//						pstmt.setString(1, area[j]);
//						rs = pstmt.executeQuery();
//						if(rs.next()) {
//							areaValue.put(area[j], rs.getInt("AREACOUNT"));
//						}
//					}
//					result.put(infoCategory[i], areaValue);
//					pstmt.close();
//					rs.close();
//				}
//			} // end infoCategory for
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	} //end selectSurveyValue
}
