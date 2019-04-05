package gsitm.mvc.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB연동을 위한 로드, 연결, 닫기 기능 클래스
 * */
public class DbUtil {
	private static Properties proFile =  new Properties();
    /**
     * 로드
     * */
	static {
		try {
			//2개의 proerties파일 로딩하기!
			proFile.load(new FileInputStream("properties/dbInfo.properties"));
			proFile.load(new FileInputStream("properties/board.properties"));
			
		 Class.forName(proFile.getProperty("driverName"));
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				 proFile.getProperty("url"), 
				 proFile.getProperty("userName"), 
				 proFile.getProperty("userPass"));
	} 
	
	/**
	 * 닫기 (insert, update ,delete 인경우 )
	 * */
	public static void dbClose(Statement st, Connection con){
		try {
		  if(st!=null) st.close();
		  if(con!=null) con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기(select 인경우)
	 * */
    public static void dbClose(ResultSet rs , Statement st, Connection con){
    	try {
		  if(rs!=null)rs.close();
		  dbClose(st, con);
    	}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
   /* public static void main(String[] args) {
		System.out.println(1111);
	}*/
}








