package ex0401;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest extends HashMap<String, Student> {

	public MapTest() {
		//map�߰�
		super.put("���ű�",new Student("1ȣ",1,"�λ�"));
		super.put("�����ű�",new Student("2ȣ",2,"�뱸"));
		super.put("���ű�",new Student("3ȣ",3,"����")); // �ߺ� key�̸� �����ȴ�.
		super.put("�׾Ƹ��ű�",new Student("4ȣ",4,"�ǽ˴�"));
		
		System.out.println("���� : "+super.size());
		
		//��� key�� ������ ã�ƾ� �Ѵ�.
		Iterator<String> keys= super.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			Student value = super.get(key);
			System.out.println(key+" "+value);
		}
	}
	
	public void searchByKey(String key) {
		boolean result = super.containsKey(key);
		
		Student student = super.get(key);
		
		if(student==null) {
			System.out.println(key+" -> no information");
		}else {
			System.out.println(student);
		}
	}
	
	
	public static void main(String[] args) {
		MapTest m = new MapTest();
		System.out.println("Search");
		m.searchByKey("���ű�");
		System.out.println();
		m.searchByKey("���ޱ�");

	}

}
