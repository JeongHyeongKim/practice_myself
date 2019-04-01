package ex0401;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest extends HashMap<String, Student> {

	public MapTest() {
		//map추가
		super.put("갈매기",new Student("1호",1,"부산"));
		super.put("가르매기",new Student("2호",2,"대구"));
		super.put("갈매기",new Student("3호",3,"서울")); // 중복 key이면 수정된다.
		super.put("그아르매기",new Student("4호",4,"므싯다"));
		
		System.out.println("개수 : "+super.size());
		
		//모든 key의 정보를 찾아야 한다.
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
		m.searchByKey("갈매기");
		System.out.println();
		m.searchByKey("과메기");

	}

}
