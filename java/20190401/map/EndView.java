package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import map.Student;;

public class EndView {
  /**
   * 전체 출력
   * */
	public static void printAll(Map<String, Person> map) {
		System.out.println("********전체 검색 LIST ************");
		Iterator<String> keys= map.keySet().iterator();
		while(keys.hasNext()) {
			String key=keys.next();
			if (map.get(key) instanceof Student) {
				Student buf = new Student();
				buf = (Student) map.get(key);
				
				System.out.println("이름 : "+key+" / 총점 : "+(buf.getKor()+buf.getEng()+buf.getMath()));
			}
			else {
				System.out.println("이름 : "+key);
			}
			
		}
		
	}
	
	/**
	 * key에해당하는 정보 출력
	 *  [ Person인경우는 이름만 출력
	 *     Student인경우는 이름과 총점 출력 ] 
	 * */
	public static void printSearch(Person person) {
		if (person instanceof Student) {
			Student buf = new Student();
			buf = (Student) person;
			
			System.out.println("이름 : "+buf.getName()+" / 총점 : "+(buf.getKor()+buf.getEng()+buf.getMath()));
		}
		else {
			System.out.println("이름 : "+person.getName());
		}
	}

   public static void printMessage(String message) {
	 System.out.println(message);
	
  }
}





