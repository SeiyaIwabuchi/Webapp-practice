import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperator {
	private static String dbHost = "localhost";
	private static String dbUser = "mysqluser";
	private static String dbPass = "password";
	private Statement smt = null;
	private ResultSet rs = null;
	public DatabaseOperator() { //事前に作成したデータベースに接続してみる
		Connection conn = this.getConnection();
			if(conn != null) { //ヌルポならないように
				try {
					smt = conn.createStatement();
					rs = smt.executeQuery("select * from kadai15.M_GENRE");
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
			//Class.forName("org.h2.Driver");
			Class.forName( "org.mariadb.jdbc.Driver" );
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost , dbUser, dbPass);
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
								"insert into kadai15.t_book values('%06d','%s','%s',%s,'%s','%d','%s')", 
								id,
								bookbean.getTitle(),
								bookbean.getWritter(),
								bookbean.getPrice(),
								bookbean.getPublisher(),
								bookbean.isStock()==true?1:0,
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
	public void insertToBookGenre(int bookId,bean.BookBean bookbean) {
		boolean result = false;
		Connection conn = this.getConnection();
		if(conn != null) {
			try {
				smt = conn.createStatement();
				for(String genreId:bookbean.getGenreList()) {
					int genreNumber = Integer.parseInt(genreId) + 1;
					System.out.println(bookbean.getGenreList());
					System.out.println(String.format("insert into kadai15.t_bookgenre values('%06d','%06d')",bookId,genreNumber));
					smt.executeUpdate(
							String.format("insert into kadai15.t_bookgenre values('%06d','%06d')",bookId,genreNumber)
							);
				}
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
			if(conn != null) {
				try {
					smt = conn.createStatement();
					rs = smt.executeQuery("select max(id) as maxid from kadai15.t_book");
					if(rs != null) {
						rs.next();
						id = rs.getString("maxid") != null?Integer.parseInt(rs.getString("maxid")):-1;
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
			}
		return id;
	}
}

