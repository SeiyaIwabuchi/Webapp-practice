import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperator {
	private static String dbFileName = "C:/Users/180453/Desktop/dev_lite/h2/bin/kadai14db";
	private static String dbUser = "h2user";
	private static String dbPass = "password";
	private Connection conn = null;
	private Statement smt = null;
	private ResultSet rs = null;
	public DatabaseOperator() {
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:" + dbFileName , dbUser, dbPass);
			if(conn != null) {
				try {
					smt = conn.createStatement();
					rs = smt.executeQuery("select * from M_GENRE");
					if(rs != null) {
						while(rs.next()) {
							System.out.print(String.format("ID:%s\tNAME:%s", rs.getString("ID"),rs.getString("NAME") + "\n"));
						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(smt != null) {smt.close();}
			}catch(Exception e) {e.printStackTrace();}
		}
	}
	public void insertToBook(int id,bean.BookBean bookbean) {
		boolean result = false;
		if(conn != null) {
			try {
				smt = conn.createStatement();
				rs = smt.executeQuery(String.format("insert into t_book values('%06d','%s','%s','%d','%s','%b','%s')", id,bookbean.getTitle()));
				result = true;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(smt != null) {smt.close();}
				}catch(Exception e) {e.printStackTrace();}
			}
		}
	}
	public int getMaxBookId() {
		int id = -1;
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:" + dbFileName , dbUser, dbPass);
			if(conn != null) {
				try {
					smt = conn.createStatement();
					rs = smt.executeQuery("select max(id) as maxid from t_book");
					if(rs != null) {
						rs.next();
						id = rs.getString("maxid") != null?Integer.parseInt(rs.getString("maxid")):-1;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(smt != null) {smt.close();}
			}catch(Exception e) {e.printStackTrace();}
		}
		return id;
	}
}
