package ex0401;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	Properties pro = new Properties();
	
	public PropertiesTest() {
		//add data
		pro.put("갈개미","부산");
		pro.put("age","20");
		pro.put("addr","안국역");
		pro.put("num","1111");
		
		//데이터 조회
		Set<Object> set = pro.keySet();
		Iterator<Object> it = pro.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = pro.getProperty(key);
			
			System.out.println(key + " = "+value);
		}
		
		//pro.getProperty(key);
	}//생성자 끝
	
	public void test() throws FileNotFoundException, IOException {
		pro.clear(); // 프로퍼티 비우기
		pro.load(new FileInputStream("src/ex0401/dbinfo.properties"));
		//외부 ~.properties파일 로딩하기
		
		Set<Object> set = pro.keySet();
		Iterator<Object> it = pro.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = pro.getProperty(key);
			
			System.out.println(key + " = "+value);
		}
		
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PropertiesTest pt = new PropertiesTest();
		System.out.println("--------------------------------------------------");
		pt.test();
		
	}

	
}
