package survey;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	private static ConnectionUtil instance;
	
	private DataSource ds;
	
	private ConnectionUtil() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionUtil getInstance() {
		synchronized (ConnectionUtil.class) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			if(instance == null) {
				instance = new ConnectionUtil();
			}
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
}
