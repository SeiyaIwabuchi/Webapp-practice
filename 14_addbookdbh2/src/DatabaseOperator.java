import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperator {
	private static String dbFileName = "../Webapp-practice/database/h2/kadai14db";
	private static String dbUser = "h2user";
	private static String dbPass = "password";
	private Statement smt = null;
	private ResultSet rs = null;
	public DatabaseOperator() { //事前に作成したデータベースに接続してみる
		Connection conn = this.getConnection();
			if(conn != null) { //ヌルポならないように
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
				}finally {
					try {
						if(rs != null) {rs.close();} //自分のケツは自分で拭う
					}catch(Exception e) {e.printStackTrace();}
					try {
						if(conn != null) {conn.close();} //自分のケツは自分で拭う
						System.out.println("Connection closed.");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:" + dbFileName , dbUser, dbPass);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(smt != null) {smt.close();}
			}catch(Exception e) {e.printStackTrace();}
		}
		return conn;
	}
	public void insertToBook(int id,bean.BookBean bookbean) {
		boolean result = false;
		Connection conn = this.getConnection();
		if(conn != null) {
			try {
				smt = conn.createStatement();
				smt.executeUpdate(
						String.format(
								"insert into t_book values('%06d','%s','%s',%s,'%s','%b','%s')", 
								id,
								bookbean.getTitle(),
								bookbean.getWritter(),
								bookbean.getPrice(),
								bookbean.getPublisher(),
								bookbean.isStock(),
								bookbean.getRemarks()
								));
				result = true;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(smt != null) {smt.close();} //自分のケツは自分で拭う
				}catch(Exception e) {e.printStackTrace();}
				try {
					if(conn != null) {conn.close();} //自分のケツは自分で拭う
					System.out.println("Connection closed.");
				}catch (Exception e) {e.printStackTrace();}
			}
		}
	}
	public int getMaxBookId() {
		int id = -1;
		Connection conn = this.getConnection();
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
				if(smt != null) {smt.close();} //自分のケツは自分で拭う
			}catch(Exception e) {e.printStackTrace();}
			try {
				if(conn != null) {conn.close();} //自分のケツは自分で拭う
				System.out.println("Connection closed.");
			}catch (Exception e) {e.printStackTrace();}
		}
		return id;
	}
}

