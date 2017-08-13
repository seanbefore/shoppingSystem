package db;
import java.sql.*;

public final class DB {
	public static Connection getconn(){
		Connection conn = null;
		
		String user = "root";
		String pwd = "root";
		String url = "jdbc:mysql://localhost/shopdb";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(url,user,pwd);
		    System.out.println("Connected database successfully...");
		}catch( SQLException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	//重载了Close()方法用于添加和查询时不同状态关闭链接
	public static void Close(PreparedStatement ps,Connection conn) {
		
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void Close(PreparedStatement ps,Connection conn,ResultSet rs) {
		
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
