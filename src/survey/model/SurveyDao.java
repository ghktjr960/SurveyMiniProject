package survey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SurveyDao {
	private static SurveyDao instance;
	private ConnectionUtil util;
	
	private SurveyDao() {
		util = ConnectionUtil.getInstance();
	}
	
	public static SurveyDao getInstance() {
		synchronized (SurveyDao.class) {
			if(instance == null) {
				instance = new SurveyDao();
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
			String joinTable = "select A.\"NUM\", B.\"BLUEEXPERIENCE\" from \"SURVEYINFO\" A join \"SURVEYVALUE\" B on A.\"NUM\" = B.\"NUM\""; 
			String query = "select count(\"NUM\") from ("+ joinTable +")";
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
	
	public Map<String, Integer> selectParticipant(String column, String table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Integer> result = new HashMap<String, Integer>();
		HashSet<String> participantValueSet = new HashSet<>();
		
		try {
			conn = util.getConnection();
			String joinTable = "select A.\"" + column + "\", B.\"BLUEEXPERIENCE\" from \"SURVEYINFO\" A join \"SURVEYVALUE\" B on A.\"NUM\" = B.\"NUM\"";
			String query = "select count(\"" + column + "\") as \"COUNT\" from (" + joinTable + ") where \"" + column + "\" = ?";
			participantValueSet = surveyValueSet(column, table);
			List<String> participantValueList = new ArrayList<>(participantValueSet);
			
			for (int i = 0; i < participantValueList.size(); i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, participantValueList.get(i));
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result.put(participantValueList.get(i), rs.getInt("COUNT"));
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
	} //end selectParticipant
	
	public HashSet<String> surveyValueSet(String column, String table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashSet<String> valueSet = new HashSet<String>();
		try {
			conn = util.getConnection();
			String query = "select \"" + column + "\" from \"" + table + "\"";
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
	
	public Map<String, Integer> selectSurveyValue(String column, String table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashSet<String> valueSet = new HashSet<>();
		Map<String, Integer> result = new HashMap<String, Integer>();
		try {
			conn = util.getConnection();
			valueSet = surveyValueSet(column, table);
			List<String> valueList = new ArrayList<>(valueSet); // 중복없이 설문조사 결과담겨 있음
			String query = "select count(\"" + column + "\") as \"COUNT\" from \"SURVEYVALUE\" where \"" + column + "\" = ?";
			for (int i = 0; i < valueList.size(); i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, valueList.get(i));
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result.put(valueList.get(i), rs.getInt("COUNT"));
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
}