package ex0404.util;


/**
 *DB���� ���������� ����ʵ�� �����ϴ� interface
 */
public interface DBProperty {
 // �ȿ��ִ°� �ۺ� ����ƽ ���̳� 
	String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	String USER_NAME="hr";
	String USER_PASS="hr";
	
}
