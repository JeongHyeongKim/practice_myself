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
		pro.put("������","�λ�");
		pro.put("age","20");
		pro.put("addr","�ȱ���");
		pro.put("num","1111");
		
		//������ ��ȸ
		Set<Object> set = pro.keySet();
		Iterator<Object> it = pro.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = pro.getProperty(key);
			
			System.out.println(key + " = "+value);
		}
		
		//pro.getProperty(key);
	}//������ ��
	
	public void test() throws FileNotFoundException, IOException {
		pro.clear(); // ������Ƽ ����
		pro.load(new FileInputStream("src/ex0401/dbinfo.properties"));
		//�ܺ� ~.properties���� �ε��ϱ�
		
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
