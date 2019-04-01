package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import map.Student;;

public class EndView {
  /**
   * ��ü ���
   * */
	public static void printAll(Map<String, Person> map) {
		System.out.println("********��ü �˻� LIST ************");
		Iterator<String> keys= map.keySet().iterator();
		while(keys.hasNext()) {
			String key=keys.next();
			if (map.get(key) instanceof Student) {
				Student buf = new Student();
				buf = (Student) map.get(key);
				
				System.out.println("�̸� : "+key+" / ���� : "+(buf.getKor()+buf.getEng()+buf.getMath()));
			}
			else {
				System.out.println("�̸� : "+key);
			}
			
		}
		
	}
	
	/**
	 * key���ش��ϴ� ���� ���
	 *  [ Person�ΰ��� �̸��� ���
	 *     Student�ΰ��� �̸��� ���� ��� ] 
	 * */
	public static void printSearch(Person person) {
		if (person instanceof Student) {
			Student buf = new Student();
			buf = (Student) person;
			
			System.out.println("�̸� : "+buf.getName()+" / ���� : "+(buf.getKor()+buf.getEng()+buf.getMath()));
		}
		else {
			System.out.println("�̸� : "+person.getName());
		}
	}

   public static void printMessage(String message) {
	 System.out.println(message);
	
  }
}





