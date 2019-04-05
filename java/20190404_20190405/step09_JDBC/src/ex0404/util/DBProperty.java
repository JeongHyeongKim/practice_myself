package ex0404.util;


/**
 *DB관련 설정정보를 상수필드로 관리하는 interface
 */
public interface DBProperty {
 // 안에있는건 퍼블릭 스태틱 파이널 
	String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	String USER_NAME="hr";
	String USER_PASS="hr";
	
}
