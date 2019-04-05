package gsitm.mvc.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB������ ���� �ε�, ����, �ݱ� ��� Ŭ����
 * */
public class DbUtil {
	private static Properties proFile =  new Properties();
    /**
     * �ε�
     * */
	static {
		try {
			//2���� proerties���� �ε��ϱ�!
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
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				 proFile.getProperty("url"), 
				 proFile.getProperty("userName"), 
				 proFile.getProperty("userPass"));
	} 
	
	/**
	 * �ݱ� (insert, update ,delete �ΰ�� )
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
	 * �ݱ�(select �ΰ��)
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








