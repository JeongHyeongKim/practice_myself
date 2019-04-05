package ex0404.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

   // 로드
   static {
      try {
         Class.forName(DBProperty.DRIVER_NAME);

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }

   // 연결
   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(DBProperty.URL, DBProperty.USER_NAME, DBProperty.USER_PASS);
   }

   // 닫기 (DDL or DML인 경우 : Create, Insert, Update, Delete)
   public static void dbClose(Connection con, Statement st) {
      try {
         if(st!=null)
            st.close();
         if(con!=null)
            con.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   // 닫기 (DQL : SELECT인 경우)
   public static void dbClose(Connection con, Statement st, ResultSet rs) {
      try {
         if(rs!=null)
            rs.close();
         dbClose(con, st);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
}
